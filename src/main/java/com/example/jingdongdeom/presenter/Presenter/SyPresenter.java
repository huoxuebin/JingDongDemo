package com.example.jingdongdeom.presenter.Presenter;

import com.example.jingdongdeom.Bean.SyBean;
import com.example.jingdongdeom.Fragment.Fragment_shouye;
import com.example.jingdongdeom.model.SyModel.Symodel;
import com.example.jingdongdeom.presenter.Presenter.IP.IMSyPresenter;
import com.example.jingdongdeom.view.IV.IMview;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class SyPresenter  implements IMSyPresenter{

    private  IMview iMview;
    private  Symodel symodel;

    public SyPresenter(IMview iMview) {
        this.iMview=iMview;
        symodel = new Symodel(this);


    }
    public void zhikong(){

        if(iMview!=null){
            iMview=null;
        }
    }

    public void getshouye(String shouye) {

        symodel.getshouye(shouye);


    }

    @Override
    public void success(SyBean syBean) {
        iMview.success(syBean);

    }
}
