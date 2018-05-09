package com.example.jingdongdeom.model.SyModel;

import com.example.jingdongdeom.Bean.ShopBean;
import com.example.jingdongdeom.presenter.Presenter.IP.IMShopPresenter;
import com.example.jingdongdeom.presenter.Presenter.ShopPresenter;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/4/25.
 */

public class ShopModel  {
    private  IMShopPresenter imShopPresenter;

    public ShopModel(IMShopPresenter imShopPresenter) {
        this.imShopPresenter=imShopPresenter;

    }


    public void getshop(final String s, int uid) {

        Map<String,String> map = new HashMap<>();

        map.put("uid", String.valueOf(uid));
        map.put("source","android");
        RetrofitManager.post(s, map, new BaseObserver<ShopBean>() {
            @Override
            public void success(ShopBean shopBean) {
                imShopPresenter.shop(shopBean);


            }

            @Override
            public void failure(int code) {

            }
        });
    }
}

