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
import com.jkt.workdaunzi.adpaters.TechnologyFragmenAdapter;
import com.jkt.workdaunzi.customviews.MyScrollView;
import com.jkt.workdaunzi.models.TechnologyModel;

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
public class TechnologyFragment extends Fragment implements INetView, IJsonView, SwipeRefreshLayout.OnRefreshListener, MyScrollView.IScrollListener, View.OnClickListener {


    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String mString;
    private File mFile;
    private FrameLayout mFrameLayout;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private Button mButton;
    private MyScrollView mMyScrollView;
    private int mY;
    private DisplayMetrics mOutMetrics;
    private int mHeightPixels;
    private int[] mLocation;
    private int mPage = 1;
    private int mAllPage = 1;
    private int mCurrentPage;
    private List<TechnologyModel.ItemBean> mItemBeanList;
    private TechnologyFragmenAdapter mAdapter;
    private boolean mGetMoreing;
    private TextView mFinishTextView;


    public TechnologyFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_technology, container, false);
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
        mItemBeanList = new ArrayList<>();
        mAdapter = new TechnologyFragmenAdapter(mItemBeanList, getContext());
        mRecyclerView.setAdapter(mAdapter);
    }


    private void initListeners() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mMyScrollView.setIScrollListener(this);
        mButton.setOnClickListener(this);

    }

    private void initNet() {
        mPage = 1;
        mSwipeRefreshLayout.setRefreshing(true);
        String url = "http://api.iclient.ifeng.com/ClientNews?id=KJ123,FOCUSKJ123&page=1&gv=4.4.1&av=4.4.1&uid=865479029646411&deviceid=865479029646411&proid=ifengnews&os=android_22&df=androidphone&vt=5&screen=1152x1920&publishid=2024";
        new NetPresenter(this, "TechnologyModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initViews(View inflate) {
        mRecyclerView = ((RecyclerView) inflate.findViewById(R.id.fragment_technology_recyclerView));
        mSwipeRefreshLayout = ((SwipeRefreshLayout) inflate.findViewById(R.id.fragment_technology_refreshLayout));
        mFrameLayout = ((FrameLayout) inflate.findViewById(R.id.fragment_technology_FrameLayout));
        mProgressBar = ((ProgressBar) inflate.findViewById(R.id.fragment_technology_progressBar));
        mTextView = ((TextView) inflate.findViewById(R.id.fragment_technology_textView));
        mButton = ((Button) inflate.findViewById(R.id.fragment_technology_button));
        mMyScrollView = ((MyScrollView) inflate.findViewById(R.id.fragment_technology_myScrollView));
        mFinishTextView = ((TextView) inflate.findViewById(R.id.fragment_technology_finishTextView));
    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        mSwipeRefreshLayout.setRefreshing(false);
        mGetMoreing = false;
        Log.i("TechnologyModel", "成功获得网络");
        switch (mark) {
            case "TechnologyModel":
                if (mPage == 1) {
                    saveDataFile(bytes);
                }
                try {
                    new JsonPresenter(this, TechnologyModel.class, "TechnologyModel")
                            .parseJsonByGson(new String(bytes, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    @Override
    public void getNetFail(Exception e) {
        mSwipeRefreshLayout.setRefreshing(false);
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
        Log.i("TechnologyModel", "成功获得json");
        switch (mark) {
            case "TechnologyModel":
                initRecyclerViewData(object);
                break;
        }
    }

    private void initRecyclerViewData(Object object) {
        if (object != null && object instanceof TechnologyModel) {
            TechnologyModel technologyModel = (TechnologyModel) object;
            List<TechnologyModel.ItemBean> itemBeanList = technologyModel.getItem();

            if (itemBeanList != null && itemBeanList.size() > 0) {
                if (mPage == 1) {
                    mAllPage = technologyModel.getTotalPage();
                    mProgressBar.setVisibility(View.VISIBLE);
                    mTextView.setVisibility(View.VISIBLE);
                    mButton.setVisibility(View.INVISIBLE);
                    mFinishTextView.setVisibility(View.INVISIBLE);
                    mItemBeanList.clear();
                }
                if (mPage < mAllPage) {
                    mItemBeanList.addAll(itemBeanList);
                    mAdapter.notifyDataSetChanged();
                } else if (mPage == mAllPage) {
                    mItemBeanList.addAll(itemBeanList);
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
        LinearLayoutManager layout = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layout);
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        initNet();
    }

    private void initCacheData() {
        File filesDir = getContext().getFilesDir();
        if (filesDir == null) {
            filesDir.mkdir();
        }
        if (filesDir != null) {
            mFile = new File(filesDir, "TechnologyModel");
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
                    new JsonPresenter(this, TechnologyModel.class, "TechnologyModel")
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
            mFile = new File(filesDir, "TechnologyModel");
            try {
                FileOutputStream outputStream = new FileOutputStream(mFile);
                outputStream.write(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    public void scrollChanged(MyScrollView myScrollView, int l, int t, int oldl, int oldt) {

        mFrameLayout.getLocationOnScreen(mLocation);
        mY = mLocation[1];
        if (Math.abs(mY) <= mHeightPixels && !mGetMoreing && mPage < mAllPage) {
            initMoreNet();
        }
    }

    private void initMoreNet() {
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.INVISIBLE);
        mGetMoreing = true;
        mPage++;
        String url = "http://api.iclient.ifeng.com/ClientNews?id=KJ123,FOCUSKJ123&page=" +
                mPage +
                "&gv=4.4.1&av=4.4.1&uid=865479029646411&deviceid=865479029646411&proid=ifengnews&os=android_22&df=androidphone&vt=5&screen=1152x1920&publishid=2024";
        new NetPresenter(this, "TechnologyModel").getNetByteByOkHttp3(url,
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
}