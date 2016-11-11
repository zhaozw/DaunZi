package com.jkt.workdaunzi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/7 0007.
 */

public class RecommendModel {
    @Override
    public String toString() {
        return "RecommendModel{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * message : success
     * data : {"has_more":true,"tip":"20条新内容","has_new_message":true,"max_time":1478521539,"min_time":1478521558,"data":[{"group":{},"comments":[],"type":1,"display_time":1478521558,"online_time":1478521558}]}
     */

    private String message;
    /**
     * has_more : true
     * tip : 20条新内容
     * has_new_message : true
     * max_time : 1478521539
     * min_time : 1478521558
     * data : [{"group":{},"comments":[],"type":1,"display_time":1478521558,"online_time":1478521558}]
     */

    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        @Override
        public String toString() {
            return "DataBean{" +
                    "data=" + data +
                    '}';
        }

        /**
         * group : {}
         * comments : []
         * type : 1
         * display_time : 1478521558
         * online_time : 1478521558
         */
        @SerializedName("data")
        private List<DataBean1> data;

        public List<DataBean1> getData() {
            return data;
        }

        public void setData(List<DataBean1> data) {
            this.data = data;
        }

        public static class DataBean1 {
            private boolean mChoose;
            private boolean mChooseDigg;
            private boolean mChooseBury;
            private boolean mChooseShare;

            public boolean isChooseShare() {
                return mChooseShare;
            }

            public void setChooseShare(boolean chooseShare) {
                mChooseShare = chooseShare;
            }

            public boolean isChooseDigg() {
                return mChooseDigg;
            }

            public void setChooseDigg(boolean chooseDigg) {
                mChooseDigg = chooseDigg;
            }

            public boolean isChooseBury() {
                return mChooseBury;
            }

            public void setChooseBury(boolean chooseBury) {
                mChooseBury = chooseBury;
            }

            public boolean isChoose() {
                return mChoose;
            }

            public void setChoose(boolean choose) {
                this.mChoose = choose;
            }
            @Override
            public String toString() {
                return "DataBean1{" +
                        "group=" + group +
                        ", type=" + type +
                        '}';
            }

            private GroupBean group;
            private int type;

            public GroupBean getGroup() {
                return group;
            }

            public void setGroup(GroupBean group) {
                this.group = group;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

        }
    }
}