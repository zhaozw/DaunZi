package com.jkt.workdaunzi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/7 0007.
 */

public class GroupBean {
    @Override
    public String toString() {
        return "GroupBean{" +
                "mp4_url='" + mp4_url + '\'' +
                ", digg_count=" + digg_count +
                ", large_cover=" + large_cover +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", share_url='" + share_url + '\'' +
                ", comment_count=" + comment_count +
                ", share_count=" + share_count +
                ", type=" + type +
                ", bury_count=" + bury_count +
                ", large_image=" + large_image +
                ", gifvideo=" + gifvideo +
                ", text='" + text + '\'' +
                '}';
    }

    /**
     * 360p_video : {"width":480,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=360p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=360p&line=1&is_gif=0"}],"uri":"360p/17e46e2b9c734e3b9ec500851256e083","height":272}
     * mp4_url : http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=480p&line=0&is_gif=0.mp4
     * text : 梦想
     * 720p_video : {"width":480,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=720p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=720p&line=1&is_gif=0"}],"uri":"720p/17e46e2b9c734e3b9ec500851256e083","height":272}
     * digg_count : 30999
     * duration : 116.7
     * 480p_video : {"width":480,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=480p&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=480p&line=1&is_gif=0"}],"uri":"480p/17e46e2b9c734e3b9ec500851256e083","height":272}
     * create_time : 1477313001
     * keywords :
     * id : 51829167023
     * favorite_count : 4711
     * go_detail_count : 64345
     * m3u8_url :
     * large_cover : {"url_list":[{"url":"http://p2.pstatp.com/large/f89000153afa57a50d6.webp"},{"url":"http://pb3.pstatp.com/large/f89000153afa57a50d6.webp"},{"url":"http://pb3.pstatp.com/large/f89000153afa57a50d6.webp"}],"uri":"large/f89000153afa57a50d6"}
     * video_wh_ratio : 0
     * user_favorite : 0
     * share_type : 1
     * title : 梦想
     * user : {"user_id":7008962434,"name":"丶整颗心丶","followings":9,"user_verified":false,"ugc_count":9,"avatar_url":"http://p2.pstatp.com/thumb/e580002f4811f2630f3","followers":119,"is_following":false,"is_pro_user":true}
     * is_can_share : 1
     * category_type : 1
     * share_url : http://m.neihanshequ.com/share/group/51829167023/?iid=6178987393&app=joke_essay
     * label : 1
     * content : 梦想
     * video_height : 272
     * comment_count : 2783
     * cover_image_uri : f89000153afa57a50d6
     * id_str : 51829167023
     * media_type : 3
     * share_count : 9831
     * type : 2
     * category_id : 65
     * status : 112
     * has_comments : 1
     * publish_time :
     * user_bury : 0
     * activity : {}
     * status_desc : 热门投稿
     * dislike_reason : [{"type":1,"id":431,"title":"音乐"},{"type":2,"id":65,"title":"吧:搞笑视频"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":7008962434,"title":"作者:丶整颗心丶"}]
     * neihan_hot_start_time : 00-00-00
     * play_count : 839602
     * user_repin : 0
     * quick_comment : false
     * medium_cover : {"url_list":[{"url":"http://p2.pstatp.com/w202/f89000153afa57a50d6.webp"},{"url":"http://pb3.pstatp.com/w202/f89000153afa57a50d6.webp"},{"url":"http://pb3.pstatp.com/w202/f89000153afa57a50d6.webp"}],"uri":"medium/f89000153afa57a50d6"}
     * neihan_hot_end_time : 00-00-00
     * user_digg : 0
     * video_width : 480
     * online_time : 1477792897
     * category_name : 搞笑视频
     * flash_url :
     * category_visible : true
     * bury_count : 615
     * is_anonymous : false
     * repin_count : 4711
     * is_neihan_hot : false
     * uri : 17e46e2b9c734e3b9ec500851256e083
     * is_public_url : 1
     * has_hot_comments : 1
     * allow_dislike : true
     * origin_video : {"width":480,"url_list":[{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=origin&line=0&is_gif=0"},{"url":"http://ic.snssdk.com/neihan/video/playback/?video_id=17e46e2b9c734e3b9ec500851256e083&quality=origin&line=1&is_gif=0"}],"uri":"origin/17e46e2b9c734e3b9ec500851256e083","height":272}
     * cover_image_url :
     * neihan_hot_link : {}
     * group_id : 51829167023
     * is_video : 1
     * display_type : 0
     */

    private String mp4_url;
    private int digg_count;
    /**
     * url_list : [{"url":"http://p2.pstatp.com/large/f89000153afa57a50d6.webp"},{"url":"http://pb3.pstatp.com/large/f89000153afa57a50d6.webp"},{"url":"http://pb3.pstatp.com/large/f89000153afa57a50d6.webp"}]
     * uri : large/f89000153afa57a50d6
     */

    private LargeCoverBean large_cover;
    private String title;
    /**
     * user_id : 7008962434
     * name : 丶整颗心丶
     * followings : 9
     * user_verified : false
     * ugc_count : 9
     * avatar_url : http://p2.pstatp.com/thumb/e580002f4811f2630f3
     * followers : 119
     * is_following : false
     * is_pro_user : true
     */
    private UserBean user;
    private String share_url;
    private int comment_count;
    private int share_count;
    private int type;
    private int bury_count;
    @SerializedName("large_image")
    private large_image large_image;
    @SerializedName("gifvideo")
    private gifvideo gifvideo;
    @SerializedName("text")
    private String text;

    public GroupBean.large_image getLarge_image() {
        return large_image;
    }

    public void setLarge_image(GroupBean.large_image large_image) {
        this.large_image = large_image;
    }

    public GroupBean.gifvideo getGifvideo() {
        return gifvideo;
    }

    public void setGifvideo(GroupBean.gifvideo gifvideo) {
        this.gifvideo = gifvideo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
         * url : http://p2.pstatp.com/large/f89000153afa57a50d6.webp
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

    public static class large_image {
        @Override
        public String toString() {
            return "large_image{" +
                    "url_list=" + url_list +
                    '}';
        }

        /**
         * url : http://p1.pstatp.com/w440/ecb0001eb6795eaec7b.webp
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

    public static class gifvideo {
        @Override
        public String toString() {
            return "gifvideo{" +
                    "mp4_url='" + mp4_url + '\'' +
                    '}';
        }

        private String mp4_url;

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }
    }
}
