package com.example.jingdongdeom.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.jingdongdeom.Activity.ZhanShiActivity;
import com.example.jingdongdeom.Bean.FenleiBean;
import com.example.jingdongdeom.Holder.NeiHolder;
import com.example.jingdongdeom.R;

import java.util.List;

/**
 * Created by huoxuebin on 2018/4/24.
 */

public class FenleineicengAdapter extends RecyclerView.Adapter<NeiHolder> {

    List<FenleiBean.DataBean.ListBean> list;
    Context context;
    private OnItemClicklistener onItemClickListner;

    public FenleineicengAdapter(List<FenleiBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public NeiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fenleineiceng, null);
        NeiHolder neiHolder = new NeiHolder(view);


        return neiHolder;
    }

    @Override
    public void onBindViewHolder(NeiHolder holder, final int position) {
        holder.neiname.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.neiimg);

        //跳转到展示页面
        holder.neiimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = list.get(position).getName();
                Intent intent = new Intent(context, ZhanShiActivity.class);
                intent.putExtra("name", name);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   //跳转接口
    public interface OnItemClicklistener {
        void onItemClick(View view, int position);
        //void onItemLongClick(View view,int position);
    }

    public void setOnItemClickListner(OnItemClicklistener onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }
}
