package com.example.jingdongdeom.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jingdongdeom.Adapter.FenleiwaicengAdapter;
import com.example.jingdongdeom.Bean.FenleiBean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/4/24.
 */

public class Fenleifragment extends Fragment {


    private RecyclerView recyclerView;
    private int cid;
    private List<FenleiBean.DataBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fenleifragment, container, false);

        recyclerView = view.findViewById(R.id.recy1);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cid = getArguments().getInt("cid");

        Map<String, String> params = new HashMap<>();
        params.put("cid", String.valueOf(cid));
        RetrofitManager.post("product/getProductCatagory", params, new BaseObserver<FenleiBean>() {


            @Override
            public void success(FenleiBean fenleiBean) {
                data = fenleiBean.getData();

            /*    FenleituijianBean fenleituijianBean = new Gson().fromJson(json, FenleituijianBean.class);
                data = fenleituijianBean.getData();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                FenleirecyAdapater adapater = new FenleirecyAdapater(data,getContext());
                recyclerView.setAdapter(adapater);*/

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                FenleiwaicengAdapter fenleiwaicengAdapter = new FenleiwaicengAdapter(data,getContext());
                recyclerView.setAdapter(fenleiwaicengAdapter);



            }

            @Override
            public void failure(int code) {

            }

        });
    }

}
