package com.jkt.workdaunzi.tool;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

/**
 * Created by 天哥哥 on 2016/10/17 0017.
 */

public class Ui {
    public static float Px2Dp(Activity activity, float px) {
        float ret = 0;
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int densityDpi = outMetrics.densityDpi;
        ret = px / densityDpi * 160;
        return ret;
    }

    public static float Dp2Px(Activity activity, float dp) {
        float ret = 0;
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int densityDpi = outMetrics.densityDpi;
        ret = dp * densityDpi / 160;
        return ret;
    }

    public static Bitmap getBitmap(Context context, Resources resources, int resourceID, int width, int height) {
        Bitmap ret = null;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceID);
        ret = Bitmap.createScaledBitmap(bitmap, width, height, false);
        return ret;
    }
}
