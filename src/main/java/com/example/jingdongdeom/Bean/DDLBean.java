package com.example.jingdongdeom.Bean;

import java.util.List;

/**
 * Created by huoxuebin on 2018/4/26.
 */

public class DDLBean {


    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2018-01-15T08:47:13","orderid":6913,"price":1,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T13:32:53","orderid":7016,"price":99.99,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T14:56:29","orderid":7094,"price":99.99,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T20:33:23","orderid":7418,"price":99.99,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T20:35:19","orderid":7425,"price":99.99,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T20:35:39","orderid":7427,"price":6633,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T20:36:24","orderid":7428,"price":6633,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T21:01:49","orderid":7438,"price":6633,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-15T21:02:10","orderid":7439,"price":6633,"status":0,"title":"订单测试标题70","uid":70},{"createtime":"2018-01-16T08:36:44","orderid":7449,"price":1404,"status":0,"title":"订单测试标题70","uid":70}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2018-01-15T08:47:13
         * orderid : 6913
         * price : 1.0
         * status : 0
         * title : 订单测试标题70
         * uid : 70
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private String title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
