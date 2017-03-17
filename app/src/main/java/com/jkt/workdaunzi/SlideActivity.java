package com.jkt.workdaunzi;

import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jkt.workdaunzi.Presenters.JsonPresenter;
import com.jkt.workdaunzi.Presenters.NetPresenter;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.View.INetView;
import com.jkt.workdaunzi.adpaters.SlideActivityAdapter;
import com.jkt.workdaunzi.models.SlideModel;

import java.util.List;

public class SlideActivity extends AppCompatActivity implements INetView, IJsonView {

    private TextView mHideTextView;
    private ProgressBar mProgressBar;
    private ViewPager mViewPager;
    private String mAidString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        initViews();
        getTheIntent();
        initNet();
    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
    }

    private void getTheIntent() {
        if (getIntent() != null && getIntent().getStringExtra("aid") != null) {
            mAidString = getIntent().getStringExtra("aid");
        }
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
        new NetPresenter(this, "SlideModel").getNetByteByOkHttp3(
                "http://api.iclient.ifeng.com/ipadtestdoc?aid=" +
                        mAidString +
                        "&gv=4.4.1&av=4.4.1&uid=865479029646411&deviceid=865479029646411&proid=ifengnews&os=android_22&df=androidphone&vt=5&screen=1152x1920&publishid=2024",
                "GET",
                null, null, null
        );
    }


    private void initViews() {
        setContentView(R.layout.activity_slide);
        mProgressBar = ((ProgressBar) findViewById(R.id.slide_progress));
        mHideTextView = ((TextView) findViewById(R.id.slide_hideTextView));
        mViewPager = ((ViewPager) findViewById(R.id.slide_viewPager));

    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        switch (mark) {
            case "SlideModel":
                try {
                    Log.i("TTT", "net success");
                    new JsonPresenter(this, SlideModel.class, "SlideModel")
                            .parseJsonByGson(new String(bytes, "utf-8"));
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
            case "SlideModel":
                if (object != null && object instanceof SlideModel) {
                    SlideModel slideModel = (SlideModel) object;
                    initViewPager(slideModel);
                    Log.i("TTT", "json");
                } else {
                    mHideTextView.setText("数据丢失啦~");
                    mProgressBar.setVisibility(View.GONE);
                }
                break;
        }
    }

    private void initViewPager(SlideModel slideModel) {
        mHideTextView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
        SlideActivityAdapter viewAdapter = new SlideActivityAdapter(this, slideModel);
        mViewPager.setAdapter(viewAdapter);
    }

}
