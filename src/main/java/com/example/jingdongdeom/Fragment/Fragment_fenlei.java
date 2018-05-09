package com.example.jingdongdeom.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jingdongdeom.Activity.SerachActivity;
import com.example.jingdongdeom.Bean.FlBean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class Fragment_fenlei extends Fragment {

    private ListView listView;
    private FrameLayout frameLayout;
    private ImageView serach;
    ArrayList<String> list = new ArrayList<>();
    private int selectedPosition;
    private List<FlBean.DataBean> data;
    private ListAdapter aa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fenlei, container, false);

        listView = view.findViewById(R.id.list_item);
        frameLayout = view.findViewById(R.id.framelayout);
        serach = view.findViewById(R.id.serach);


        //点击搜索框跳转
        serach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SerachActivity.class);
                startActivity(intent);

            }
        });


        //请求左边listview数据

        Map<String,String> map = new HashMap<>();

        RetrofitManager.get("product/getCatagory", map, new BaseObserver<FlBean>() {
            @Override
            public void success(FlBean flBean) {
                data = flBean.getData();

                aa = new ListAdapter(data,getActivity());
                listView.setAdapter(aa);

            }
            @Override
            public void failure(int code) {

            }
        });

        //左侧listview点击变色
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int cid = data.get(i).getCid();

                Fenleifragment fenleifragment = new Fenleifragment();

                getChildFragmentManager().beginTransaction().replace(R.id.framelayout,fenleifragment).commit();

                //传值fenleifragment
                Bundle bundle = new Bundle();
                bundle.putInt("cid",cid);
                fenleifragment.setArguments(bundle);

            }
        });


        return view;
    }


     class ListAdapter extends BaseAdapter {

         List<FlBean.DataBean> data;
         Context context;
         private int selectedPosition = 0;// 选中的位置


         public ListAdapter(List<FlBean.DataBean> data, Context context) {
             this.data = data;
             this.context = context;
         }

         @Override
         public int getCount() {
             return data.size();
         }

         @Override
         public Object getItem(int i) {
             return data.get(i);
         }

         @Override
         public long getItemId(int i) {
             return i;
         }

         @Override
         public View getView(final int i, View view, ViewGroup viewGroup) {

             View view1 = View.inflate(context, R.layout.textview, null);
             final TextView text = view1.findViewById(R.id.textview);
             text.setText(data.get(i).getName());






             return view1;
         }

         }



}
