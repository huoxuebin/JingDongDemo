package com.example.jingdongdeom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jingdongdeom.Bean.Bean;
import com.example.jingdongdeom.Holder.DuanziHolde;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;

import java.util.List;

/**
 * Created by huoxuebin on 2018/4/27.
 */

public class DuanziAdapter extends RecyclerView.Adapter<DuanziHolde> {

    List<Bean.DataBean> data;
    Context context;
    private OnItemClickListener onItemClickListener;


    public DuanziAdapter(List<Bean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public DuanziHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.duanzi, null);
        DuanziHolde duanziHolde = new DuanziHolde(view);

        return duanziHolde;
    }

    @Override
    public void onBindViewHolder(DuanziHolde holder, final int position) {
        String content = data.get(position).getContent();


        holder.textView.setText(content);
        String imgUrls = data.get(position).getUser().getIcon();

        Glide.with(context).load(imgUrls).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                notifyDataSetChanged();

            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void  setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;

    }
}
