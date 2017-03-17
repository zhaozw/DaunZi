package com.jkt.workdaunzi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/10/29 0029.
 */

public class SlideModel {
    @Override
    public String toString() {
        return "SlideModel{" +
                "meta=" + meta +
                ", body=" + body +
                '}';
    }

    /**
     * id : http://api.iclient.ifeng.com/ipadtestdoc?aid=114115021&gv=4.4.1&av=4.4.1&uid=865479029646411&deviceid=865479029646411&proid=ifengnews&os=android_22&df=androidphone&vt=5&screen=1152x1920&publishid=2024
     * type : slides
     * o : 1
     * documentId : imcp_114115021
     * class : 80070187
     */

    private MetaBean meta;
    /**
     * url : http://t.ifeng.com/appshare/5896906.shtml
     * wwwurl : http://t.ifeng.com/appshare/5896906.shtml
     * commentsUrl : http://t.ifeng.com/appshare/5896906.shtml
     * documentId : imcp_114115021
     * shareurl : http://share.iclient.ifeng.com/news/sharenews.f?aid=114115021
     * source : 凤凰网
     * title : 朴槿惠闺蜜干政事件相关画面
     * text :
     * slides : [{"image":"http://d.ifengimg.com/mw640_q75/p0.ifengimg.com/a/2016_44/a9373dcc22ebca0_size40_w645_h341.jpg","title":"朴槿惠闺蜜干政事件相关画面","description":"韩国JTBC电视台24日晚的一则报道\u201c震惊全国\u201d。该媒体声称，并无任何官职的朴槿惠亲信崔顺实曾收到过包括44份总统演讲稿在内的200多份文件，其中部分演讲稿的打开时间在总统演讲前，而且崔顺实在总统演讲前曾修改过演讲稿。图为崔顺实与高荣泰（韩国电视画面截屏）。"},{"image":"http://d.ifengimg.com/mw640_q75/p1.ifengimg.com/a/2016_44/7b46b8a623a71c1_size239_w2048_h1536.jpg","title":"朴槿惠闺蜜干政事件相关画面","description":"随后的25日，负责调查朴槿惠亲信崔顺实涉腐丑闻的首尔高检调查组对崔顺实的住宅、米勒财团、K体育财团及全国经济人联合会办公室同时进行了搜查和现场取证。韩国《中央日报》26日称，通过对崔顺实的电脑文档进一步的分析显示，崔不只是单纯修改朴槿惠总统的演讲稿，还接触了国家机密文件。报道指出，从表面来看，崔顺实与两个财团之间并无直接关联，但她涉嫌安插亲信担任财团要职，并通过德国和韩国多家公司挪用公款。崔顺实与朴槿惠、李明博（韩国JTBC截图）。"},{"image":"http://d.ifengimg.com/mw640_q75/p1.ifengimg.com/a/2016_44/90474ade4a1e55c_size46_w290_h339.jpg","title":"朴槿惠闺蜜干政事件相关画面","description":"面对证据，朴槿惠也于25日正式发表《致国民书》向国民道歉。而据韩国民调机构Realmeter27日发布的数据，这位韩国首位女总统的支持率在26日已经跌至17.5%，首次跌破了20%，七成受访者对其施政情况给予消极评价；对于朴槿惠应如何为此次事件负责，42.3%受访者主张她引咎辞职或者被国会弹劾，其后依次为\u201c改组青瓦台和内阁\u201d\u201c总统退党\u201d。另一方面，韩国在野党共同民主党的支持率则升至29%，为今年以来最高，也是现政府成立以来该党支持率首次与执政的新国家党持平。图为崔泰民。"},{"image":"http://d.ifengimg.com/mw640_q75/p0.ifengimg.com/a/2016_44/0633c24c967193a_size23_w250_h353.jpg","title":"朴槿惠闺蜜干政事件相关画面","description":"韩国《世界日报》27日报道，位于舆论中心的\u201c干政\u201d事件另一\u201c主角\u201d崔顺实也终于在德国现身并首度表态回应，承认曾修改朴槿惠的演讲稿，还承认自己在朴槿惠当选总统后一段时间内收到过青瓦台发来的资料，但否认媒体对她与两家基金会关系的指认以及相关\u201c索贿\u201d的指控。图为崔泰民与年轻时的朴槿惠。"},{"image":"http://d.ifengimg.com/mw640_q75/p0.ifengimg.com/a/2016_44/dd6623f483fa4ef_size72_w600_h773.jpg","title":"朴槿惠闺蜜干政事件相关画面","description":"这样的\u201c政治丑闻\u201d举国震惊。在野党显然不会放过此次机会。据韩国KBS电视台26日报道，韩国在野党当天纷纷表示，应该对青瓦台进行重组，并对朴槿惠本人进行调查。图为高荣泰。"},{"image":"http://d.ifengimg.com/mw640_q75/p3.ifengimg.com/a/2016_44/014d18c3c4555a1_size44_w398_h487.jpg","title":"朴槿惠闺蜜干政事件相关画面","description":"朴槿惠使用高荣泰生产的包。"}]
     * pre : {"id":"114115080","title":"科尔：被马刺打得落花流水 我们所有弱点都暴露出来","type":"doc"}
     * next : {"id":"114114888","title":"石家庄一楼市项目擅自提价 官方强化整治责令取消","type":"doc"}
     * recommend : [{"title":"姚晨挺大肚唱跳神曲 星爷徐克伴舞","id":"114090890","type":"slide","links":"http://api.iclient.ifeng.com/ipadtestdoc?aid=114090890","thumbnail":"http://d.ifengimg.com/w318_h222_q75/p1.ifengimg.com/cmpp/2016/10/28/09/a7cda747-8512-40ba-8151-ca93a5a1113d_size95_w900_h600.jpg"},{"title":"国外匪夷所思生子秘方","id":"114033379","type":"slide","links":"http://api.iclient.ifeng.com/ipadtestdoc?aid=114033379","thumbnail":"http://d.ifengimg.com/w318_h222_q75/p3.ifengimg.com/a/2016_44/b935d294efd2987_size133_w500_h321.jpg"},{"title":"金色优雅银色稳重 cool1手机双色图赏","id":"114069697","type":"slide","links":"http://api.iclient.ifeng.com/ipadtestdoc?aid=114069697","thumbnail":"http://d.ifengimg.com/w318_h222_q75/p3.ifengimg.com/a/2016_44/f2a6a63a6d23382_size680_w825_h550.jpg"},{"title":"海关缉私局大门前石狮被\u201c关\u201d入笼内。","id":"114112926","type":"slide","links":"http://api.iclient.ifeng.com/ipadtestdoc?aid=114112926","thumbnail":"http://d.ifengimg.com/w318_h222_q75/p1.ifengimg.com/cmpp/2016/10/29/07/625abf62-6636-4ce3-8ba2-cac7e8e89a29_size291_w1024_h704.jpg"},{"title":"布达拉宫上的\u201c蜘蛛人\u201d","id":"114112310","type":"slide","links":"http://api.iclient.ifeng.com/ipadtestdoc?aid=114112310","thumbnail":"http://d.ifengimg.com/w318_h222_q75/p1.ifengimg.com/a/2016_44/1120531686fa4b6_size85_w899_h609.jpg"},{"title":"这样装修卧室 床和衣柜都省了！","id":"114009062","type":"slide","links":"http://api.iclient.ifeng.com/ipadtestdoc?aid=114009062","thumbnail":"http://d.ifengimg.com/w318_h222_q75/p2.ifengimg.com/a/2016_44/fd731db3a32aebd_size167_w564_h641.jpg"}]
     * cate : http://news.ifeng.com/app/api/slides/index-json.shtml
     * editTime : 2016/10/29 09:33:00
     * updateTime :
     */

    private BodyBean body;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class MetaBean {
        @Override
        public String toString() {
            return "MetaBean{" +
                    "id='" + id + '\'' +
                    ", type='" + type + '\'' +
                    ", o=" + o +
                    ", documentId='" + documentId + '\'' +
                    ", classX='" + classX + '\'' +
                    '}';
        }

        private String id;
        private String type;
        private int o;
        private String documentId;
        @SerializedName("class")
        private String classX;

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

        public int getO() {
            return o;
        }

        public void setO(int o) {
            this.o = o;
        }

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getClassX() {
            return classX;
        }

        public void setClassX(String classX) {
            this.classX = classX;
        }
    }

    public static class BodyBean {
        @Override
        public String toString() {
            return "BodyBean{" +
                    "url='" + url + '\'' +
                    ", wwwurl='" + wwwurl + '\'' +
                    ", commentsUrl='" + commentsUrl + '\'' +
                    ", documentId='" + documentId + '\'' +
                    ", shareurl='" + shareurl + '\'' +
                    ", source='" + source + '\'' +
                    ", title='" + title + '\'' +
                    ", text='" + text + '\'' +
                    ", pre=" + pre +
                    ", next=" + next +
                    ", cate='" + cate + '\'' +
                    ", editTime='" + editTime + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    ", slides=" + slides +
                    ", recommend=" + recommend +
                    '}';
        }

        private String url;
        private String wwwurl;
        private String commentsUrl;
        private String documentId;
        private String shareurl;
        private String source;
        private String title;
        private String text;
        /**
         * id : 114115080
         * title : 科尔：被马刺打得落花流水 我们所有弱点都暴露出来
         * type : doc
         */

        private PreBean pre;
        /**
         * id : 114114888
         * title : 石家庄一楼市项目擅自提价 官方强化整治责令取消
         * type : doc
         */

        private NextBean next;
        private String cate;
        private String editTime;
        private String updateTime;
        /**
         * image : http://d.ifengimg.com/mw640_q75/p0.ifengimg.com/a/2016_44/a9373dcc22ebca0_size40_w645_h341.jpg
         * title : 朴槿惠闺蜜干政事件相关画面
         * description : 韩国JTBC电视台24日晚的一则报道“震惊全国”。该媒体声称，并无任何官职的朴槿惠亲信崔顺实曾收到过包括44份总统演讲稿在内的200多份文件，其中部分演讲稿的打开时间在总统演讲前，而且崔顺实在总统演讲前曾修改过演讲稿。图为崔顺实与高荣泰（韩国电视画面截屏）。
         */

        private List<SlidesBean> slides;
        /**
         * title : 姚晨挺大肚唱跳神曲 星爷徐克伴舞
         * id : 114090890
         * type : slide
         * links : http://api.iclient.ifeng.com/ipadtestdoc?aid=114090890
         * thumbnail : http://d.ifengimg.com/w318_h222_q75/p1.ifengimg.com/cmpp/2016/10/28/09/a7cda747-8512-40ba-8151-ca93a5a1113d_size95_w900_h600.jpg
         */

        private List<RecommendBean> recommend;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWwwurl() {
            return wwwurl;
        }

        public void setWwwurl(String wwwurl) {
            this.wwwurl = wwwurl;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getShareurl() {
            return shareurl;
        }

        public void setShareurl(String shareurl) {
            this.shareurl = shareurl;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public PreBean getPre() {
            return pre;
        }

        public void setPre(PreBean pre) {
            this.pre = pre;
        }

        public NextBean getNext() {
            return next;
        }

        public void setNext(NextBean next) {
            this.next = next;
        }

        public String getCate() {
            return cate;
        }

        public void setCate(String cate) {
            this.cate = cate;
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

        public List<SlidesBean> getSlides() {
            return slides;
        }

        public void setSlides(List<SlidesBean> slides) {
            this.slides = slides;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public static class PreBean {
            private String id;
            private String title;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class NextBean {
            private String id;
            private String title;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class SlidesBean {
            private String image;
            private String title;
            private String description;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class RecommendBean {
            private String title;
            private String id;
            private String type;
            private String links;
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

            public String getLinks() {
                return links;
            }

            public void setLinks(String links) {
                this.links = links;
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
