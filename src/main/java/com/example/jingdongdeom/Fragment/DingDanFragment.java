package com.example.jingdongdeom.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jingdongdeom.Adapter.DingDanAdapter;
import com.example.jingdongdeom.Bean.DDLBean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.CommonUtils;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/4/26.
 */

public class DingDanFragment extends Fragment {

    private View view;

    private ListView listView;
    private List<DDLBean.DataBean> data;
    private DingDanAdapter adapter;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {

                if (data.size() > 0) {
                    setAdapter();
                    add();

                } else {
                    Toast.makeText(getActivity(), "没有此类型的商品订单哦", Toast.LENGTH_SHORT).show();
                }

            } else if (msg.what == 2) {
                add();
                setAdapter();
            }
        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.dingdanfragment, null);
        listView = view.findViewById(R.id.listView);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //拿到传过来的值
        add();

    }
    private void add() {

        Map<String,String> map = new HashMap<>();
        map.put("uid","10190");
        map.put("source","android");
        RetrofitManager.post("product/getOrders", map, new BaseObserver<DDLBean>() {
            @Override
            public void success(final DDLBean ddlBean) {

                CommonUtils.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        data = ddlBean.getData();
                        data.addAll(ddlBean.getData());
                        handler.sendEmptyMessage(1);
                    }
                });
            }
            @Override
            public void failure(int code) {

            }
        });
    }

    //设置适配器
    private void setAdapter() {
        if (adapter == null) {
            adapter = new DingDanAdapter(getActivity(), data, handler);
            listView.setAdapter(adapter);

        } else {
            adapter.notifyDataSetChanged();
        }
    }

}