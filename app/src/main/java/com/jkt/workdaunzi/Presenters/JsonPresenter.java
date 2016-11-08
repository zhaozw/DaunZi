package com.jkt.workdaunzi.Presenters;

import com.google.gson.Gson;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.models.DuanziModel;
import com.jkt.workdaunzi.models.LiveModel;
import com.jkt.workdaunzi.models.PictureModel;
import com.jkt.workdaunzi.models.RecommendModel;
import com.jkt.workdaunzi.models.VideoModel;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public class JsonPresenter implements IJsonPresenter {
    public static final int LIVE_MODEL = 1;
    public static final int RECOMMEND_MODEL = 2;
    public static final int VIDEO_MODEL = 3;
    public static final int PICTURE_MODEL = 4;
    public static final int DUANZI_MODEL = 5;
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
        mGson = new Gson();
    }

    @Override
    public void parseJsonByGson(String jsonString) {
        switch (judgeType()) {
            case LIVE_MODEL:
                gsonPraseLive(jsonString);
                break;
            case RECOMMEND_MODEL:
                gsonPraseRecommend(jsonString);
                break;
            case VIDEO_MODEL:
                gsonPraseVideo(jsonString);
                break;
            case PICTURE_MODEL:
                gsonPrasePicture(jsonString);
                break;
            case DUANZI_MODEL:
                gsonPraseDuanZi(jsonString);
                break;
        }
    }

    private void gsonPraseLive(String jsonString) {
        LiveModel liveModel = mGson.fromJson(jsonString, LiveModel.class);
        mJsonView.getModelObjectByJson(liveModel, "LiveModel");
    }

    private void gsonPraseVideo(String jsonString) {
        VideoModel videoModel = mGson.fromJson(jsonString, VideoModel.class);
        mJsonView.getModelObjectByJson(videoModel, "VideoModel");
    }

    private void gsonPrasePicture(String jsonString) {
        PictureModel pictureModel = mGson.fromJson(jsonString, PictureModel.class);
        mJsonView.getModelObjectByJson(pictureModel, "PictureModel");
    }

    private void gsonPraseDuanZi(String jsonString) {
        DuanziModel duanZiModel = mGson.fromJson(jsonString, DuanziModel.class);
        mJsonView.getModelObjectByJson(duanZiModel, "DuanziModel");
    }

    private void gsonPraseRecommend(String jsonString) {
        RecommendModel recommendModel = mGson.fromJson(jsonString, RecommendModel.class);
        mJsonView.getModelObjectByJson(recommendModel, "RecommendModel");
    }


    private int judgeType() {
        if (mClass.isInstance(new LiveModel())) {
            return LIVE_MODEL;
        } else if (mClass.isInstance(new RecommendModel())) {
            return RECOMMEND_MODEL;
        } else if (mClass.isInstance(new VideoModel())) {
            return VIDEO_MODEL;
        } else if (mClass.isInstance(new PictureModel())) {
            return PICTURE_MODEL;
        } else if (mClass.isInstance(new DuanziModel())) {
            return DUANZI_MODEL;
        }
        return -1;
    }

    @Override
    public void parseJsonByJson(String jsonString) {

    }

    @Override
    public void parseJsonByFastJson(String jsonString) {

    }


}
