package com.example.jingdongdeom.Activity;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.jingdongdeom.Adapter.ZSAdapter;
import com.example.jingdongdeom.Adapter.ZSgroupAdapter;
import com.example.jingdongdeom.Bean.ZSBean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ZhanShiActivity extends AppCompatActivity {

    private String sname;
    private XRecyclerView xRecyclerView;
    boolean flag =false;
    private List<ZSBean.DataBean> data;
    private ZSgroupAdapter gv;
    private CheckBox checkBox;
    private ZSAdapter list;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhan_shi2);
                 xRecyclerView = findViewById(R.id.zsxry);
                checkBox = findViewById(R.id.ck);
                 back = findViewById(R.id.back);

                //点击图片返回
                 back.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         finish();
                     }
                 });
                Intent intent = getIntent();
                sname = intent.getStringExtra("name");
                Log.i("+++","**--"+ sname);
                //网络请求
                retrofit();

                //判断checkbok
                checkBox.setChecked(flag);
                if(checkBox.isChecked()){
                    Group();
                    gv = new ZSgroupAdapter(data, ZhanShiActivity.this);
                    xRecyclerView.setAdapter(gv);
                } else {
                    retrofit();
                    list = new ZSAdapter(data, ZhanShiActivity.this);
                    xRecyclerView.setAdapter(list);
                }
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (flag) {
                            retrofit();
                            checkBox.setChecked(false);
                            flag = checkBox.isChecked();
                        } else {
                            Group();
                            checkBox.setChecked(true);
                            flag = checkBox.isChecked();
                        }
                    }
                });


                //上拉刷新 下拉加载
                xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ZhanShiActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                                xRecyclerView.refreshComplete();
                            }
                        }, 2000);
                    }

                    @Override
                    public void onLoadMore() {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ZhanShiActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                                xRecyclerView.loadMoreComplete();

                            }
                        }, 2000);
                    }
                });
            }

            public void retrofit() {
                //请求数据
                Map<String, String> map = new HashMap<>();
                map.put("keywords", sname);
                map.put("source", "android");

                RetrofitManager.post("product/searchProducts", map, new BaseObserver<ZSBean>() {
                    @Override
                    public void success(final ZSBean zsBean) {
                        data = zsBean.getData();
                        xRecyclerView.setLayoutManager(new LinearLayoutManager(ZhanShiActivity.this, OrientationHelper.VERTICAL, false));
                        list = new ZSAdapter(data, ZhanShiActivity.this);
                        xRecyclerView.setAdapter(list);
                        list.setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {


                                Intent intent = new Intent(ZhanShiActivity.this, XiangQingactivity.class);
                                int pid = zsBean.getData().get(position).getPid();
                                intent.putExtra("pid", String.valueOf(pid));
                                startActivity(intent);
                            }
                        });
                    }
                    @Override
                    public void failure(int code) {

                    }
                });
            }
            public void Group() {
                //请求数据
                Map<String, String> map = new HashMap<>();
                map.put("keywords", sname);
                map.put("source", "android");

                RetrofitManager.post("product/searchProducts", map, new BaseObserver<ZSBean>() {
                    @Override
                    public void success(final ZSBean zsBean) {
                        data = zsBean.getData();
                        xRecyclerView.setLayoutManager(new GridLayoutManager(ZhanShiActivity.this, 2, OrientationHelper.VERTICAL, false));
                        gv = new ZSgroupAdapter(data, ZhanShiActivity.this);
                        xRecyclerView.setAdapter(gv);
                        gv.setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {


                                Intent intent = new Intent(ZhanShiActivity.this,XiangQingactivity.class);
                                int pid = zsBean.getData().get(position).getPid();
                                intent.putExtra("pid",String.valueOf(pid));
                                startActivity(intent);
                            }
                        });
                    }
                    @Override
                    public void failure(int code) {

                    }
                });
            }
        }
