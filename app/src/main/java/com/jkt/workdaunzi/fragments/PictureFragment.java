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
import com.jkt.workdaunzi.adpaters.PictureFragmentAdapter;
import com.jkt.workdaunzi.customviews.MyLinearLayoutManager;
import com.jkt.workdaunzi.models.PictureModel;

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
public class PictureFragment extends Fragment implements INetView, IJsonView, SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private File mFile;
    private int mLastVisibleItem;
    private MyLinearLayoutManager mLayoutManager;
    private PictureFragmentAdapter mPictureFragmentAdapter;
    private int mPage = 1;
    private List<PictureModel.DataBean.DataBean1> mDataBean1List;
    private boolean mRefreshing;

    public PictureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_picture, container, false);
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
        mPictureFragmentAdapter = new PictureFragmentAdapter(getContext(), mDataBean1List);
        mRecyclerView.setAdapter(mPictureFragmentAdapter);
    }

    private void initNet() {
        mPage = 1;
        mRefreshLayout.setRefreshing(true);
        String url = "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-103&message_cursor=-1&am_longitude=116.369552&am_latitude=40.037426&am_city=%E5%8C%97%E4%BA%AC%E5%B8%82&am_loc_time=1478509009013&count=30&min_time=1478487147&screen_width=1152&iid=6178987393&device_id=6092032765&ac=wifi&channel=meizu&aid=7&app_name=joke_essay&version_code=570&version_name=5.7.0&device_platform=android&ssmix=a&device_type=MX4&device_brand=Meizu&os_api=22&os_version=5.1&uuid=865479029646411&openudid=aad381b0192fcbca&manifest_version_code=570&resolution=1152*1920&dpi=480&update_version_code=5701";
        new NetPresenter(this, "PictureModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initListeners() {
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        mLastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                        if (mLastVisibleItem == mPictureFragmentAdapter.getItemCount() - 1 && !mRefreshing) {
                            initMoreNet();
                        }
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        mLastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                        if (mLastVisibleItem == mPictureFragmentAdapter.getItemCount() - 1 && !mRefreshing) {
                            initMoreNet();
                        }
                    }
                }

        );
    }

    private void initMoreNet() {
        mRefreshing = true;
        mPage++;
        String url = "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-103&message_cursor=-1&am_longitude=116.369552&am_latitude=40.037426&am_city=%E5%8C%97%E4%BA%AC%E5%B8%82&am_loc_time=1478509009013&count=30&min_time=1478487147&screen_width=1152&iid=6178987393&device_id=6092032765&ac=wifi&channel=meizu&aid=7&app_name=joke_essay&version_code=570&version_name=5.7.0&device_platform=android&ssmix=a&device_type=MX4&device_brand=Meizu&os_api=22&os_version=5.1&uuid=865479029646411&openudid=aad381b0192fcbca&manifest_version_code=570&resolution=1152*1920&dpi=480&update_version_code=5701";
        new NetPresenter(this, "PictureModel").getNetByteByOkHttp3(url,
                "GET", null, null, null);
    }

    private void initRecyclerViewLayout() {
        mLayoutManager = new MyLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initViews(View inflate) {
        mRefreshLayout = ((SwipeRefreshLayout) inflate.findViewById(R.id.fragment_picture_refreshLayout));
        mRecyclerView = ((RecyclerView) inflate.findViewById(R.id.fragment_picture_recyclerView));
    }

    @Override
    public void onRefresh() {
        initNet();
    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        mRefreshLayout.setRefreshing(false);
        mRefreshing = false;
        Log.i("PictureModel", "成功获得网络");
        switch (mark) {
            case "PictureModel":
                if (mPage == 1 && bytes.length > 100) {
                    saveDataFile(bytes);
                }
                try {
                    new JsonPresenter(this, PictureModel.class, "PictureModel")
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
        Log.i("PictureModel", "解析成功");
        switch (mark) {
            case "PictureModel":
                Log.i("PictureModel", object.toString());
                if (object != null && object instanceof PictureModel) {
                    PictureModel pictureModel = (PictureModel) object;
                    initRecyclerViewData(pictureModel);
                }
                break;
        }
    }

    private void initRecyclerViewData(PictureModel pictureModel) {
        if (pictureModel.getData() == null || pictureModel.getData().getData() == null) {
            return;
        }
        List<PictureModel.DataBean.DataBean1> listBeanList = pictureModel.getData().getData();
        if (listBeanList != null && listBeanList.size() > 0) {
            if (mPage == 1) {
                mDataBean1List.clear();
            }
            for (int i = 0; i < listBeanList.size(); i++) {
                if (listBeanList.get(i).getType() == 1) {
                    if (listBeanList.get(i).getGroup() != null && listBeanList.get(i).getGroup().getType() == 3) {
                        if (listBeanList.get(i).getGroup().getMiddle_image() != null && listBeanList.get(i).getGroup().getMiddle_image().getHeight() <= 800) {
                            mDataBean1List.add(listBeanList.get(i));
                        }
                    }
                }
            }
            mPictureFragmentAdapter.notifyDataSetChanged();
        }
    }


    private void initCacheData() {
        File filesDir = getContext().getFilesDir();
        if (filesDir == null) {
            filesDir.mkdir();
        }
        if (filesDir != null) {
            mFile = new File(filesDir, "PictureModel");
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
                    new JsonPresenter(this, PictureModel.class, "PictureModel")
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
            mFile = new File(filesDir, "PictureModel");
            try {
                FileOutputStream outputStream = new FileOutputStream(mFile);
                outputStream.write(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}