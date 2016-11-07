package com.jkt.workdaunzi.Presenters;

import android.support.annotation.NonNull;

import okhttp3.RequestBody;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public interface INetPresenter {

    /**
     * @param url         thr url that you request
     * @param method      the request method must be GET or POST
     * @param requestBody the requestBody can be null if your request method is GET ,if your request
     *                    method is POST, you should get a requestBody but not must
     * @param headName    the request headName  can be null
     * @param headValue   the request headValue  can be null
     */
    void getNetByteByOkHttp3(@NonNull String url, @NonNull String method, RequestBody requestBody, String headName, String headValue);

    void getNetByteByOkHttpConnection(String url);

    void getNetByteByOkHttpClient(String url);

}
