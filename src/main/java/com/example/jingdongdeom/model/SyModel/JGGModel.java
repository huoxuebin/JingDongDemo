package com.example.jingdongdeom.model.SyModel;

import com.example.jingdongdeom.Bean.JGBean;
import com.example.jingdongdeom.presenter.Presenter.IP.IMJGpresenter;
import com.example.jingdongdeom.presenter.Presenter.JGGPresenter;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class JGGModel  {

    private  IMJGpresenter imjGpresenter;

    public JGGModel(IMJGpresenter imjGpresenter) {
        this.imjGpresenter=imjGpresenter;
    }

    public void getjgg(String s) {

        Map<String,String> map = new HashMap<>();

        RetrofitManager.get(s, map, new BaseObserver<JGBean>() {
            @Override
            public void success(JGBean jgBean) {

                imjGpresenter.jiugongge(jgBean);
            }

            @Override
            public void failure(int code) {

            }
        });
    }
}
