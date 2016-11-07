package com.jkt.workdaunzi.Presenters;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public interface IJsonPresenter {

    /**
     * @param jsonString parse jsonString by the way of native  json
     */
    void parseJsonByJson(String jsonString);

    /**
     * @param jsonString parse jsonString by the way of  FastJson
     */
    void parseJsonByFastJson(String jsonString);

    /**
     * @param jsonString parse jsonString by the way of Gson
     */
    void parseJsonByGson(String jsonString);

}
