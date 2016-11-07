package com.jkt.workdaunzi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/7 0007.
 */

public class PictureModel {
    @Override
    public String toString() {
        return "PictureModel{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * message : success
     * data : {"has_more":true,"tip":"20条新内容","has_new_message":true,"max_time":1478510301,"min_time":1478510320,"data":[{"group":{"user":{"user_id":4565763433,"name":"名子太俊不提也罢","followings":13,"user_verified":false,"ugc_count":461,"avatar_url":"http://p3.pstatp.com/thumb/9810/5217559759","followers":1367,"is_following":false,"is_pro_user":false},"text":"","neihan_hot_start_time":"00-00-00","dislike_reason":[{"type":2,"id":10,"title":"吧:爆笑GIF"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":4565763433,"title":"作者:名子太俊不提也罢"}],"create_time":1478339389,"id":52068182905,"favorite_count":175,"go_detail_count":17141,"user_favorite":0,"share_type":1,"max_screen_width_percent":0.6,"is_can_share":1,"comment_count":184,"share_url":"http://m.neihanshequ.com/share/group/52068182905/?iid=6178987393&app=joke_essay","label":4,"content":"","category_type":1,"id_str":"52068182905","media_type":2,"share_count":396,"type":3,"status":110,"has_comments":0,"large_image":{},"user_bury":0,"activity":{},"status_desc":"已发表，粉丝第一时间可见","quick_comment":false,"display_type":0,"neihan_hot_end_time":"00-00-00","is_gif":1,"user_digg":0,"online_time":1478339389,"category_name":"爆笑GIF","category_visible":true,"bury_count":84,"is_anonymous":false,"repin_count":175,"min_screen_width_percent":0.167,"is_neihan_hot":false,"digg_count":2587,"gifvideo":{"360p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=1&is_gif=1"}],"uri":"360p/d919808339c4483e948521e65505b7ff","height":194},"origin_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=1&is_gif=1"}],"uri":"origin/d919808339c4483e948521e65505b7ff","height":194},"720p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=1&is_gif=1"}],"uri":"720p/d919808339c4483e948521e65505b7ff","height":194},"mp4_url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1.mp4","video_height":194,"480p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=1&is_gif=1"}],"uri":"480p/d919808339c4483e948521e65505b7ff","height":194},"cover_image_uri":"f8a000670c7d3ee685b","duration":10,"video_width":350},"has_hot_comments":1,"allow_dislike":true,"image_status":1,"user_repin":0,"neihan_hot_link":{},"group_id":52068182905,"middle_image":{"width":350,"r_height":192,"r_width":350,"url_list":[{"url":"http://p3.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb2.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb3.pstatp.com/w350/10f60000c643cb6aece3.webp"}],"uri":"w350/10f60000c643cb6aece3","height":193},"category_id":10},"comments":[],"type":1,"display_time":1478510320,"online_time":1478510320}]}
     */

    private String message;
    /**
     * has_more : true
     * tip : 20条新内容
     * has_new_message : true
     * max_time : 1478510301
     * min_time : 1478510320
     * data : [{"group":{"user":{"user_id":4565763433,"name":"名子太俊不提也罢","followings":13,"user_verified":false,"ugc_count":461,"avatar_url":"http://p3.pstatp.com/thumb/9810/5217559759","followers":1367,"is_following":false,"is_pro_user":false},"text":"","neihan_hot_start_time":"00-00-00","dislike_reason":[{"type":2,"id":10,"title":"吧:爆笑GIF"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":4565763433,"title":"作者:名子太俊不提也罢"}],"create_time":1478339389,"id":52068182905,"favorite_count":175,"go_detail_count":17141,"user_favorite":0,"share_type":1,"max_screen_width_percent":0.6,"is_can_share":1,"comment_count":184,"share_url":"http://m.neihanshequ.com/share/group/52068182905/?iid=6178987393&app=joke_essay","label":4,"content":"","category_type":1,"id_str":"52068182905","media_type":2,"share_count":396,"type":3,"status":110,"has_comments":0,"large_image":{},"user_bury":0,"activity":{},"status_desc":"已发表，粉丝第一时间可见","quick_comment":false,"display_type":0,"neihan_hot_end_time":"00-00-00","is_gif":1,"user_digg":0,"online_time":1478339389,"category_name":"爆笑GIF","category_visible":true,"bury_count":84,"is_anonymous":false,"repin_count":175,"min_screen_width_percent":0.167,"is_neihan_hot":false,"digg_count":2587,"gifvideo":{"360p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=1&is_gif=1"}],"uri":"360p/d919808339c4483e948521e65505b7ff","height":194},"origin_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=1&is_gif=1"}],"uri":"origin/d919808339c4483e948521e65505b7ff","height":194},"720p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=1&is_gif=1"}],"uri":"720p/d919808339c4483e948521e65505b7ff","height":194},"mp4_url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1.mp4","video_height":194,"480p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=1&is_gif=1"}],"uri":"480p/d919808339c4483e948521e65505b7ff","height":194},"cover_image_uri":"f8a000670c7d3ee685b","duration":10,"video_width":350},"has_hot_comments":1,"allow_dislike":true,"image_status":1,"user_repin":0,"neihan_hot_link":{},"group_id":52068182905,"middle_image":{"width":350,"r_height":192,"r_width":350,"url_list":[{"url":"http://p3.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb2.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb3.pstatp.com/w350/10f60000c643cb6aece3.webp"}],"uri":"w350/10f60000c643cb6aece3","height":193},"category_id":10},"comments":[],"type":1,"display_time":1478510320,"online_time":1478510320}]
     */
    @SerializedName("data")
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
         * group : {"user":{"user_id":4565763433,"name":"名子太俊不提也罢","followings":13,"user_verified":false,"ugc_count":461,"avatar_url":"http://p3.pstatp.com/thumb/9810/5217559759","followers":1367,"is_following":false,"is_pro_user":false},"text":"","neihan_hot_start_time":"00-00-00","dislike_reason":[{"type":2,"id":10,"title":"吧:爆笑GIF"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":4565763433,"title":"作者:名子太俊不提也罢"}],"create_time":1478339389,"id":52068182905,"favorite_count":175,"go_detail_count":17141,"user_favorite":0,"share_type":1,"max_screen_width_percent":0.6,"is_can_share":1,"comment_count":184,"share_url":"http://m.neihanshequ.com/share/group/52068182905/?iid=6178987393&app=joke_essay","label":4,"content":"","category_type":1,"id_str":"52068182905","media_type":2,"share_count":396,"type":3,"status":110,"has_comments":0,"large_image":{},"user_bury":0,"activity":{},"status_desc":"已发表，粉丝第一时间可见","quick_comment":false,"display_type":0,"neihan_hot_end_time":"00-00-00","is_gif":1,"user_digg":0,"online_time":1478339389,"category_name":"爆笑GIF","category_visible":true,"bury_count":84,"is_anonymous":false,"repin_count":175,"min_screen_width_percent":0.167,"is_neihan_hot":false,"digg_count":2587,"gifvideo":{"360p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=1&is_gif=1"}],"uri":"360p/d919808339c4483e948521e65505b7ff","height":194},"origin_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=1&is_gif=1"}],"uri":"origin/d919808339c4483e948521e65505b7ff","height":194},"720p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=1&is_gif=1"}],"uri":"720p/d919808339c4483e948521e65505b7ff","height":194},"mp4_url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1.mp4","video_height":194,"480p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=1&is_gif=1"}],"uri":"480p/d919808339c4483e948521e65505b7ff","height":194},"cover_image_uri":"f8a000670c7d3ee685b","duration":10,"video_width":350},"has_hot_comments":1,"allow_dislike":true,"image_status":1,"user_repin":0,"neihan_hot_link":{},"group_id":52068182905,"middle_image":{"width":350,"r_height":192,"r_width":350,"url_list":[{"url":"http://p3.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb2.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb3.pstatp.com/w350/10f60000c643cb6aece3.webp"}],"uri":"w350/10f60000c643cb6aece3","height":193},"category_id":10}
         * comments : []
         * type : 1
         * display_time : 1478510320
         * online_time : 1478510320
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
                        '}';
            }

            /**
             * user : {"user_id":4565763433,"name":"名子太俊不提也罢","followings":13,"user_verified":false,"ugc_count":461,"avatar_url":"http://p3.pstatp.com/thumb/9810/5217559759","followers":1367,"is_following":false,"is_pro_user":false}
             * text :
             * neihan_hot_start_time : 00-00-00
             * dislike_reason : [{"type":2,"id":10,"title":"吧:爆笑GIF"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":4565763433,"title":"作者:名子太俊不提也罢"}]
             * create_time : 1478339389
             * id : 52068182905
             * favorite_count : 175
             * go_detail_count : 17141
             * user_favorite : 0
             * share_type : 1
             * max_screen_width_percent : 0.6
             * is_can_share : 1
             * comment_count : 184
             * share_url : http://m.neihanshequ.com/share/group/52068182905/?iid=6178987393&app=joke_essay
             * label : 4
             * content :
             * category_type : 1
             * id_str : 52068182905
             * media_type : 2
             * share_count : 396
             * type : 3
             * status : 110
             * has_comments : 0
             * large_image : {}
             * user_bury : 0
             * activity : {}
             * status_desc : 已发表，粉丝第一时间可见
             * quick_comment : false
             * display_type : 0
             * neihan_hot_end_time : 00-00-00
             * is_gif : 1
             * user_digg : 0
             * online_time : 1478339389
             * category_name : 爆笑GIF
             * category_visible : true
             * bury_count : 84
             * is_anonymous : false
             * repin_count : 175
             * min_screen_width_percent : 0.167
             * is_neihan_hot : false
             * digg_count : 2587
             * gifvideo : {"360p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=360p&line=1&is_gif=1"}],"uri":"360p/d919808339c4483e948521e65505b7ff","height":194},"origin_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=origin&line=1&is_gif=1"}],"uri":"origin/d919808339c4483e948521e65505b7ff","height":194},"720p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=720p&line=1&is_gif=1"}],"uri":"720p/d919808339c4483e948521e65505b7ff","height":194},"mp4_url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1.mp4","video_height":194,"480p_video":{"width":350,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=0&is_gif=1"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=d919808339c4483e948521e65505b7ff&quality=480p&line=1&is_gif=1"}],"uri":"480p/d919808339c4483e948521e65505b7ff","height":194},"cover_image_uri":"f8a000670c7d3ee685b","duration":10,"video_width":350}
             * has_hot_comments : 1
             * allow_dislike : true
             * image_status : 1
             * user_repin : 0
             * neihan_hot_link : {}
             * group_id : 52068182905
             * middle_image : {"width":350,"r_height":192,"r_width":350,"url_list":[{"url":"http://p3.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb2.pstatp.com/w350/10f60000c643cb6aece3.webp"},{"url":"http://pb3.pstatp.com/w350/10f60000c643cb6aece3.webp"}],"uri":"w350/10f60000c643cb6aece3","height":193}
             * category_id : 10
             */

            private GroupBean group;
            private int type;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public GroupBean getGroup() {
                return group;
            }

            public void setGroup(GroupBean group) {
                this.group = group;
            }

            public static class GroupBean {
                @Override
                public String toString() {
                    return "GroupBean{" +
                            "user=" + user +
                            ", text='" + text + '\'' +
                            ", comment_count=" + comment_count +
                            ", share_url='" + share_url + '\'' +
                            ", share_count=" + share_count +
                            ", bury_count=" + bury_count +
                            ", digg_count=" + digg_count +
                            '}';
                }

                /**
                 * user_id : 4565763433
                 * name : 名子太俊不提也罢
                 * followings : 13
                 * user_verified : false
                 * ugc_count : 461
                 * avatar_url : http://p3.pstatp.com/thumb/9810/5217559759
                 * followers : 1367
                 * is_following : false
                 * is_pro_user : false
                 */

                private UserBean user;
                private String text;
                private int comment_count;
                private String share_url;
                private int share_count;
                private int bury_count;
                private int digg_count;

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public String getShare_url() {
                    return share_url;
                }

                public void setShare_url(String share_url) {
                    this.share_url = share_url;
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
