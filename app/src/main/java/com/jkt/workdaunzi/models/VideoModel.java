package com.jkt.workdaunzi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/7 0007.
 */

public class VideoModel {
    @Override
    public String toString() {
        return "VideoModel{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * message : success
     * data : {"has_more":false,"tip":"20条新内容","has_new_message":true,"max_time":1.4785102228100002E9,"min_time":1478510223,"data":[{"group":{"360p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=1&is_gif=0"}],"uri":"360p/6085917fe17c4e398f10a603dd2a311a","height":360},"mp4_url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0.mp4","text":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","720p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=1&is_gif=0"}],"uri":"720p/6085917fe17c4e398f10a603dd2a311a","height":360},"digg_count":69612,"duration":165.76,"480p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=1&is_gif=0"}],"uri":"480p/6085917fe17c4e398f10a603dd2a311a","height":360},"create_time":1476961256,"keywords":"","id":51725332723,"favorite_count":10641,"go_detail_count":291568,"m3u8_url":"","large_cover":{"url_list":[{"url":"http://p9.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"}],"uri":"large/f3d0009604feef259ce"},"video_wh_ratio":0,"user_favorite":0,"share_type":1,"title":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","user":{"user_id":6375513795,"name":"Redwing86722819","followings":2,"user_verified":false,"ugc_count":3,"avatar_url":"http://p3.pstatp.com/thumb/e580004c8b0d3c7d20d","followers":444,"is_following":false,"is_pro_user":false},"is_can_share":1,"category_type":1,"share_url":"http://m.neihanshequ.com/share/group/51725332723/?iid=6178987393&app=joke_essay","label":1,"content":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","video_height":360,"comment_count":9063,"cover_image_uri":"f3d0009604feef259ce","id_str":"51725332723","media_type":3,"share_count":85759,"type":2,"category_id":65,"status":112,"has_comments":1,"publish_time":"","user_bury":0,"activity":{},"status_desc":"热门投稿","dislike_reason":[{"type":1,"id":350,"title":"狗"},{"type":1,"id":407,"title":"奇葩新闻"},{"type":2,"id":65,"title":"吧:搞笑视频"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":6375513795,"title":"作者:Redwing86722819"}],"neihan_hot_start_time":"00-00-00","play_count":2138420,"user_repin":0,"quick_comment":false,"medium_cover":{"url_list":[{"url":"http://p9.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"}],"uri":"medium/f3d0009604feef259ce"},"neihan_hot_end_time":"00-00-00","user_digg":0,"video_width":636,"online_time":1477326872,"category_name":"搞笑视频","flash_url":"","category_visible":true,"bury_count":2771,"is_anonymous":false,"repin_count":10641,"is_neihan_hot":false,"uri":"6085917fe17c4e398f10a603dd2a311a","is_public_url":1,"has_hot_comments":1,"allow_dislike":true,"origin_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=1&is_gif=0"}],"uri":"origin/6085917fe17c4e398f10a603dd2a311a","height":360},"cover_image_url":"","neihan_hot_link":{},"group_id":51725332723,"is_video":1,"display_type":0},"comments":[],"type":1,"display_time":1478510223,"online_time":1478510223}]}
     */

    private String message;
    /**
     * has_more : false
     * tip : 20条新内容
     * has_new_message : true
     * max_time : 1.4785102228100002E9
     * min_time : 1478510223
     * data : [{"group":{"360p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=1&is_gif=0"}],"uri":"360p/6085917fe17c4e398f10a603dd2a311a","height":360},"mp4_url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0.mp4","text":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","720p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=1&is_gif=0"}],"uri":"720p/6085917fe17c4e398f10a603dd2a311a","height":360},"digg_count":69612,"duration":165.76,"480p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=1&is_gif=0"}],"uri":"480p/6085917fe17c4e398f10a603dd2a311a","height":360},"create_time":1476961256,"keywords":"","id":51725332723,"favorite_count":10641,"go_detail_count":291568,"m3u8_url":"","large_cover":{"url_list":[{"url":"http://p9.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"}],"uri":"large/f3d0009604feef259ce"},"video_wh_ratio":0,"user_favorite":0,"share_type":1,"title":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","user":{"user_id":6375513795,"name":"Redwing86722819","followings":2,"user_verified":false,"ugc_count":3,"avatar_url":"http://p3.pstatp.com/thumb/e580004c8b0d3c7d20d","followers":444,"is_following":false,"is_pro_user":false},"is_can_share":1,"category_type":1,"share_url":"http://m.neihanshequ.com/share/group/51725332723/?iid=6178987393&app=joke_essay","label":1,"content":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","video_height":360,"comment_count":9063,"cover_image_uri":"f3d0009604feef259ce","id_str":"51725332723","media_type":3,"share_count":85759,"type":2,"category_id":65,"status":112,"has_comments":1,"publish_time":"","user_bury":0,"activity":{},"status_desc":"热门投稿","dislike_reason":[{"type":1,"id":350,"title":"狗"},{"type":1,"id":407,"title":"奇葩新闻"},{"type":2,"id":65,"title":"吧:搞笑视频"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":6375513795,"title":"作者:Redwing86722819"}],"neihan_hot_start_time":"00-00-00","play_count":2138420,"user_repin":0,"quick_comment":false,"medium_cover":{"url_list":[{"url":"http://p9.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"}],"uri":"medium/f3d0009604feef259ce"},"neihan_hot_end_time":"00-00-00","user_digg":0,"video_width":636,"online_time":1477326872,"category_name":"搞笑视频","flash_url":"","category_visible":true,"bury_count":2771,"is_anonymous":false,"repin_count":10641,"is_neihan_hot":false,"uri":"6085917fe17c4e398f10a603dd2a311a","is_public_url":1,"has_hot_comments":1,"allow_dislike":true,"origin_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=1&is_gif=0"}],"uri":"origin/6085917fe17c4e398f10a603dd2a311a","height":360},"cover_image_url":"","neihan_hot_link":{},"group_id":51725332723,"is_video":1,"display_type":0},"comments":[],"type":1,"display_time":1478510223,"online_time":1478510223}]
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
         * group : {"360p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=1&is_gif=0"}],"uri":"360p/6085917fe17c4e398f10a603dd2a311a","height":360},"mp4_url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0.mp4","text":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","720p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=1&is_gif=0"}],"uri":"720p/6085917fe17c4e398f10a603dd2a311a","height":360},"digg_count":69612,"duration":165.76,"480p_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=1&is_gif=0"}],"uri":"480p/6085917fe17c4e398f10a603dd2a311a","height":360},"create_time":1476961256,"keywords":"","id":51725332723,"favorite_count":10641,"go_detail_count":291568,"m3u8_url":"","large_cover":{"url_list":[{"url":"http://p9.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"}],"uri":"large/f3d0009604feef259ce"},"video_wh_ratio":0,"user_favorite":0,"share_type":1,"title":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","user":{"user_id":6375513795,"name":"Redwing86722819","followings":2,"user_verified":false,"ugc_count":3,"avatar_url":"http://p3.pstatp.com/thumb/e580004c8b0d3c7d20d","followers":444,"is_following":false,"is_pro_user":false},"is_can_share":1,"category_type":1,"share_url":"http://m.neihanshequ.com/share/group/51725332723/?iid=6178987393&app=joke_essay","label":1,"content":"土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你","video_height":360,"comment_count":9063,"cover_image_uri":"f3d0009604feef259ce","id_str":"51725332723","media_type":3,"share_count":85759,"type":2,"category_id":65,"status":112,"has_comments":1,"publish_time":"","user_bury":0,"activity":{},"status_desc":"热门投稿","dislike_reason":[{"type":1,"id":350,"title":"狗"},{"type":1,"id":407,"title":"奇葩新闻"},{"type":2,"id":65,"title":"吧:搞笑视频"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":6375513795,"title":"作者:Redwing86722819"}],"neihan_hot_start_time":"00-00-00","play_count":2138420,"user_repin":0,"quick_comment":false,"medium_cover":{"url_list":[{"url":"http://p9.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"}],"uri":"medium/f3d0009604feef259ce"},"neihan_hot_end_time":"00-00-00","user_digg":0,"video_width":636,"online_time":1477326872,"category_name":"搞笑视频","flash_url":"","category_visible":true,"bury_count":2771,"is_anonymous":false,"repin_count":10641,"is_neihan_hot":false,"uri":"6085917fe17c4e398f10a603dd2a311a","is_public_url":1,"has_hot_comments":1,"allow_dislike":true,"origin_video":{"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=1&is_gif=0"}],"uri":"origin/6085917fe17c4e398f10a603dd2a311a","height":360},"cover_image_url":"","neihan_hot_link":{},"group_id":51725332723,"is_video":1,"display_type":0}
         * comments : []
         * type : 1
         * display_time : 1478510223
         * online_time : 1478510223
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
             * 360p_video : {"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=360p&line=1&is_gif=0"}],"uri":"360p/6085917fe17c4e398f10a603dd2a311a","height":360}
             * mp4_url : http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0.mp4
             * text : 土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你
             * 720p_video : {"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=720p&line=1&is_gif=0"}],"uri":"720p/6085917fe17c4e398f10a603dd2a311a","height":360}
             * digg_count : 69612
             * duration : 165.76
             * 480p_video : {"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=480p&line=1&is_gif=0"}],"uri":"480p/6085917fe17c4e398f10a603dd2a311a","height":360}
             * create_time : 1476961256
             * keywords :
             * id : 51725332723
             * favorite_count : 10641
             * go_detail_count : 291568
             * m3u8_url :
             * large_cover : {"url_list":[{"url":"http://p9.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"}],"uri":"large/f3d0009604feef259ce"}
             * video_wh_ratio : 0
             * user_favorite : 0
             * share_type : 1
             * title : 土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你
             * user : {"user_id":6375513795,"name":"Redwing86722819","followings":2,"user_verified":false,"ugc_count":3,"avatar_url":"http://p3.pstatp.com/thumb/e580004c8b0d3c7d20d","followers":444,"is_following":false,"is_pro_user":false}
             * is_can_share : 1
             * category_type : 1
             * share_url : http://m.neihanshequ.com/share/group/51725332723/?iid=6178987393&app=joke_essay
             * label : 1
             * content : 土狗:这次先给你个小教训。下次再敢惹老子，撕的就是你
             * video_height : 360
             * comment_count : 9063
             * cover_image_uri : f3d0009604feef259ce
             * id_str : 51725332723
             * media_type : 3
             * share_count : 85759
             * type : 2
             * category_id : 65
             * status : 112
             * has_comments : 1
             * publish_time :
             * user_bury : 0
             * activity : {}
             * status_desc : 热门投稿
             * dislike_reason : [{"type":1,"id":350,"title":"狗"},{"type":1,"id":407,"title":"奇葩新闻"},{"type":2,"id":65,"title":"吧:搞笑视频"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":6375513795,"title":"作者:Redwing86722819"}]
             * neihan_hot_start_time : 00-00-00
             * play_count : 2138420
             * user_repin : 0
             * quick_comment : false
             * medium_cover : {"url_list":[{"url":"http://p9.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/w202/f3d0009604feef259ce.webp"}],"uri":"medium/f3d0009604feef259ce"}
             * neihan_hot_end_time : 00-00-00
             * user_digg : 0
             * video_width : 636
             * online_time : 1477326872
             * category_name : 搞笑视频
             * flash_url :
             * category_visible : true
             * bury_count : 2771
             * is_anonymous : false
             * repin_count : 10641
             * is_neihan_hot : false
             * uri : 6085917fe17c4e398f10a603dd2a311a
             * is_public_url : 1
             * has_hot_comments : 1
             * allow_dislike : true
             * origin_video : {"width":636,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=6085917fe17c4e398f10a603dd2a311a&quality=origin&line=1&is_gif=0"}],"uri":"origin/6085917fe17c4e398f10a603dd2a311a","height":360}
             * cover_image_url :
             * neihan_hot_link : {}
             * group_id : 51725332723
             * is_video : 1
             * display_type : 0
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
                            "mp4_url='" + mp4_url + '\'' +
                            ", text='" + text + '\'' +
                            ", digg_count=" + digg_count +
                            ", large_cover=" + large_cover +
                            ", user=" + user +
                            ", share_url='" + share_url + '\'' +
                            ", comment_count=" + comment_count +
                            ", share_count=" + share_count +
                            ", type=" + type +
                            ", bury_count=" + bury_count +
                            '}';
                }

                private String mp4_url;
                private String text;
                private int digg_count;
                /**
                 * url_list : [{"url":"http://p9.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"},{"url":"http://pb3.pstatp.com/large/f3d0009604feef259ce.webp"}]
                 * uri : large/f3d0009604feef259ce
                 */

                private LargeCoverBean large_cover;
                /**
                 * user_id : 6375513795
                 * name : Redwing86722819
                 * followings : 2
                 * user_verified : false
                 * ugc_count : 3
                 * avatar_url : http://p3.pstatp.com/thumb/e580004c8b0d3c7d20d
                 * followers : 444
                 * is_following : false
                 * is_pro_user : false
                 */

                private UserBean user;
                private String share_url;
                private int comment_count;
                private int share_count;
                private int type;
                private int bury_count;

                public String getMp4_url() {
                    return mp4_url;
                }

                public void setMp4_url(String mp4_url) {
                    this.mp4_url = mp4_url;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getDigg_count() {
                    return digg_count;
                }

                public void setDigg_count(int digg_count) {
                    this.digg_count = digg_count;
                }

                public LargeCoverBean getLarge_cover() {
                    return large_cover;
                }

                public void setLarge_cover(LargeCoverBean large_cover) {
                    this.large_cover = large_cover;
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

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getBury_count() {
                    return bury_count;
                }

                public void setBury_count(int bury_count) {
                    this.bury_count = bury_count;
                }

                public static class LargeCoverBean {
                    @Override
                    public String toString() {
                        return "LargeCoverBean{" +
                                "url_list=" + url_list +
                                '}';
                    }

                    /**
                     * url : http://p9.pstatp.com/large/f3d0009604feef259ce.webp
                     */

                    private List<UrlListBean> url_list;

                    public List<UrlListBean> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBean> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBean {
                        @Override
                        public String toString() {
                            return "UrlListBean{" +
                                    "url='" + url + '\'' +
                                    '}';
                        }

                        private String url;

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
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
