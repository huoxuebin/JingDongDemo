package com.example.jingdongdeom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jingdongdeom.Bean.SyBean;
import com.example.jingdongdeom.Holder.MsHolder;

import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class MsAdapter extends RecyclerView.Adapter<MsHolder> {



    SyBean.MiaoshaBean miaosha;
    Context context;
    private OnItemClickListener onItemClickListener;


    public MsAdapter(SyBean.MiaoshaBean miaosha, Context context) {
        this.miaosha = miaosha;
        this.context = context;
    }

    @Override
    public MsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.miaosha, null);
      //  View view = LayoutInflater.from(context).inflate(R.layout.miaosha, parent, false);
        MsHolder syHolder = new MsHolder(view);


        return syHolder;
    }


    @Override
    public void onBindViewHolder(MsHolder holder, final int position) {

       holder.miaoshatitle.setText(miaosha.getList().get(position).getTitle());
        String images = miaosha.getList().get(position).getImages();
        String[] split = images.split("\\|");


        Glide.with(context).load(split[0]).into(holder.miaoshaimageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return miaosha.getList().size();
    }



    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
}
