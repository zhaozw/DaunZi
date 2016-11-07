package com.jkt.workdaunzi.View;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public interface IJsonView {

    /**
     * @param list get a list that parse from the special jsonString
     * @param mark the sign that you set ,so  that you can get the special list you want
     *             .because,  you may use the  implements method many times,so that you can know which  list
     *             you really want to get.
     */
    void getModelListByJson(List list, String mark);

    /**
     * @param object get a object that parse from the special jsonString
     * @param mark   the sign that you set ,so  that you can get the special object you want
     *               .because,  you may use the  implements method many times,so that you can know which object
     *               you really want to get.
     */
    void getModelObjectByJson(Object object, String mark);
}
