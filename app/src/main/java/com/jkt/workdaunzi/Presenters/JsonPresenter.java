package com.jkt.workdaunzi.Presenters;

import com.google.gson.Gson;
import com.jkt.workdaunzi.View.IJsonView;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public class JsonPresenter implements IJsonPresenter {
    private IJsonView mJsonView;
    private Class mClass;
    private String mMark;
    private Gson mGson;

    /**
     * @param jsonView the jsonView the will be used to receive the net bytes
     * @param aClass   the CLass type object the you want to generate it's object by the bytes
     */
    public JsonPresenter(IJsonView jsonView, Class aClass, String mark) {
        mJsonView = jsonView;
        this.mClass = aClass;
        mMark = mark;
    }

    @Override
    public void parseJsonByGson(String jsonString) {
        switch (judgeType()) {
        }
    }



    private int judgeType() {
        return -1;
    }

    @Override
    public void parseJsonByJson(String jsonString) {

    }

    @Override
    public void parseJsonByFastJson(String jsonString) {

    }


}
