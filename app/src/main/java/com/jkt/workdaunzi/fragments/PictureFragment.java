package com.jkt.workdaunzi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkt.workdaunzi.Presenters.JsonPresenter;
import com.jkt.workdaunzi.Presenters.NetPresenter;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.View.INetView;
import com.jkt.workdaunzi.models.PictureModel;

import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment implements INetView, IJsonView, SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout mRefreshLayout;

    public PictureFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_picture, container, false);
        initViews(inflate);
        initNet();
        initListeners();

        return inflate;
    }

    private void initListeners() {
        mRefreshLayout.setOnRefreshListener(this);
    }

    private void initNet() {
        mRefreshLayout.setRefreshing(true);
        new NetPresenter(this, "PictureModel")
                .getNetByteByOkHttp3(
                        "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-103&message_cursor=-1&am_longitude=116.369552&am_latitude=40.037426&am_city=%E5%8C%97%E4%BA%AC%E5%B8%82&am_loc_time=1478509009013&count=30&min_time=1478487147&screen_width=1152&iid=6178987393&device_id=6092032765&ac=wifi&channel=meizu&aid=7&app_name=joke_essay&version_code=570&version_name=5.7.0&device_platform=android&ssmix=a&device_type=MX4&device_brand=Meizu&os_api=22&os_version=5.1&uuid=865479029646411&openudid=aad381b0192fcbca&manifest_version_code=570&resolution=1152*1920&dpi=480&update_version_code=5701"
                        , "GET"
                        , null
                        , null
                        , null
                );
    }

    private void initViews(View inflate) {
        mRefreshLayout = ((SwipeRefreshLayout) inflate.findViewById(R.id.fragment_picture_refreshLayout));
    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        mRefreshLayout.setRefreshing(false);
        Log.i("ttt", "获取网络成功");
        switch (mark) {
            case "PictureModel":
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
        Log.i("ttt", "获取网络失败");
        mRefreshLayout.setRefreshing(false);

    }

    @Override
    public void getModelListByJson(List list, String mark) {
    }

    @Override
    public void getModelObjectByJson(Object object, String mark) {
        Log.i("ttt", object.toString());

    }

    @Override
    public void onRefresh() {
        initNet();
    }
}
