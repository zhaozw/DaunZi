package com.jkt.workdaunzi.Presenters;

import android.util.Log;

import com.google.gson.Gson;
import com.jkt.workdaunzi.View.IJsonView;
import com.jkt.workdaunzi.models.DocModel;
import com.jkt.workdaunzi.models.DuanziModel;
import com.jkt.workdaunzi.models.FinanceModel;
import com.jkt.workdaunzi.models.FunModel;
import com.jkt.workdaunzi.models.HeadlineModel;
import com.jkt.workdaunzi.models.HistoryModel;
import com.jkt.workdaunzi.models.LiveModel;
import com.jkt.workdaunzi.models.PictureModel;
import com.jkt.workdaunzi.models.RecommendModel;
import com.jkt.workdaunzi.models.SlideModel;
import com.jkt.workdaunzi.models.SportsModel;
import com.jkt.workdaunzi.models.TechnologyModel;
import com.jkt.workdaunzi.models.Topic2Model;
import com.jkt.workdaunzi.models.VideoModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public class JsonPresenter implements IJsonPresenter {
    public static final int LIVE_MODEL = 1;
    public static final int RECOMMEND_MODEL = 2;
    public static final int VIDEO_MODEL = 3;
    public static final int PICTURE_MODEL = 4;
    public static final int DUANZI_MODEL = 5;
    public static final int HEADLINE_MODEL = 11;
    public static final int FUN_MODEL = 12;
    public static final int SPORTS_MODEL = 13;
    public static final int FINANCE_MODEL = 14;
    public static final int TECHNOLOGY_MODEL = 15;
    public static final int HISTORY_MODEL = 16;
    public static final int DOC_MODEL = 17;
    public static final int SLIDE_MODEL = 18;
    public static final int TOPIC2_MODEL = 19;
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
            case HEADLINE_MODEL:
                GsonParseHeadlineModel(jsonString);
                break;
            case FUN_MODEL:
                GsonParseFunModel(jsonString);
                break;
            case SPORTS_MODEL:
                GsonParseSportsModel(jsonString);
                break;
            case FINANCE_MODEL:
                GsonParseFinanceModel(jsonString);
                break;
            case TECHNOLOGY_MODEL:
                GsonParseThechnologyModel(jsonString);
                break;
            case HISTORY_MODEL:
                GsonParseHistoryModel(jsonString);
                break;
            case DOC_MODEL:
                GsonParseDocModel(jsonString);
                break;
            case SLIDE_MODEL:
                GsonParseSlideModel(jsonString);
                break;
            case TOPIC2_MODEL:
                GsonParseTopic2deModel(jsonString);
                break;
        }
    }
    private void GsonParseTopic2deModel(String jsonString) {
        try {

            if (mGson == null) {
                mGson = new Gson();
            }
            Topic2Model topic2Model = mGson.fromJson(jsonString, Topic2Model.class);
            mJsonView.getModelObjectByJson(topic2Model, mMark);
        } catch (Exception e) {
        }
    }

    private void GsonParseSlideModel(String jsonString) {
        try {
            if (mGson == null) {
                mGson = new Gson();
            }
            SlideModel slideModel = mGson.fromJson(jsonString, SlideModel.class);
            mJsonView.getModelObjectByJson(slideModel, mMark);
        } catch (Exception e) {

        }
    }
    private void GsonParseDocModel(String jsonString) {
        try {

            if (mGson == null) {
                mGson = new Gson();
            }
            DocModel docModel = mGson.fromJson(jsonString, DocModel.class);
            mJsonView.getModelObjectByJson(docModel, mMark);
        } catch (Exception e) {

        }
    }

    private void gsonPraseLive(String jsonString) {
        LiveModel liveModel = mGson.fromJson(jsonString, LiveModel.class);
        if ("success".equals(liveModel.getMsg())) {
            mJsonView.getModelObjectByJson(liveModel, "LiveModel");
        }
    }

    private void gsonPraseVideo(String jsonString) {
        VideoModel videoModel = mGson.fromJson(jsonString, VideoModel.class);
        if ("success".equals(videoModel.getMessage())) {
            mJsonView.getModelObjectByJson(videoModel, "VideoModel");
        }
    }

    private void gsonPrasePicture(String jsonString) {
        PictureModel pictureModel = mGson.fromJson(jsonString, PictureModel.class);
        if ("success".equals(pictureModel.getMessage())) {
            mJsonView.getModelObjectByJson(pictureModel, "PictureModel");
        }
    }

    private void gsonPraseDuanZi(String jsonString) {
        DuanziModel duanZiModel = mGson.fromJson(jsonString, DuanziModel.class);
        if ("success".equals(duanZiModel.getMessage())) {
            mJsonView.getModelObjectByJson(duanZiModel, "DuanziModel");
        }
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
        } else if (mClass.isInstance(new HeadlineModel())) {
            return HEADLINE_MODEL;
        } else if (mClass.isInstance(new FunModel())) {
            return FUN_MODEL;
        } else if (mClass.isInstance(new SportsModel())) {
            return SPORTS_MODEL;
        } else if (mClass.isInstance(new FinanceModel())) {
            return FINANCE_MODEL;
        } else if (mClass.isInstance(new TechnologyModel())) {
            return TECHNOLOGY_MODEL;
        } else if (mClass.isInstance(new HistoryModel())) {
            return HISTORY_MODEL;
        } else if (mClass.isInstance(new DocModel())) {
            return DOC_MODEL;
        } else if (mClass.isInstance(new SlideModel())) {
            return SLIDE_MODEL;
        } else if (mClass.isInstance(new Topic2Model())) {
            return TOPIC2_MODEL;
        }
        return -1;
    }

    @Override
    public void parseJsonByJson(String jsonString) {

    }

    @Override
    public void parseJsonByFastJson(String jsonString) {

    }



    private void GsonParseHistoryModel(String jsonString) {
        if (mGson == null) {
            mGson = new Gson();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            HistoryModel historyModel = mGson.fromJson(jsonObject.toString(), HistoryModel.class);
            Log.i("TTT", historyModel.toString());
            mJsonView.getModelObjectByJson(historyModel, mMark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void GsonParseThechnologyModel(String jsonString) {
        if (mGson == null) {
            mGson = new Gson();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            TechnologyModel technologyModel = mGson.fromJson(jsonObject.toString(), TechnologyModel.class);
            Log.i("TTT", technologyModel.toString());
            mJsonView.getModelObjectByJson(technologyModel, mMark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void GsonParseFinanceModel(String jsonString) {
        if (mGson == null) {
            mGson = new Gson();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            FinanceModel financeModel = mGson.fromJson(jsonObject.toString(), FinanceModel.class);
            Log.i("TTT", financeModel.toString());
            mJsonView.getModelObjectByJson(financeModel, mMark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void GsonParseSportsModel(String jsonString) {
        if (mGson == null) {
            mGson = new Gson();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            SportsModel sportsModel = mGson.fromJson(jsonObject.toString(), SportsModel.class);
            Log.i("TTT", sportsModel.toString());
            mJsonView.getModelObjectByJson(sportsModel, mMark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void GsonParseRecommendModel(String jsonString) {
        if (mGson == null) {
            mGson = new Gson();
        }
        try {
            RecommendModel recommendModel = mGson.fromJson(jsonString, RecommendModel.class);
            Log.i("TTT", recommendModel.toString());
            mJsonView.getModelObjectByJson(recommendModel, mMark);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GsonParseFunModel(String jsonString) {
        if (mGson == null) {
            mGson = new Gson();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            FunModel funModel = mGson.fromJson(jsonObject.toString(), FunModel.class);
            Log.i("TTT", funModel.toString());
            mJsonView.getModelObjectByJson(funModel, mMark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void GsonParseHeadlineModel(String jsonString) {
        if (mGson == null) {
            mGson = new Gson();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            HeadlineModel headlineModel = mGson.fromJson(jsonObject.toString(), HeadlineModel.class);
            Log.i("TTT", headlineModel.toString());
            mJsonView.getModelObjectByJson(headlineModel, mMark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
