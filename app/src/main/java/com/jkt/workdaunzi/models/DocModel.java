package com.jkt.workdaunzi.models;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/10/27 0027.
 */

public class DocModel {

    /**
     * id : http://api.iclient.ifeng.com/ipadtestdoc?aid=cmpp_030010050165009&channelKey=Y21wcF8xNzAwN183MTlfNzU%3D&gv=4.4.1&av=4.4.1&uid=865479029646411&deviceid=865479029646411&proid=ifengnews&os=android_22&df=androidphone&vt=5&screen=1152x1920&publishid=2024http%3A%2F%2Fapi.3g.ifeng.com%2Fipadtestdoc%3F
     * type : doc
     * o : 1
     * documentId : cmpp_030010050165009
     */

    /**
     * documentId : cmpp_030010050165009
     * title : 国防部新闻发言人证实：近期将“适度上调”军人工资
     * thumbnail_doc : {"size":{"width":"600","height":"443"},"url":"http://p3.ifengimg.com/a/2016_44/ca40ec2814ad6cb_size23_w600_h443.jpg"}
     * source : 军报记者
     * author :
     * editorcode : 唐艺赫 PN085
     * editTime : 2016/10/27 16:11:47
     * updateTime : 2016/10/27 19:46:25
     * wapurl : http://inews.ifeng.com/50165009/news.shtml
     * introduction :
     * wwwurl : http://news.ifeng.com/a/20161027/50165009_0.shtml
     * shareurl : http://share.iclient.ifeng.com/sharenews.f?aid=cmpp_030010050165009
     * commentsUrl : http://news.ifeng.com/a/20161027/50165009_0.shtml
     * commentCount : 0
     * text :
     * img : [{"url":"http://d.ifengimg.com/mw640_q75/p3.ifengimg.com/a/2016_44/ca40ec2814ad6cb_size23_w600_h443.jpg","size":{"width":"600","height":"443"}}]
     * likeCount : 0
     * commentType : 0
     * recommend_doc : [{"title":"你的血管堵塞到哪个程度？出现不良反应时，则为时已晚！","id":"114026429","type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=114026429","thumbnail":"http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/yidian/2016_44/67584971124a956_w647_h399.jpg"},{"title":"未解：宇宙时间竟然一直在膨胀","id":"114050451","type":"doc","url":"http://api.3g.ifeng.com/ipadtestdoc?aid=114050451","thumbnail":"http://d.ifengimg.com/w134_h96_q75/p3.ifengimg.com/yidian/2016_44/ddae3b674ff1a73_w441_h333.jpg"}]
     * recommend_slide : [{"title":"想不到不同国家眼中的胖瘦标准差这么多","id":"113978180","type":"slide","url":"http://api.iclient.ifeng.com/ipadtestdoc?aid=113978180","thumbnail":"http://d.ifengimg.com/w243_h165_q75/p2.ifengimg.com/a/2016_44/c38c71a521b06c3_size148_w600_h842.jpg"},{"title":"【谈心】善良是你对待弱者的态度","id":"114067846","type":"slide","url":"http://api.iclient.ifeng.com/ipadtestdoc?aid=114067846","thumbnail":""}]
     */

    private BodyBean body;


    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }


    public static class BodyBean {
        private String documentId;
        private String title;
        /**
         * size : {"width":"600","height":"443"}
         * url : http://p3.ifengimg.com/a/2016_44/ca40ec2814ad6cb_size23_w600_h443.jpg
         */

        private String source;
        private String editTime;
        private String updateTime;
        private String wapurl;
        private String introduction;
        private String wwwurl;
        private String shareurl;
        private String commentsUrl;
        private String text;
        /**
         * url : http://d.ifengimg.com/mw640_q75/p3.ifengimg.com/a/2016_44/ca40ec2814ad6cb_size23_w600_h443.jpg
         * size : {"width":"600","height":"443"}
         */

        private List<ImgBean> img;
        /**
         * title : 你的血管堵塞到哪个程度？出现不良反应时，则为时已晚！
         * id : 114026429
         * type : doc
         * url : http://api.3g.ifeng.com/ipadtestdoc?aid=114026429
         * thumbnail : http://d.ifengimg.com/w134_h96_q75/p0.ifengimg.com/yidian/2016_44/67584971124a956_w647_h399.jpg
         */

        private List<RecommendDocBean> recommend_doc;
        /**
         * title : 想不到不同国家眼中的胖瘦标准差这么多
         * id : 113978180
         * type : slide
         * url : http://api.iclient.ifeng.com/ipadtestdoc?aid=113978180
         * thumbnail : http://d.ifengimg.com/w243_h165_q75/p2.ifengimg.com/a/2016_44/c38c71a521b06c3_size148_w600_h842.jpg
         */

        private List<RecommendSlideBean> recommend_slide;

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }


        public String getEditTime() {
            return editTime;
        }

        public void setEditTime(String editTime) {
            this.editTime = editTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWapurl() {
            return wapurl;
        }

        public void setWapurl(String wapurl) {
            this.wapurl = wapurl;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getWwwurl() {
            return wwwurl;
        }

        public void setWwwurl(String wwwurl) {
            this.wwwurl = wwwurl;
        }

        public String getShareurl() {
            return shareurl;
        }

        public void setShareurl(String shareurl) {
            this.shareurl = shareurl;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }


        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }



        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public List<RecommendDocBean> getRecommend_doc() {
            return recommend_doc;
        }

        public void setRecommend_doc(List<RecommendDocBean> recommend_doc) {
            this.recommend_doc = recommend_doc;
        }

        public List<RecommendSlideBean> getRecommend_slide() {
            return recommend_slide;
        }

        public void setRecommend_slide(List<RecommendSlideBean> recommend_slide) {
            this.recommend_slide = recommend_slide;
        }


        public static class ImgBean {
            private String url;
            /**
             * width : 600
             * height : 443
             */

            private SizeBean size;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public SizeBean getSize() {
                return size;
            }

            public void setSize(SizeBean size) {
                this.size = size;
            }

            public static class SizeBean {
                private String width;
                private String height;

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }
        }

        public static class RecommendDocBean {
            private String title;
            private String id;
            private String type;
            private String url;
            private String thumbnail;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
        }

        public static class RecommendSlideBean {
            private String title;
            private String id;
            private String type;
            private String url;
            private String thumbnail;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
        }
    }
}
