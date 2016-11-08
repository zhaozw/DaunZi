package com.jkt.workdaunzi.models;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/2 0002.
 */

public class LiveModel {

    /**
     * code : 100
     * msg : success
     * data : {"list":[{"allnum":19446,"roomid":60123592,"serverid":8,"gps":"来自喵星","flv":"http://hdl.9158.com/live/d7c0c25e99802b4c9279a70f479dcb37.flv","starlevel":2,"familyName":"夜上海","isSign":0,"nation":"","nationFlag":"","useridx":60945121,"userId":"WeiXin19506936","gender":0,"myname":"【夜上海】妖姬妹子","signatures":"求关注，求守护！么么哒！","smallpic":"http://liveimg.9158.com/pic/avator/2016-11/01/15/20161101151354_60945121_250.png","bigpic":"http://liveimg.9158.com/pic/avator/2016-11/01/15/20161101151354_60945121_640.png","level":0,"grade":0,"curexp":0},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}],"totalPage":6,"samecity":0,"hotswitch":{"starttime":"11:00","endtime":"23:59"},"hotswitch2":[{"starttime":"11:00","endtime":"23:59"},{"starttime":"09:00","endtime":"23:55"}],"hotConfig":1}
     */

    private String code;
    private String msg;
    /**
     * list : [{"allnum":19446,"roomid":60123592,"serverid":8,"gps":"来自喵星","flv":"http://hdl.9158.com/live/d7c0c25e99802b4c9279a70f479dcb37.flv","starlevel":2,"familyName":"夜上海","isSign":0,"nation":"","nationFlag":"","useridx":60945121,"userId":"WeiXin19506936","gender":0,"myname":"【夜上海】妖姬妹子","signatures":"求关注，求守护！么么哒！","smallpic":"http://liveimg.9158.com/pic/avator/2016-11/01/15/20161101151354_60945121_250.png","bigpic":"http://liveimg.9158.com/pic/avator/2016-11/01/15/20161101151354_60945121_640.png","level":0,"grade":0,"curexp":0},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}]
     * totalPage : 6
     * samecity : 0
     * hotswitch : {"starttime":"11:00","endtime":"23:59"}
     * hotswitch2 : [{"starttime":"11:00","endtime":"23:59"},{"starttime":"09:00","endtime":"23:55"}]
     * hotConfig : 1
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int totalPage;
        private int samecity;
        /**
         * starttime : 11:00
         * endtime : 23:59
         */

        private HotswitchBean hotswitch;
        private int hotConfig;
        /**
         * allnum : 19446
         * roomid : 60123592
         * serverid : 8
         * gps : 来自喵星
         * flv : http://hdl.9158.com/live/d7c0c25e99802b4c9279a70f479dcb37.flv
         * starlevel : 2
         * familyName : 夜上海
         * isSign : 0
         * nation :
         * nationFlag :
         * useridx : 60945121
         * userId : WeiXin19506936
         * gender : 0
         * myname : 【夜上海】妖姬妹子
         * signatures : 求关注，求守护！么么哒！
         * smallpic : http://liveimg.9158.com/pic/avator/2016-11/01/15/20161101151354_60945121_250.png
         * bigpic : http://liveimg.9158.com/pic/avator/2016-11/01/15/20161101151354_60945121_640.png
         * level : 0
         * grade : 0
         * curexp : 0
         */

        private List<ListBean> list;
        /**
         * starttime : 11:00
         * endtime : 23:59
         */

        private List<Hotswitch2Bean> hotswitch2;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getSamecity() {
            return samecity;
        }

        public void setSamecity(int samecity) {
            this.samecity = samecity;
        }

        public HotswitchBean getHotswitch() {
            return hotswitch;
        }

        public void setHotswitch(HotswitchBean hotswitch) {
            this.hotswitch = hotswitch;
        }

        public int getHotConfig() {
            return hotConfig;
        }

        public void setHotConfig(int hotConfig) {
            this.hotConfig = hotConfig;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Hotswitch2Bean> getHotswitch2() {
            return hotswitch2;
        }

        public void setHotswitch2(List<Hotswitch2Bean> hotswitch2) {
            this.hotswitch2 = hotswitch2;
        }

        public static class HotswitchBean {
            private String starttime;
            private String endtime;

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }
        }

        public static class ListBean {
            private int allnum;
            private int roomid;
            private int serverid;
            private String gps;
            private String flv;
            private int starlevel;
            private String familyName;
            private int isSign;
            private String nation;
            private String nationFlag;
            private int useridx;
            private String userId;
            private int gender;
            private String myname;
            private String signatures;
            private String smallpic;
            private String bigpic;
            private int level;
            private int grade;
            private int curexp;

            public int getAllnum() {
                return allnum;
            }

            public void setAllnum(int allnum) {
                this.allnum = allnum;
            }

            public int getRoomid() {
                return roomid;
            }

            public void setRoomid(int roomid) {
                this.roomid = roomid;
            }

            public int getServerid() {
                return serverid;
            }

            public void setServerid(int serverid) {
                this.serverid = serverid;
            }

            public String getGps() {
                return gps;
            }

            public void setGps(String gps) {
                this.gps = gps;
            }

            public String getFlv() {
                return flv;
            }

            public void setFlv(String flv) {
                this.flv = flv;
            }

            public int getStarlevel() {
                return starlevel;
            }

            public void setStarlevel(int starlevel) {
                this.starlevel = starlevel;
            }

            public String getFamilyName() {
                return familyName;
            }

            public void setFamilyName(String familyName) {
                this.familyName = familyName;
            }

            public int getIsSign() {
                return isSign;
            }

            public void setIsSign(int isSign) {
                this.isSign = isSign;
            }

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public String getNationFlag() {
                return nationFlag;
            }

            public void setNationFlag(String nationFlag) {
                this.nationFlag = nationFlag;
            }

            public int getUseridx() {
                return useridx;
            }

            public void setUseridx(int useridx) {
                this.useridx = useridx;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getMyname() {
                return myname;
            }

            public void setMyname(String myname) {
                this.myname = myname;
            }

            public String getSignatures() {
                return signatures;
            }

            public void setSignatures(String signatures) {
                this.signatures = signatures;
            }

            public String getSmallpic() {
                return smallpic;
            }

            public void setSmallpic(String smallpic) {
                this.smallpic = smallpic;
            }

            public String getBigpic() {
                return bigpic;
            }

            public void setBigpic(String bigpic) {
                this.bigpic = bigpic;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public int getCurexp() {
                return curexp;
            }

            public void setCurexp(int curexp) {
                this.curexp = curexp;
            }
        }

        public static class Hotswitch2Bean {
            private String starttime;
            private String endtime;

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }
        }
    }
}
