package com.jkt.workdaunzi.tool;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 天哥哥 on 2016/10/20 0020.
 */

public class CustomToast {
    public static Toast getToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundColor(Color.argb(0x66,0x8B,0x47,0x26));
        return toast;
    }

}
