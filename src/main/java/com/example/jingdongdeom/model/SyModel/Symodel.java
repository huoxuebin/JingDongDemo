package com.example.jingdongdeom.model.SyModel;

import com.example.jingdongdeom.Bean.SyBean;
import com.example.jingdongdeom.presenter.Presenter.IP.IMSyPresenter;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class Symodel {

    private  IMSyPresenter imSyPresenter;

    public Symodel(IMSyPresenter imSyPresenter) {
        this.imSyPresenter=imSyPresenter;

    }

    public void getshouye(String shouye) {

        Map<String,String> map = new HashMap<>();
        RetrofitManager.get(shouye, map, new BaseObserver<SyBean>() {
            @Override
            public void success(SyBean syBean) {

                imSyPresenter.success(syBean);
            }

            @Override
            public void failure(int code) {

            }
        });


    }
}
