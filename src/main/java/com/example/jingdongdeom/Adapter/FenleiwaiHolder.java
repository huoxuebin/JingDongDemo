package com.example.jingdongdeom.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jingdongdeom.R;

/**
 * Created by huoxuebin on 2018/4/24.
 */

public  class FenleiwaiHolder extends RecyclerView.ViewHolder {

    public   TextView wainame;
    public   RecyclerView recyclerView;

    public FenleiwaiHolder(View itemView) {
        super(itemView);

        wainame = itemView.findViewById(R.id.wainame);
        recyclerView = itemView.findViewById(R.id.wairy);

    }
}
