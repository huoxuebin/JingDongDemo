package com.example.jingdongdeom.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.jingdongdeom.Adapter.DuanziAdapter;
import com.example.jingdongdeom.Bean.Bean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by huoxuebin on 2018/4/27.
 */

public class ContentFragment extends Fragment {


    int page=1;
    private XRecyclerView xRecyclerView;


                @Nullable
                @Override
                public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                    View view = inflater.inflate(R.layout.viewpager, container, false);

                    //获取控件
                    xRecyclerView = view.findViewById(R.id.duanzi);
                    xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallZigZag); //设定下拉刷新样式
                    xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);//设定上拉加载样式
                    xRecyclerView.setArrowImageView(R.drawable.root);     //设定下拉刷新显示图片（不必须）



                    xRecyclerView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {


                            return false;
                        }
                    });
                    xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                        @Override
                        public void onRefresh() {
                            page=1;
                            xRecyclerView.refreshComplete();
                        }
                        @Override
                        public void onLoadMore() {
                            page=page+1;
                            qingqiu();
                          //  xRecyclerView.loadMoreComplete();
                        }
                    });
                qingqiu();
                return view;
            }
            public void qingqiu(){

                Map<String,String> map = new HashMap<>();
                map.put("page","1");
                map.put("source","android");
                map.put("appVersion","1");
                RetrofitManager.post("quarter/getJokes", map, new BaseObserver<Bean>() {
                    @Override
                    public void success(Bean bean) {
                        List<Bean.DataBean> data = bean.getData();

                        Log.i("aaa","ppp"+bean);
                        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL,false));
                        DuanziAdapter duanziAdapter = new DuanziAdapter(data,getActivity());
                        xRecyclerView.setAdapter(duanziAdapter);
                    }
                    @Override
                    public void failure(int code) {

                    }
                });
            }
        }
