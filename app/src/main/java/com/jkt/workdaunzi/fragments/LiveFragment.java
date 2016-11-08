package com.jkt.workdaunzi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jkt.workdaunzi.Presenters.JsonPresenter;
import com.jkt.workdaunzi.Presenters.NetPresenter;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.View.INetView;
import com.jkt.workdaunzi.adpaters.LiveFragmentAdapter;
import com.jkt.workdaunzi.customviews.MyScrollView;
import com.jkt.workdaunzi.models.LiveModel;

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
public class LiveFragment extends Fragment implements INetView, IJsonView, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, MyScrollView.IScrollListener {


    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private File mFile;
    private FrameLayout mFrameLayout;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private Button mButton;
    private int mY;
    private int mHeightPixels;
    private int[] mLocation;
    private int mPage = 1;
    private int mAllPage = 1;
    private List<LiveModel.DataBean.ListBean> mListBeanList;
    private LiveFragmentAdapter mAdapter;
    private boolean mGetMoreing;
    private TextView mFinishTextView;
    private int mLastVisibleItem;
    private LinearLayoutManager mLayoutManager;
    private MyScrollView mMyScrollView;


    public LiveFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_live, container, false);
        initViews(inflate);
        initRecyclerViewLayout();
        initRecyclerViewAdapter();
        initMeasurePixels();
        initListeners();
        initCacheData();
        initNet();

        return inflate;
    }

    private void initRecyclerViewAdapter() {
        mListBeanList = new ArrayList<>();
        mAdapter = new LiveFragmentAdapter(getContext(), mListBeanList);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void initListeners() {

        mRefreshLayout.setOnRefreshListener(this);
        mMyScrollView.setIScrollListener(this);
        mButton.setOnClickListener(this);

    }

    private void initNet() {
        mPage = 1;
        mRefreshLayout.setRefreshing(true);
        String url = "http://live.9158.com/Room/GetHotLive_v2?lon=0.0&province=&lat=0.0&page=1&type=1";
        new NetPresenter(this, "LiveModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initViews(View inflate) {
        mRecyclerView = ((RecyclerView) inflate.findViewById(R.id.fragment_live_recyclerView));
        mMyScrollView = ((MyScrollView) inflate.findViewById(R.id.fragment_live_myScrollView));
        mRefreshLayout = ((SwipeRefreshLayout) inflate.findViewById(R.id.fragment_live_refreshLayout));
        mFrameLayout = ((FrameLayout) inflate.findViewById(R.id.fragment_live_FrameLayout));
        mProgressBar = ((ProgressBar) inflate.findViewById(R.id.fragment_live_progressBar));
        mTextView = ((TextView) inflate.findViewById(R.id.fragment_live_textView));
        mButton = ((Button) inflate.findViewById(R.id.fragment_live_button));
        mFinishTextView = ((TextView) inflate.findViewById(R.id.fragment_live_finishTextView));
    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        mRefreshLayout.setRefreshing(false);
        mGetMoreing = false;
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
        mRefreshLayout.setRefreshing(false);
        mButton.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.INVISIBLE);
        mTextView.setVisibility(View.INVISIBLE);
        mGetMoreing = false;
    }

    @Override
    public void getModelListByJson(List list, String mark) {

    }

    @Override
    public void getModelObjectByJson(Object object, String mark) {
        Log.i("LiveModel", "成功获得json");
        switch (mark) {
            case "LiveModel":
                Log.i("LiveModel", "成功获得json..");
                initRecyclerViewData(object);
                break;
        }
    }

    private void initRecyclerViewData(Object object) {
        if (object != null && object instanceof LiveModel) {
            LiveModel liveModel = (LiveModel) object;
            List<LiveModel.DataBean.ListBean> itemBeanList = liveModel.getData().getList();
            if (itemBeanList != null && itemBeanList.size() > 0) {
                if (mPage == 1) {
                    mAllPage = liveModel.getData().getTotalPage();
                    mProgressBar.setVisibility(View.VISIBLE);
                    mTextView.setVisibility(View.VISIBLE);
                    mButton.setVisibility(View.INVISIBLE);
                    mFinishTextView.setVisibility(View.INVISIBLE);
                    mListBeanList.clear();
                }
                if (mPage < mAllPage) {
                    mListBeanList.addAll(itemBeanList);
                    mAdapter.notifyDataSetChanged();
                } else if (mPage == mAllPage) {
                    mListBeanList.addAll(itemBeanList);
                    mAdapter.notifyDataSetChanged();
                    mFinishTextView.setVisibility(View.VISIBLE);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mButton.setVisibility(View.INVISIBLE);
                    mTextView.setVisibility(View.INVISIBLE);
                }
            } else {
                mProgressBar.setVisibility(View.INVISIBLE);
                mTextView.setVisibility(View.INVISIBLE);
                mButton.setVisibility(View.VISIBLE);
            }
        }
    }

    private void initRecyclerViewLayout() {
        mLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(true);
        initNet();
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
        if (mFile.exists() && mFile.length() > 0) {
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


    private void initMoreNet() {
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.INVISIBLE);
        mGetMoreing = true;
        mPage++;
        String url = "http://live.9158.com/Room/GetHotLive_v2?lon=0.0&province=&lat=0.0&page=" + mPage + "&type=1";
        new NetPresenter(this, "LiveModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initMeasurePixels() {
        mLocation = new int[2];
        DisplayMetrics mOutMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(mOutMetrics);
        mHeightPixels = mOutMetrics.heightPixels;

    }

    @Override
    public void onClick(View v) {
        initMoreNet();
    }

    @Override
    public void scrollChanged(MyScrollView myScrollView, int l, int t, int oldl, int oldt) {
        mFrameLayout.getLocationOnScreen(mLocation);
        mY = mLocation[1];
        if (Math.abs(mY) <= mHeightPixels && !mGetMoreing && mPage < mAllPage) {
            initMoreNet();
        }
    }
}