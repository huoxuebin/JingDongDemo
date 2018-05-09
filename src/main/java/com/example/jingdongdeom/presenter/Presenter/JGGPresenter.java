package com.example.jingdongdeom.presenter.Presenter;

import com.example.jingdongdeom.Bean.JGBean;
import com.example.jingdongdeom.Fragment.Fragment_shouye;
import com.example.jingdongdeom.model.SyModel.JGGModel;
import com.example.jingdongdeom.presenter.Presenter.IP.IMJGpresenter;
import com.example.jingdongdeom.view.IV.IMjiugongge;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class JGGPresenter implements IMJGpresenter {

    private  IMjiugongge iMjiugongge;
    private  JGGModel jggModel;

    public JGGPresenter(IMjiugongge iMjiugongge) {
            this.iMjiugongge=iMjiugongge;

        jggModel = new JGGModel(this);

    }

    public void getjgg(String s) {
        jggModel.getjgg(s);

    }

    @Override
    public void jiugongge(JGBean jgBean) {
        iMjiugongge.jiugongge(jgBean);
    }
}
