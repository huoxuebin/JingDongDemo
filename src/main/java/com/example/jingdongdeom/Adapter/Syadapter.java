package com.example.jingdongdeom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jingdongdeom.Bean.JGBean;

import com.example.jingdongdeom.Holder.SyHolder;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;

import java.util.List;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class Syadapter extends RecyclerView.Adapter<SyHolder> {

    List<JGBean.DataBean> data;
    Context context;
    private OnItemClickListener onItemClickListener;

    public Syadapter(List<JGBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public SyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.jiugongge, null);
        //View view = LayoutInflater.from(context).inflate(R.layout.jiugongge, parent, false);
        SyHolder syHolder = new SyHolder(view);


        return syHolder;
    }


    @Override
    public void onBindViewHolder(final SyHolder holder, final int position) {

        holder.title.setText(data.get(position).getName());
        String icon = data.get(position).getIcon();
        Glide.with(context).load(icon).into(holder.imageView);


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
}
