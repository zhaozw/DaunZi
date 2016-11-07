package com.jkt.workdaunzi.Presenters;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.jkt.workdaunzi.View.INetView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public class NetPresenter implements INetPresenter {
    private INetView mINetView;
    private String mMark;


    public Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (msg.obj instanceof byte[]) {
                        byte[] bytes = (byte[]) msg.obj;
                        Bundle data = msg.getData();
                        String mark = data.getString("mark");
                        mINetView.getNetSuccess(bytes, mark);

                    }
                    break;
                case -1:
                    if (msg.obj instanceof Exception) {
                        Exception exception = (Exception) msg.obj;
                        mINetView.getNetFail(exception);
                    }

            }
            return true;
        }
    });

    /**
     * @param INetView the INetView that will receive the bytes from the special url
     * @param mark     the mark the INetView can get the special bytes
     */
    public NetPresenter(INetView INetView, String mark) {
        mINetView = INetView;
        mMark = mark;
    }

    @Override
    public void getNetByteByOkHttp3(@NonNull String url, @NonNull String method, RequestBody requestBody, String headName, String headValue) {
        if (url != null && !url.equals("")) {
            doOkHttp3(url, method, requestBody, headName, headValue);
        } else {
            Message message = mHandler.obtainMessage();
            message.what = -1;
            message.obj = new Exception("request url is null");
            message.sendToTarget();
        }
    }

    @Override
    public void getNetByteByOkHttpConnection(String url) {

    }

    @Override
    public void getNetByteByOkHttpClient(String url) {

    }

    private void doOkHttp3(String url, String method, RequestBody requestBody, String headName, String headValue) {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        if ("GET".equals(method)) {
            builder.get();
        } else if ("POST".equals(method)) {
            builder.post(requestBody);
        } else {
            Message message = mHandler.obtainMessage();
            message.what = -1;
            message.obj = new Exception("request method isn't GET or POST");
            message.sendToTarget();
            return;
        }
        if (headName != null && headValue != null) {
            builder.addHeader(headName, headValue);
        }
        Request request = builder.build();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = mHandler.obtainMessage();
                message.what = -1;
                message.obj = e;
                message.sendToTarget();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    Message message = mHandler.obtainMessage();
                    Bundle data = new Bundle();
                    message.setData(data);
                    data.putString("mark", mMark);
                    message.what = 0;
                    byte[] bytes = response.body().bytes();
                    if (bytes == null || bytes.length == 0) {
                        Message message1 = mHandler.obtainMessage();
                        message1.what = -1;
                        message1.obj = new Exception();
                        message1.sendToTarget();
                        return;
                    }
                    message.obj = bytes;
                    message.sendToTarget();
                } catch (Exception e) {
                    Message message = mHandler.obtainMessage();
                    message.what = -1;
                    message.obj = e;
                    message.sendToTarget();
                }
            }
        });

    }
}
