package com.example.jingdongdeom.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdongdeom.R;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class TJHolder extends RecyclerView.ViewHolder {

    public   ImageView imageView;
    public  TextView title;
    public  TextView price;
    public TJHolder(View itemView) {
        super(itemView);


        imageView = itemView.findViewById(R.id.image2);
        title = itemView.findViewById(R.id.title2);

        price = itemView.findViewById(R.id.price);



    }
}
