package com.jkt.workdaunzi;

import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jkt.workdaunzi.Presenters.JsonPresenter;
import com.jkt.workdaunzi.Presenters.NetPresenter;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.View.INetView;
import com.jkt.workdaunzi.adpaters.Topic2ActivityAdapter;
import com.jkt.workdaunzi.models.Topic2Model;

import java.util.ArrayList;
import java.util.List;

public class Topic2Activity extends AppCompatActivity implements INetView, IJsonView {

    private RecyclerView mRecyclerView;
    private String mId;
    private ProgressBar mProgressBar;
    private TextView mHideTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        initViews();
        initRecyclerView();
        getTheIntent();
        initNet();
    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
    }

    private void getTheIntent() {
        if (getIntent() != null && getIntent().getStringExtra("id") != null) {
            mId = getIntent().getStringExtra("id");
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initViews() {
        setContentView(R.layout.activity_topic2);
        mRecyclerView = ((RecyclerView) findViewById(R.id.topic2_recyclerView));
        mProgressBar = ((ProgressBar) findViewById(R.id.topic2_progress));
        mHideTextView = ((TextView) findViewById(R.id.topic2_hideTextView));
    }

    private void initNet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null || !networkInfo.isConnected()) {
                mHideTextView.setText("当前无网络连接~");
                mProgressBar.setVisibility(View.GONE);
                return;
            }
        }
        Log.i("TTT", mId);
        new NetPresenter(this, "Topic2Model").getNetByteByOkHttp3(
                mId,
                "GET",
                null, null, null
        );
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        switch (mark) {
            case "Topic2Model":
                try {
                    Log.i("TTT", "net success");
                    new JsonPresenter(this, Topic2Model.class, "Topic2Model")
                            .parseJsonByGson(new String(bytes));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void getNetFail(Exception e) {
        Log.i("TTT", "net fail");
        mHideTextView.setText("加载失败了~");
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void getModelListByJson(List list, String mark) {

    }

    @Override
    public void getModelObjectByJson(Object object, String mark) {
        switch (mark) {
            case "Topic2Model":
                if (object != null && object instanceof Topic2Model) {
                    Topic2Model topic2Model = (Topic2Model) object;
                    initData(topic2Model);
                    Log.i("TTT", "json");
                } else {
                    mHideTextView.setText("数据丢失啦~");
                    mProgressBar.setVisibility(View.GONE);
                }
                break;
        }
    }

    private void initData(Topic2Model topic2Model) {
        mHideTextView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
        Log.i("TTT", topic2Model.toString());
        List<Topic2Model.BodyBean.SubjectsBean.PodItemsBean> podItems = getPodItems(topic2Model);
        Topic2ActivityAdapter adapter = new Topic2ActivityAdapter(podItems, this);
        Log.i("TTTT", podItems.size() + "");
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setVisibility(View.VISIBLE);

    }

    private List<Topic2Model.BodyBean.SubjectsBean.PodItemsBean> getPodItems(Topic2Model topic2Model) {

        List<Topic2Model.BodyBean.SubjectsBean.PodItemsBean> podItems = new ArrayList<>();
        List<Topic2Model.BodyBean.SubjectsBean> subjectsBeanList = topic2Model.getBody().getSubjects();
        for (int i = 0; i < subjectsBeanList.size(); i++) {
            Topic2Model.BodyBean.SubjectsBean subjectsBean = subjectsBeanList.get(i);
            List<Topic2Model.BodyBean.SubjectsBean.PodItemsBean> podItemsBeanList = subjectsBean.getPodItems();
            if (podItemsBeanList != null) {
                for (int j = 0; j < podItemsBeanList.size(); j++) {
                    Topic2Model.BodyBean.SubjectsBean.PodItemsBean podItemsBean = podItemsBeanList.get(j);
                    podItems.add(podItemsBean);
                }
            }
        }
        return podItems;
    }
}
