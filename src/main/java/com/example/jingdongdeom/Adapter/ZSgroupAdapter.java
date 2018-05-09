package com.example.jingdongdeom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jingdongdeom.Bean.ZSBean;
import com.example.jingdongdeom.Holder.GroupHolder;
import com.example.jingdongdeom.Holder.TJHolder;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;

import java.util.List;

/**
 * Created by huoxuebin on 2018/4/23.
 */

public class ZSgroupAdapter extends RecyclerView.Adapter<GroupHolder> {

    List<ZSBean.DataBean> data;
    Context context;
    private OnItemClickListener onItemClickListener;

    public ZSgroupAdapter(List<ZSBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public GroupHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.zhanshigroup, null);
        GroupHolder groupHolder = new GroupHolder(view);
        return groupHolder;
    }

    @Override
    public void onBindViewHolder(GroupHolder holder, final int position) {
        holder.price.setText("￥"+data.get(position).getPrice());
        holder.title.setText(data.get(position).getTitle());
        String images = data.get(position).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
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


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
