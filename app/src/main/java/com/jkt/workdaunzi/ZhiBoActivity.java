package com.jkt.workdaunzi;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jkt.workdaunzi.customviews.BarrageRelativeLayout;

import java.util.LinkedList;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class ZhiBoActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, View.OnClickListener {

    private VideoView mVideoView;
    private ProgressBar mProgressBar;
    private String mZhiBoUrl;
    private LinearLayout mShowLinearLayout;
    private Button mExitButton;
    private BarrageRelativeLayout mBarrageRelativeLayout;
    private TextView mShowDanmuTextView;
    private TextView mShowInputTextView;
    private Button mSendButton;
    private LinearLayout mEditLayout;
    private EditText mEditText;
    private Button mHideButton;
    private LinearLayout mChooseLayout;
    private InputMethodManager mInputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDecorView();
        initViews();
        initWindowInputSoft();
        initIntent();
        initVideoView();
        initListeners();
    }

    private void initWindowInputSoft() {
        mInputMethodManager = ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE));
    }

    private void initDecorView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void initListeners() {
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnCompletionListener(this);
        mVideoView.setOnErrorListener(this);
        mExitButton.setOnClickListener(this);
        mShowDanmuTextView.setOnClickListener(this);
        mShowInputTextView.setOnClickListener(this);
        mSendButton.setOnClickListener(this);
        mHideButton.setOnClickListener(this);

    }


    private void initIntent() {
        if (getIntent() != null && getIntent().getStringExtra("Flv") != null) {
            mZhiBoUrl = getIntent().getStringExtra("Flv");
        }
    }

    private void initVideoView() {
        if (Vitamio.isInitialized(this) && mZhiBoUrl != null) {
            mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.setVideoPath(mZhiBoUrl);
        }
    }

    private void initViews() {
        setContentView(R.layout.activity_zhibo);
        mVideoView = ((VideoView) findViewById(R.id.zhibo_videoView));
        mProgressBar = ((ProgressBar) findViewById(R.id.zhibo_progress));
        mShowLinearLayout = ((LinearLayout) findViewById(R.id.zhibo_finishLayout));
        mExitButton = ((Button) findViewById(R.id.zhibo_exitButton));
        mBarrageRelativeLayout = ((BarrageRelativeLayout) findViewById(R.id.zhibo_danmu));
        mShowDanmuTextView = ((TextView) findViewById(R.id.zhibo_showDanmuTextView));
        mShowInputTextView = ((TextView) findViewById(R.id.zhibo_showInputTextView));
        mSendButton = ((Button) findViewById(R.id.zhibo_sendButton));
        mHideButton = ((Button) findViewById(R.id.zhibo_hideButton));
        mEditText = ((EditText) findViewById(R.id.zhibo_editText));
        mEditLayout = ((LinearLayout) findViewById(R.id.zhibo_EditLayout));
        mChooseLayout = ((LinearLayout) findViewById(R.id.zhibo_chooseLayout));
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mProgressBar.setVisibility(View.GONE);
        mVideoView.start();
        String[] itemText = {"hi,你好", "哦,我的天", "酱油", "我也是酱油", "啦啦啦", "我的天",
                "你好呀", "厉害了,word妹", "吊吊吊~~", "爱笑的眼睛", "http://www.xxxxxx.com"};
        LinkedList<String> texts = new LinkedList<String>();
        for (int i = 0; i < itemText.length; i++) {
            texts.add(itemText[i]);
        }
        mBarrageRelativeLayout.setBarrageTexts(texts);
        mBarrageRelativeLayout.show(BarrageRelativeLayout.RANDOM_SHOW);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mBarrageRelativeLayout.setVisibility(View.INVISIBLE);
        mShowLinearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        mShowLinearLayout.setVisibility(View.VISIBLE);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhibo_exitButton:
                mChooseLayout.setVisibility(View.INVISIBLE);
                mEditLayout.setVisibility(View.INVISIBLE);
                finish();
                break;
            case R.id.zhibo_showDanmuTextView:
                if (mBarrageRelativeLayout != null && mBarrageRelativeLayout.getVisibility() == View.INVISIBLE) {
                    mBarrageRelativeLayout.setVisibility(View.VISIBLE);
                } else if (mBarrageRelativeLayout != null && mBarrageRelativeLayout.getVisibility() == View.VISIBLE) {
                    mBarrageRelativeLayout.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.zhibo_showInputTextView:
                mEditLayout.setVisibility(View.VISIBLE);
                mChooseLayout.setVisibility(View.INVISIBLE);
                mInputMethodManager.showSoftInput(mEditText,InputMethodManager.RESULT_SHOWN);

                break;
            case R.id.zhibo_sendButton:
                mBarrageRelativeLayout.addBarrageText(mEditText.getText().toString());
                mInputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);
                mEditText.setText("");
                break;
            case R.id.zhibo_hideButton:
                mEditLayout.setVisibility(View.INVISIBLE);
                mChooseLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
