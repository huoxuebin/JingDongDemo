package com.example.jingdongdeom.presenter.Presenter;

import com.example.jingdongdeom.Bean.ShopBean;
import com.example.jingdongdeom.Fragment.Fragment_shop;
import com.example.jingdongdeom.model.SyModel.ShopModel;
import com.example.jingdongdeom.presenter.Presenter.IP.IMShopPresenter;
import com.example.jingdongdeom.view.IV.IMshopview;

/**
 * Created by huoxuebin on 2018/4/25.
 */

public class ShopPresenter implements IMShopPresenter {

    private  ShopModel shopModel;
    private  IMshopview iMshopview;

    public ShopPresenter(IMshopview iMshopview) {
        this.iMshopview=iMshopview;
        shopModel = new ShopModel(this);


    }

    public void getshop(String s, int uid) {
        shopModel.getshop(s,uid);

    }

    @Override
    public void shop(ShopBean shopBean) {
        iMshopview.shop(shopBean);

    }
}
