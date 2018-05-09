package com.example.jingdongdeom.Bean;

import java.util.List;

/**
 * Created by huoxuebin on 2018/4/27.
 */

public class Bean {


    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"鸡翅还吃","createTime":"2018-04-27T19:43:50","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524829430588login.png|https://www.zhaoapi.cn/images/quarter/1524829430588splash.png","jid":2384,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524799498120head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"测试数据","createTime":"2018-04-27T19:31:33","imgUrls":null,"jid":2383,"praiseNum":null,"shareNum":null,"uid":11510,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524473753240spl.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"快快快快快快快","createTime":"2018-04-27T19:09:02","imgUrls":null,"jid":2382,"praiseNum":null,"shareNum":null,"uid":12457,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524481043273gaga_icon.jpg","nickname":"你林超级帅","praiseNum":"null"}},{"commentNum":null,"content":"神神叨叨的","createTime":"2018-04-27T19:08:36","imgUrls":null,"jid":2381,"praiseNum":null,"shareNum":null,"uid":12457,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524481043273gaga_icon.jpg","nickname":"你林超级帅","praiseNum":"null"}},{"commentNum":null,"content":"阿鲁特","createTime":"2018-04-27T19:03:01","imgUrls":null,"jid":2380,"praiseNum":null,"shareNum":null,"uid":1570,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524652097718crop_photo.jpg","nickname":"我是XXX","praiseNum":"null"}},{"commentNum":null,"content":"反反复复付","createTime":"2018-04-27T18:16:37","imgUrls":null,"jid":2379,"praiseNum":null,"shareNum":null,"uid":11080,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523842330803head1.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"咯rosy","createTime":"2018-04-27T17:06:12","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524819972717avatar-25-27667.jpg|https://www.zhaoapi.cn/images/quarter/1524819972733avatar-14-31491.jpg|https://www.zhaoapi.cn/images/quarter/1524819972733avatar-14-31485.jpg|https://www.zhaoapi.cn/images/quarter/1524819972733avatar-25-29151.jpg","jid":2378,"praiseNum":null,"shareNum":null,"uid":2809,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524819602855head_icon.jpg","nickname":"孑然","praiseNum":"null"}},{"commentNum":null,"content":"咯rosy","createTime":"2018-04-27T17:06:08","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524819968842avatar-25-27667.jpg|https://www.zhaoapi.cn/images/quarter/1524819968858avatar-14-31491.jpg|https://www.zhaoapi.cn/images/quarter/1524819968858avatar-14-31485.jpg|https://www.zhaoapi.cn/images/quarter/1524819968858avatar-25-29151.jpg","jid":2377,"praiseNum":null,"shareNum":null,"uid":2809,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524819602855head_icon.jpg","nickname":"孑然","praiseNum":"null"}},{"commentNum":null,"content":"第三方士大夫士大夫是444","createTime":"2018-04-27T16:33:54","imgUrls":null,"jid":2376,"praiseNum":null,"shareNum":null,"uid":11080,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523842330803head1.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"第三方士大夫士大夫是444","createTime":"2018-04-27T16:30:22","imgUrls":null,"jid":2375,"praiseNum":null,"shareNum":null,"uid":11080,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523842330803head1.jpg","nickname":null,"praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 鸡翅还吃
         * createTime : 2018-04-27T19:43:50
         * imgUrls : https://www.zhaoapi.cn/images/quarter/1524829430588login.png|https://www.zhaoapi.cn/images/quarter/1524829430588splash.png
         * jid : 2384
         * praiseNum : null
         * shareNum : null
         * uid : 12882
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524799498120head_icon.jpg","nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524799498120head_icon.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
