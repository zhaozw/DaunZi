package com.jkt.workdaunzi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/7 0007.
 */

public class DuanziModel {
    @Override
    public String toString() {
        return "DuanZiModel{" +
                "message=" + message + '\'' +
                ", data='" + data +
                '}';
    }

    /**
     * has_more : false
     * tip : 20条新内容
     * has_new_message : true
     * max_time : 1.4785113968100002E9
     * min_time : 1478511397
     * data : [{"group":{"text":"老公：女王陛下，微臣已经率领亿万精兵在城门等候多时，只要陛下一声令下，微臣便帅兵攻破城池。 老婆：爱钦莫及，前方军事来报，池前横竖白棋，唯恐必有一场血战，诛将士休养七天后再来破城。 老公：陛下，可众将士已经蓄势待发，个个勇猛精进，臣诺让将士退兵，今后还咋服众。 老婆：不急，看我的三寸不烂之舌。","neihan_hot_start_time":"00-00-00","dislike_reason":[],"create_time":1476350426,"id":51535410164,"favorite_count":2372,"go_detail_count":103174,"user_favorite":0,"share_type":1,"user":{"user_id":50345366878,"name":"Nils2","followings":1,"user_verified":false,"ugc_count":4,"avatar_url":"http://p3.pstatp.com/thumb/e590009aeaf743f4595","followers":245,"is_following":false,"is_pro_user":true},"is_can_share":1,"category_type":2,"share_url":"http://m.neihanshequ.com/share/group/51535410164/?iid=6178987393&app=joke_essay","label":1,"content":"老公：女王陛下，微臣已经率领亿万精兵在城门等候多时，只要陛下一声令下，微臣便帅兵攻破城池。 老婆：爱钦莫及，前方军事来报，池前横竖白棋，唯恐必有一场血战，诛将士休养七天后再来破城。 老公：陛下，可众将士已经蓄势待发，个个勇猛精进，臣诺让将士退兵，今后还咋服众。 老婆：不急，看我的三寸不烂之舌。","comment_count":1036,"id_str":"51535410164","media_type":0,"share_count":9081,"type":3,"status":112,"has_comments":0,"user_bury":0,"activity":{},"status_desc":"热门投稿","quick_comment":false,"display_type":0,"neihan_hot_end_time":"00-00-00","user_digg":0,"online_time":1476350426,"category_name":"脑残对话","category_visible":true,"bury_count":1724,"is_anonymous":false,"repin_count":2372,"is_neihan_hot":false,"digg_count":23711,"has_hot_comments":1,"allow_dislike":true,"user_repin":0,"neihan_hot_link":{},"group_id":51535410164,"category_id":15},"comments":[],"type":1,"display_time":1478511397,"online_time":1478511397}]
     */
    @SerializedName("data")
    private DataBean data;
    private String message;

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
         * group : {"text":"老公：女王陛下，微臣已经率领亿万精兵在城门等候多时，只要陛下一声令下，微臣便帅兵攻破城池。 老婆：爱钦莫及，前方军事来报，池前横竖白棋，唯恐必有一场血战，诛将士休养七天后再来破城。 老公：陛下，可众将士已经蓄势待发，个个勇猛精进，臣诺让将士退兵，今后还咋服众。 老婆：不急，看我的三寸不烂之舌。","neihan_hot_start_time":"00-00-00","dislike_reason":[],"create_time":1476350426,"id":51535410164,"favorite_count":2372,"go_detail_count":103174,"user_favorite":0,"share_type":1,"user":{"user_id":50345366878,"name":"Nils2","followings":1,"user_verified":false,"ugc_count":4,"avatar_url":"http://p3.pstatp.com/thumb/e590009aeaf743f4595","followers":245,"is_following":false,"is_pro_user":true},"is_can_share":1,"category_type":2,"share_url":"http://m.neihanshequ.com/share/group/51535410164/?iid=6178987393&app=joke_essay","label":1,"content":"老公：女王陛下，微臣已经率领亿万精兵在城门等候多时，只要陛下一声令下，微臣便帅兵攻破城池。 老婆：爱钦莫及，前方军事来报，池前横竖白棋，唯恐必有一场血战，诛将士休养七天后再来破城。 老公：陛下，可众将士已经蓄势待发，个个勇猛精进，臣诺让将士退兵，今后还咋服众。 老婆：不急，看我的三寸不烂之舌。","comment_count":1036,"id_str":"51535410164","media_type":0,"share_count":9081,"type":3,"status":112,"has_comments":0,"user_bury":0,"activity":{},"status_desc":"热门投稿","quick_comment":false,"display_type":0,"neihan_hot_end_time":"00-00-00","user_digg":0,"online_time":1476350426,"category_name":"脑残对话","category_visible":true,"bury_count":1724,"is_anonymous":false,"repin_count":2372,"is_neihan_hot":false,"digg_count":23711,"has_hot_comments":1,"allow_dislike":true,"user_repin":0,"neihan_hot_link":{},"group_id":51535410164,"category_id":15}
         * comments : []
         * type : 1
         * display_time : 1478511397
         * online_time : 1478511397
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
            @Override
            public String toString() {
                return "DataBean1{" +
                        "group=" + group +
                        ", type=" + type +
                        '}';
            }

            /**
             * text : 老公：女王陛下，微臣已经率领亿万精兵在城门等候多时，只要陛下一声令下，微臣便帅兵攻破城池。 老婆：爱钦莫及，前方军事来报，池前横竖白棋，唯恐必有一场血战，诛将士休养七天后再来破城。 老公：陛下，可众将士已经蓄势待发，个个勇猛精进，臣诺让将士退兵，今后还咋服众。 老婆：不急，看我的三寸不烂之舌。
             * neihan_hot_start_time : 00-00-00
             * dislike_reason : []
             * create_time : 1476350426
             * id : 51535410164
             * favorite_count : 2372
             * go_detail_count : 103174
             * user_favorite : 0
             * share_type : 1
             * user : {"user_id":50345366878,"name":"Nils2","followings":1,"user_verified":false,"ugc_count":4,"avatar_url":"http://p3.pstatp.com/thumb/e590009aeaf743f4595","followers":245,"is_following":false,"is_pro_user":true}
             * is_can_share : 1
             * category_type : 2
             * share_url : http://m.neihanshequ.com/share/group/51535410164/?iid=6178987393&app=joke_essay
             * label : 1
             * content : 老公：女王陛下，微臣已经率领亿万精兵在城门等候多时，只要陛下一声令下，微臣便帅兵攻破城池。 老婆：爱钦莫及，前方军事来报，池前横竖白棋，唯恐必有一场血战，诛将士休养七天后再来破城。 老公：陛下，可众将士已经蓄势待发，个个勇猛精进，臣诺让将士退兵，今后还咋服众。 老婆：不急，看我的三寸不烂之舌。
             * comment_count : 1036
             * id_str : 51535410164
             * media_type : 0
             * share_count : 9081
             * type : 3
             * status : 112
             * has_comments : 0
             * user_bury : 0
             * activity : {}
             * status_desc : 热门投稿
             * quick_comment : false
             * display_type : 0
             * neihan_hot_end_time : 00-00-00
             * user_digg : 0
             * online_time : 1476350426
             * category_name : 脑残对话
             * category_visible : true
             * bury_count : 1724
             * is_anonymous : false
             * repin_count : 2372
             * is_neihan_hot : false
             * digg_count : 23711
             * has_hot_comments : 1
             * allow_dislike : true
             * user_repin : 0
             * neihan_hot_link : {}
             * group_id : 51535410164
             * category_id : 15
             */

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

            public static class GroupBean {
                @Override
                public String toString() {
                    return "GroupBean{" +
                            "text='" + text + '\'' +
                            ", user=" + user +
                            ", share_url='" + share_url + '\'' +
                            ", comment_count=" + comment_count +
                            ", share_count=" + share_count +
                            ", bury_count=" + bury_count +
                            ", digg_count=" + digg_count +
                            '}';
                }

                private String text;
                /**
                 * user_id : 50345366878
                 * name : Nils2
                 * followings : 1
                 * user_verified : false
                 * ugc_count : 4
                 * avatar_url : http://p3.pstatp.com/thumb/e590009aeaf743f4595
                 * followers : 245
                 * is_following : false
                 * is_pro_user : true
                 */

                private UserBean user;
                private String share_url;
                private int comment_count;
                private int share_count;
                private int bury_count;
                private int digg_count;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public String getShare_url() {
                    return share_url;
                }

                public void setShare_url(String share_url) {
                    this.share_url = share_url;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public int getShare_count() {
                    return share_count;
                }

                public void setShare_count(int share_count) {
                    this.share_count = share_count;
                }

                public int getBury_count() {
                    return bury_count;
                }

                public void setBury_count(int bury_count) {
                    this.bury_count = bury_count;
                }

                public int getDigg_count() {
                    return digg_count;
                }

                public void setDigg_count(int digg_count) {
                    this.digg_count = digg_count;
                }

                public static class UserBean {
                    @Override
                    public String toString() {
                        return "UserBean{" +
                                "name='" + name + '\'' +
                                ", avatar_url='" + avatar_url + '\'' +
                                '}';
                    }

                    private String name;
                    private String avatar_url;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getAvatar_url() {
                        return avatar_url;
                    }

                    public void setAvatar_url(String avatar_url) {
                        this.avatar_url = avatar_url;
                    }
                }
            }
        }
    }
}
