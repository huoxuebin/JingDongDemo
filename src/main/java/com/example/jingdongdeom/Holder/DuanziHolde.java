package com.example.jingdongdeom.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdongdeom.R;

/**
 * Created by huoxuebin on 2018/4/27.
 */

public class DuanziHolde extends RecyclerView.ViewHolder {

    public   ImageView imageView;
    public   TextView textView;

    public DuanziHolde(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.duanimg);
        textView = itemView.findViewById(R.id.duanname);




    }
}
