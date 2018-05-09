package com.example.jingdongdeom.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.jingdongdeom.Activity.SerachActivity;
import com.example.jingdongdeom.Activity.XiangQingactivity;
import com.example.jingdongdeom.Activity.ZhanShiActivity;
import com.example.jingdongdeom.Adapter.MsAdapter;
import com.example.jingdongdeom.Adapter.Syadapter;
import com.example.jingdongdeom.Adapter.TuijianAdapter;
import com.example.jingdongdeom.Bean.JGBean;
import com.example.jingdongdeom.Bean.SyBean;
import com.example.jingdongdeom.Glide.GlideImage;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;
import com.example.jingdongdeom.presenter.Presenter.JGGPresenter;
import com.example.jingdongdeom.presenter.Presenter.SyPresenter;
import com.example.jingdongdeom.view.IV.IMjiugongge;
import com.example.jingdongdeom.view.IV.IMview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import java.util.ArrayList;
import java.util.List;

/**
* Created by huoxuebin on 2018/4/20.
*/
public class Fragment_shouye extends Fragment implements IMview,IMjiugongge {

        private Banner banner;
        private ArrayList<String>  list = new ArrayList<>();;
        private RecyclerView recyclerView;
        private RecyclerView recyclerView2;
        private List<SyBean.DataBean> data;
        private MarqueeView marqueeView;
        private RecyclerView recyclerView3;
        private ImageView serach;
    private SyPresenter syPresenter;
    private ImageView op;


    @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_shouye, container, false);

        //实例化presenter对象
        syPresenter = new SyPresenter(this);
                JGGPresenter jggPresenter = new JGGPresenter(this);
                jggPresenter.getjgg("product/getCatagory");

                syPresenter.getshouye("ad/getAd");

                banner = view.findViewById(R.id.banner);
                recyclerView = view.findViewById(R.id.ry);
                recyclerView2 = view.findViewById(R.id.ry2);
                recyclerView3 = view.findViewById(R.id.ry3);
                serach = view.findViewById(R.id.serach);
                op = view.findViewById(R.id.op);

                op.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(),SerachActivity.class);
                        startActivity(intent);
                    }
                });



                //点击搜索框跳转
                serach.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getActivity(), SerachActivity.class);
                        startActivity(intent);

                    }
                });

                    //跑马灯
                     marqueeView = view.findViewById(R.id.marqueeView);

                  final List<String> info = new ArrayList<>();
                  info.add("欢迎访问京东app");
                info.add("赶紧的好好学习吧 马上毕业了");
                marqueeView.startWithList(info);

                marqueeView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(),info.toString(),Toast.LENGTH_LONG).show();
                    }
                });

            return view;
            }
            //接受数据

            //轮播图
            @Override
            public void success(final SyBean syBean) {
            Log.i("+++","---"+syBean);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        data = syBean.getData();

                        for(int i = 0; i< data.size(); i++){
                            String icon = data.get(i).getIcon();
                            list.add(icon);
                        }
                        ///轮播
                        banner.setImageLoader(new GlideImage());
                        banner.setImages(list);
                        banner.setDelayTime(1500);
                        banner.setIndicatorGravity(BannerConfig.CENTER);
                        banner.start();
                        //秒杀
                        final SyBean.MiaoshaBean miaosha = syBean.getMiaosha();


                        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(),OrientationHelper.HORIZONTAL,false));

                        MsAdapter msAdapter = new MsAdapter(miaosha,getActivity());
                        msAdapter.setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Intent intent = new Intent(getActivity(), XiangQingactivity.class);
                                int pid = miaosha.getList().get(position).getPid();

                                intent.putExtra("pid",String.valueOf(pid));
                                startActivity(intent);
                            }
                        });
                        recyclerView2.setAdapter(msAdapter);

                        //展示为你推荐
                        final SyBean.TuijianBean tuijian = syBean.getTuijian();

                        recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(),2,OrientationHelper.VERTICAL,false));

                        TuijianAdapter tuijianAdapter = new TuijianAdapter(tuijian,getActivity());
                        recyclerView3.setAdapter(tuijianAdapter);
                        //
                       tuijianAdapter.setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Intent intent = new Intent(getActivity(), XiangQingactivity.class);
                                int pid = tuijian.getList().get(position).getPid();
                                intent.putExtra("pid",String.valueOf(pid));
                                startActivity(intent);
                            }
                        });

                    }
                });
            }
            //九宫格
            @Override
            public void jiugongge(final JGBean jgBean) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
            public void run() {
                List<JGBean.DataBean> data = jgBean.getData();

                //布局管理器
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,OrientationHelper.HORIZONTAL,false));

                //开启适配器
                Syadapter syadapter = new Syadapter(data,getActivity());
                recyclerView.setAdapter(syadapter);

                //设置点击事件  给展示页面传关键字
                syadapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent = new Intent(getActivity(), ZhanShiActivity.class);
                        String name = jgBean.getData().get(position).getName();

                        intent.putExtra("name",name);
                        startActivity(intent);
                    }
                });
            }
            });

            }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        syPresenter.zhikong();
    }
}