package com.example.jingdongdeom.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdongdeom.R;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class MsHolder extends RecyclerView.ViewHolder {

    public   ImageView miaoshaimageView;
    public  TextView miaoshatitle;

    public MsHolder(View itemView) {
        super(itemView);


        miaoshaimageView = itemView.findViewById(R.id.miaoshaiage);
        miaoshatitle = itemView.findViewById(R.id.miaoshatitle);




    }
}
