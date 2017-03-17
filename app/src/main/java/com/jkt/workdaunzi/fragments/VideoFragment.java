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
import com.jkt.workdaunzi.adpaters.VideoFragmentAdapter;
import com.jkt.workdaunzi.customviews.MyLinearLayoutManager;
import com.jkt.workdaunzi.models.VideoModel;

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
public class VideoFragment extends Fragment implements INetView, IJsonView, SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private File mFile;
    private int mLastVisibleItem;
    private MyLinearLayoutManager mLayoutManager;
    private VideoFragmentAdapter mVideoFragmentAdapter;
    private int mPage = 1;
    private List<VideoModel.DataBean.DataBean1> mDataBean1List;
    private boolean mRefreshing;

    public VideoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_video, container, false);
        initViews(inflate);
        initRecyclerViewLayout();
        initRecyclerViewAdapter();
        initCacheData();
        initNet();
        initListeners();
        return inflate;
    }

    private void initRecyclerViewAdapter() {
        mDataBean1List = new ArrayList<>();
        mVideoFragmentAdapter = new VideoFragmentAdapter(getActivity(), mDataBean1List);
        mRecyclerView.setAdapter(mVideoFragmentAdapter);
    }

    private void initNet() {
        mPage = 1;
        mRefreshLayout.setRefreshing(true);
        String url = "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-104&message_cursor=-1";
        new NetPresenter(this, "VideoModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initListeners() {
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        mLastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                        if (mLastVisibleItem == mVideoFragmentAdapter.getItemCount() - 1 && !mRefreshing) {
                            initMoreNet();
                        }
                        if (mVideoFragmentAdapter.getVideoViewHolder() != null) {
                            mVideoFragmentAdapter.getVideoViewHolder().videoReset();
                        }
                    }
                }

        );
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void initMoreNet() {
        mRefreshing = true;
        mPage++;
        String url = "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-104&message_cursor=-1";
        new NetPresenter(this, "VideoModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initRecyclerViewLayout() {
        mLayoutManager = new MyLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initViews(View inflate) {
        mRefreshLayout = ((SwipeRefreshLayout) inflate.findViewById(R.id.fragment_video_refreshLayout));
        mRecyclerView = ((RecyclerView) inflate.findViewById(R.id.fragment_video_recyclerView));
    }

    @Override
    public void onRefresh() {
        initNet();
    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        mRefreshLayout.setRefreshing(false);
        mRefreshing = false;
        Log.i("VideoModel", "成功获得网络");
        switch (mark) {
            case "VideoModel":
                if (mPage == 1 && bytes.length > 100) {
                    saveDataFile(bytes);
                }
                try {
                    new JsonPresenter(this, VideoModel.class, "VideoModel")
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
        Log.i("VideoModel", "解析成功");
        switch (mark) {
            case "VideoModel":
                Log.i("VideoModel", object.toString());
                if (object != null && object instanceof VideoModel) {
                    VideoModel videoModel = (VideoModel) object;
                    initRecyclerViewData(videoModel);
                }
                break;
        }
    }

    private void initRecyclerViewData(VideoModel videoModel) {
        if (videoModel.getData() == null || videoModel.getData().getData() == null) {
            return;
        }
        List<VideoModel.DataBean.DataBean1> listBeanList = videoModel.getData().getData();
        if (listBeanList != null && listBeanList.size() > 0) {
            if (mPage == 1) {
                mDataBean1List.clear();
            }
            for (int i = 0; i < listBeanList.size(); i++) {
                if (listBeanList.get(i).getType() == 1) {
                    if (listBeanList.get(i).getGroup() != null && listBeanList.get(i).getGroup().getType() == 2) {
                        if (listBeanList.get(i).getGroup().getA480p_video().getHeight() <= 400) {
                            mDataBean1List.add(listBeanList.get(i));
                        }
                    }
                }
            }
            mVideoFragmentAdapter.notifyDataSetChanged();
        }
    }


    private void initCacheData() {
        File filesDir = getContext().getFilesDir();
        if (filesDir == null) {
            filesDir.mkdir();
        }
        if (filesDir != null) {
            mFile = new File(filesDir, "VideoModel");
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
                    new JsonPresenter(this, VideoModel.class, "VideoModel")
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
            mFile = new File(filesDir, "VideoModel");
            try {
                FileOutputStream outputStream = new FileOutputStream(mFile);
                outputStream.write(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}