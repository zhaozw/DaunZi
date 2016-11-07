package com.jkt.workdaunzi.View;

/**
 * Created by 天哥哥 on 2016/10/13 0013.
 */

public interface INetView {

    /**
     * @param bytes the bytes  that get from the given url ,or someWhere.
     * @param mark  the sign that you set ,so  that you can get the special bytes you want
     *              .because,  you may use the  implements method many times,so that you can know what bytes
     *              you really want to get.
     */
    void getNetSuccess(byte[] bytes, String mark);

    /**
     * @param e the method is to invoke to tell you the Fil message when get bytes from the url
     */
    void getNetFail(Exception e);
}
