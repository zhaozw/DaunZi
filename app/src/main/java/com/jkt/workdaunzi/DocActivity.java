package com.jkt.workdaunzi;

import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jkt.workdaunzi.Presenters.JsonPresenter;
import com.jkt.workdaunzi.Presenters.NetPresenter;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.View.INetView;
import com.jkt.workdaunzi.models.DocModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DocActivity extends AppCompatActivity implements INetView, IJsonView, View.OnClickListener {

    private TextView mTitleView;
    private TextView mTimeView;
    private TextView mSourceView;
    private WebView mWebView;
    private TextView mHideTextView;
    private LinearLayout mShowLayout;
    private ProgressBar mProgressBar;
    private String mAidString;
    private FrameLayout mFrameLayout;
    private Spanned mSpanned;
    private TextView mNiceTextView;
    private TextView mNiceTextView1;
    private ImageView mNiceImageView;
    private ImageView mNiceImageView1;
    private LinearLayout mNiceImagesLayoutLayout;
    private LinearLayout mNiceImagesLayoutLayout1;
    private DocModel mDocModel;
    private TextView mRecommendTextView;
    private TextView mRecommendTextView1;
    private ImageView mRecommendImageView;
    private ImageView mRecommendImageView1;
    private LinearLayout mRecommendLinearLayout;
    private LinearLayout mRecommendLinearLayout1;
    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        initViews();
        initWebView();
        getTheIntent();
        initNet();
        initListeners();
    }

    private void initListeners() {
    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
    }

    private void initWebView() {
        mWebView.setFocusable(false);
        WebSettings settings = mWebView.getSettings();
        settings.setTextSize(WebSettings.TextSize.LARGER);
        settings.setJavaScriptEnabled(true);
        mWebView.setBackgroundColor(Color.TRANSPARENT);
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
        new NetPresenter(this, "DocModel").getNetByteByOkHttp3(
                "http://api.iclient.ifeng.com/ipadtestdoc?aid=" +
                        mAidString +
                        "&channelKey=Y21wcF8xNzAwN183MTlfNzU=&gv=4.4.1&av=4.4.1&uid=865479029646411&deviceid=865479029646411&proid=ifengnews&os=androi" +
                        "d_22&df=androidphone&vt=5&screen=1152x1920&publishid=2024http://api.3g.ifeng.com/ipadtestdoc?",
                "GET",
                null, null, null
        );
        mProgressBar.setVisibility(View.VISIBLE);
    }


    private void getTheIntent() {
        if (getIntent() != null && getIntent().getStringExtra("aid") != null) {
            mAidString = getIntent().getStringExtra("aid");
        }
    }


    private void initViews() {
        setContentView(R.layout.activity_doc);
        mScrollView = ((ScrollView) findViewById(R.id.doc_scrollView));
        mTitleView = ((TextView) findViewById(R.id.doc_title));
        mTimeView = ((TextView) findViewById(R.id.doc_time));
        mSourceView = ((TextView) findViewById(R.id.doc_source));
        mWebView = ((WebView) findViewById(R.id.doc_webView));
        mHideTextView = ((TextView) findViewById(R.id.doc_hideTextView));
        mShowLayout = ((LinearLayout) findViewById(R.id.doc_ShowLayout));
        mProgressBar = ((ProgressBar) findViewById(R.id.doc_progress));
        mFrameLayout = ((FrameLayout) findViewById(R.id.doc_frameLayout));
        mNiceTextView = ((TextView) findViewById(R.id.doc_nice_title));
        mNiceTextView1 = ((TextView) findViewById(R.id.doc_nice_title1));
        mNiceImageView = ((ImageView) findViewById(R.id.doc_nice_image));
        mNiceImageView1 = ((ImageView) findViewById(R.id.doc_nice_image1));
        mNiceImagesLayoutLayout = ((LinearLayout) findViewById(R.id.doc_niceImagesView));
        mNiceImagesLayoutLayout1 = ((LinearLayout) findViewById(R.id.doc_niceImagesView1));
        mRecommendTextView = ((TextView) findViewById(R.id.doc_recommend_title));
        mRecommendTextView1 = ((TextView) findViewById(R.id.doc_recommend_title1));
        mRecommendImageView = ((ImageView) findViewById(R.id.doc_recommend_image));
        mRecommendImageView1 = ((ImageView) findViewById(R.id.doc_recommend_image1));
        mRecommendLinearLayout = ((LinearLayout) findViewById(R.id.doc_RecommendView));
        mRecommendLinearLayout1 = ((LinearLayout) findViewById(R.id.doc_RecommendView1));

    }

    @Override
    public void getNetSuccess(byte[] bytes, String mark) {
        switch (mark) {
            case "DocModel":
                try {
                    Log.i("TTT", "net success");
                    new JsonPresenter(this, DocModel.class, "DocModel")
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
            case "DocModel":
                if (object != null && object instanceof DocModel) {
                    mDocModel = (DocModel) object;
                    initData(mDocModel);
                    Log.i("TTT", "json");
                } else {
                    mHideTextView.setText("数据丢失啦~");
                    mProgressBar.setVisibility(View.GONE);
                }
                break;
        }
    }

    private void initData(DocModel docModel) {
        initWebViewData(docModel);
        initRecommendViewData(docModel);
        initNiceImagesViewData(docModel);
        initNiceImagesViewListeners();
        initRecommendViewListeners();
    }

    private void initRecommendViewListeners() {
        mRecommendLinearLayout.setOnClickListener(this);
        mRecommendLinearLayout1.setOnClickListener(this);
        if (mDocModel != null && mDocModel.getBody() != null && mDocModel.getBody().getRecommend_doc() != null && mDocModel.getBody().getRecommend_doc().size() >= 2) {
            mRecommendLinearLayout.setTag(mDocModel.getBody().getRecommend_doc().get(0).getId());
            mRecommendLinearLayout1.setTag(mDocModel.getBody().getRecommend_doc().get(1).getId());
        }
    }

    private void initRecommendViewData(DocModel docModel) {
        List<DocModel.BodyBean.RecommendDocBean> recommendDoc = docModel.getBody().getRecommend_doc();
        mRecommendTextView.setText(recommendDoc.get(0).getTitle());
        mRecommendTextView1.setText(recommendDoc.get(1).getTitle());
        Picasso.with(this).load(recommendDoc.get(0).getThumbnail()).into(mRecommendImageView);
        Picasso.with(this).load(recommendDoc.get(1).getThumbnail()).into(mRecommendImageView1);


    }

    private void initNiceImagesViewListeners() {
        mNiceImagesLayoutLayout.setOnClickListener(this);
        mNiceImagesLayoutLayout1.setOnClickListener(this);
        if (mDocModel != null && mDocModel.getBody() != null && mDocModel.getBody().getRecommend_slide() != null && mDocModel.getBody().getRecommend_slide().size() >= 2) {
            mNiceImagesLayoutLayout.setTag(mDocModel.getBody().getRecommend_slide().get(0).getId());
            mNiceImagesLayoutLayout1.setTag(mDocModel.getBody().getRecommend_slide().get(1).getId());
        }
    }

    private void initNiceImagesViewData(DocModel docModel) {
        List<DocModel.BodyBean.RecommendSlideBean> recommendSlide = docModel.getBody().getRecommend_slide();
        mNiceTextView.setText(recommendSlide.get(0).getTitle());
        mNiceTextView1.setText(recommendSlide.get(1).getTitle());
        Picasso.with(this).load(recommendSlide.get(0).getThumbnail()).into(mNiceImageView);
        Picasso.with(this).load(recommendSlide.get(1).getThumbnail()).into(mNiceImageView1);
    }

    private void initWebViewData(DocModel docModel) {
        mHideTextView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
        mFrameLayout.setVisibility(View.GONE);
        mShowLayout.setVisibility(View.VISIBLE);
        mTitleView.setText(docModel.getBody().getTitle());
        mTimeView.setText(docModel.getBody().getEditTime());
        mSourceView.setText(docModel.getBody().getSource());
        String source = docModel.getBody().getText();
        String html = "<html><head><style>img {width: 100%}</style><font/</head><body>" + source + "</body><html>";
        mWebView.loadData(html, "text/html;charset=UTF-8", null);
    }


    @Override
    public void onClick(View v) {
        if (mDocModel != null && v.getTag() instanceof String) {
            switch (v.getId()) {
                case R.id.doc_niceImagesView:
                case R.id.doc_niceImagesView1:
                    Intent intent = new Intent(this, SlideActivity.class);
                    String aid = (String) v.getTag();
                    intent.putExtra("aid", aid);
                    startActivity(intent);
                    break;
                case R.id.doc_RecommendView:
                case R.id.doc_RecommendView1:
                    Intent intent1 = new Intent(this, DocActivity.class);
                    String aid1 = (String) v.getTag();
                    intent1.putExtra("aid", aid1);
                    startActivity(intent1);
                    break;
            }
        }
    }
}
