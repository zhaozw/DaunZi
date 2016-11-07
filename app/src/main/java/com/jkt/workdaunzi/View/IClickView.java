package com.jkt.workdaunzi.View;

import android.content.Intent;

/**
 * Created by 天哥哥 on 2016/10/15 0015.
 */

public interface IClickView {

    /**
     * @param intent the intent that  you want to send to the receiver
     * @param What   startWhat case
     *               0: startActivity
     *               1: startServer
     *               2: sendBroadCost
     */
    void receiveClickToStartWhat(Intent intent, int What);
}
