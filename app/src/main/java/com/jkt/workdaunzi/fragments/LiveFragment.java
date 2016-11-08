package com.jkt.workdaunzi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkt.workdaunzi.Presenters.JsonPresenter;
import com.jkt.workdaunzi.Presenters.NetPresenter;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.View.INetView;
import com.jkt.workdaunzi.adpaters.LiveFragmentAdapter;
import com.jkt.workdaunzi.models.LiveModel;
import com.jkt.workdaunzi.tool.Ui;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, INetView, IJsonView {


    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private File mFile;
    private int mLastVisibleItem;
    private LinearLayoutManager mLayoutManager;
    private LiveFragmentAdapter mHotFragmentAdapter;
    private int mPage = 1;
    private List<LiveModel.DataBean.ListBean> mListBeanList = new ArrayList<>();
    private int mAll_page;
    private boolean mRefreshing;

    public LiveFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        String url = "http://live.9158.com/Room/GetNewRoomOnline?page=1";
        new NetPresenter(this, "LiveModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_live, container, false);
        initViews(inflate);
        initRecyclerViewLayout();
        initCacheData();
        initNet();
        initListeners();
        return inflate;
    }

    private void initNet() {
        mPage = 1;
        mRefreshLayout.setRefreshing(true);
        String url = "http://live.9158.com/Room/GetHotLive_v2?lon=0.0&province=&lat=0.0&page=1&type=1";
        new NetPresenter(this, "LiveModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initListeners() {
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if (newState == RecyclerView.SCROLL_STATE_IDLE
                                &&mHotFragmentAdapter!=null && mLastVisibleItem + 1 == mHotFragmentAdapter.getItemCount()) {
                            if (mPage < mAll_page && !mRefreshing) {
                                initMoreNet();
                            }
                        }
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        mLastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                    }
                }

        );
    }

    private void initMoreNet() {
        mRefreshing = true;
        mPage++;
        mRefreshLayout.setRefreshing(true);
        String url = "http://live.9158.com/Room/GetHotLive_v2?lon=0.0&province=&lat=0.0&page=1&type=" + mPage;
        new NetPresenter(this, "LiveModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initRecyclerViewLayout() {
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initViews(View inflate) {
        mRefreshLayout = ((SwipeRefreshLayout) inflate.findViewById(R.id.fragment_live_refreshLayout));
        mRecyclerView = ((RecyclerView) inflate.findViewById(R.id.fragment_live_recyclerView));
    }

    @Override
    public void onRefresh() {
        initNet();
    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        mRefreshLayout.setRefreshing(false);
        Log.i("LiveModel", "成功获得网络");
        switch (mark) {
            case "LiveModel":
                if (mPage == 1) {
                    saveDataFile(bytes);
                }
                try {
                    new JsonPresenter(this, LiveModel.class, "LiveModel")
                            .parseJsonByGson(new String(bytes, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void getNetFail(Exception e) {
        Log.i("TTT", "获取网络失败");
        mRefreshing = false;
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void getModelListByJson(List list, String mark) {

    }

    @Override
    public void getModelObjectByJson(Object object, String mark) {
        Log.i("LiveModel", "解析成功");
        switch (mark) {
            case "LiveModel":
                if (object != null && object instanceof LiveModel) {
                    LiveModel hotModel = (LiveModel) object;
                    initRecyclerViewData(hotModel);
                }
                break;
        }
    }

    private void initRecyclerViewData(LiveModel hotModel) {
        mAll_page = hotModel.getData().getTotalPage();
        Log.i("LiveModel", hotModel.toString());
        List<LiveModel.DataBean.ListBean> listBeanList = hotModel.getData().getList();
        Log.i("LiveModel", listBeanList.size() + "");
        if (mPage != 1) {
            mListBeanList.addAll(listBeanList);
            mHotFragmentAdapter.notifyDataSetChanged();
            float px = Ui.Dp2Px(getActivity(), -100);
            mRecyclerView.offsetChildrenVertical(((int) px));
            mRefreshing = false;
            return;
        } else {
            mListBeanList.clear();
            mListBeanList = listBeanList;
        }
        mHotFragmentAdapter = new LiveFragmentAdapter(getContext(), mListBeanList);
        mRecyclerView.setAdapter(mHotFragmentAdapter);
        mHotFragmentAdapter.notifyDataSetChanged();
    }


    private void initCacheData() {
        File filesDir = getContext().getFilesDir();
        if (filesDir == null) {
            filesDir.mkdir();
        }
        if (filesDir != null) {
            mFile = new File(filesDir, "LiveModel");
            if (mFile != null && mFile.length() >= 0) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(mFile);
                    byte[] bytes = new byte[1024];
                    int length = 0;
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    while ((length = fileInputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, length);
                    }
                    byte[] byteArray = outputStream.toByteArray();
                    new JsonPresenter(this, LiveModel.class, "LiveModel")
                            .parseJsonByGson(new String(byteArray, "utf-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void saveDataFile(byte[] bytes) {
        if (mFile != null && mFile.exists() && mFile.length() > 0) {
            mFile.delete();
        }
        File filesDir = getContext().getFilesDir();
        if (filesDir == null) {
            filesDir.mkdir();
        }
        if (filesDir != null) {
            mFile = new File(filesDir, "LiveModel");
            try {
                FileOutputStream outputStream = new FileOutputStream(mFile);
                outputStream.write(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
