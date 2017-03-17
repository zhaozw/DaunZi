package com.jkt.workdaunzi.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by 天哥哥 on 2016/11/4 0004.
 */

public class MyScrollView extends ScrollView {
    private IScrollListener mIScrollListener;

    public void setIScrollListener(IScrollListener IScrollListener) {
        mIScrollListener = IScrollListener;
    }

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mIScrollListener != null) {
            mIScrollListener.scrollChanged(this, l, t, oldl, oldt);
        }
    }

    public interface IScrollListener {
        void scrollChanged(MyScrollView myScrollView, int l, int t, int oldl, int oldt);
    }

}
