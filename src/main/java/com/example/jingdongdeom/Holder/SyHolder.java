package com.example.jingdongdeom.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jingdongdeom.R;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class SyHolder extends RecyclerView.ViewHolder {

    public   ImageView imageView;
    public  TextView title;

    public SyHolder(View itemView) {
        super(itemView);


        imageView = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);




    }
}
