package com.example.jingdongdeom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jingdongdeom.Bean.SyBean;
import com.example.jingdongdeom.Holder.SyHolder;
import com.example.jingdongdeom.Holder.TJHolder;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class TuijianAdapter extends RecyclerView.Adapter<TJHolder> {

    SyBean.TuijianBean tuijian;
    Context context;
    private OnItemClickListener onItemClickListener;

    public TuijianAdapter(SyBean.TuijianBean tuijian, Context context) {
        this.tuijian = tuijian;
        this.context = context;
    }

    @Override
    public TJHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.tuijian, null);
        //View view = LayoutInflater.from(context).inflate(R.layout.tuijian, parent, false);
        TJHolder tjHolder = new TJHolder(view);

        return tjHolder;
    }

    @Override
    public void onBindViewHolder(final TJHolder holder, final int position) {

        holder.title.setText(tuijian.getList().get(position).getTitle());
        holder.price.setText("￥"+tuijian.getList().get(position).getPrice());
        String images = tuijian.getList().get(position).getImages();
        String[] split = images.split("\\|");


        Glide.with(context).load(split[0]).into(holder.imageView);


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onItemClickListener.onItemClick(position);
            }
        });

    }



    @Override
    public int getItemCount() {
        return tuijian.getList().size();
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
      this.onItemClickListener = onItemClickListener;
    }
}

