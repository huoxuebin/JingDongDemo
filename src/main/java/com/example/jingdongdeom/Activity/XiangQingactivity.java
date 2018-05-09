package com.example.jingdongdeom.Activity;

import android.content.Context;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongdeom.Bean.AddShopBean;
import com.example.jingdongdeom.Bean.XQBean;
import com.example.jingdongdeom.Glide.GlideImage;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;

import com.example.jingdongdeom.utils.RetrofitManager;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XiangQingactivity extends AppCompatActivity {

    private TextView xqprice;
    private TextView title;
    private Banner imageView;
    private TextView yhprice;
    private String pid;
    private ImageView fanhui;
    private ArrayList<String> imageUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qingactivity);

        xqprice = findViewById(R.id.xqprice);
        title = findViewById(R.id.xqtitle);
        imageView = findViewById(R.id.viewpager);
        yhprice = findViewById(R.id.yhprice);
        fanhui = findViewById(R.id.back2);


        //点击图片跳转到放大页面
        imageView.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                Intent intent1 = new Intent(XiangQingactivity.this,FDactivity.class);
                intent1.putStringArrayListExtra("list", (ArrayList<String>) imageUrls);
                startActivity(intent1);
            }
        });

        //返回
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




        //接收pid
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");

        Log.i("++", "--" + pid);

        Map<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("source", "android");

        //请求数据
        RetrofitManager.post("product/getProductDetail", map, new BaseObserver<XQBean>() {
            @Override
            public void success(XQBean xqBean) {

                XQBean.DataBean data = xqBean.getData();
                String images = data.getImages();

                String[] split = images.split("\\|");


                imageUrls = new ArrayList<>();
                for (int i = 0;i<split.length;i++){
                    imageUrls.add(split[i]);
                }

                imageView.setImages(imageUrls);
                imageView.setDelayTime(1500);

                //设置banner样式...CIRCLE_INDICATOR_TITLE包含标题
                imageView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置图片加载器
                imageView.setImageLoader(new GlideImage());
                //设置自动轮播，默认为true
                imageView.isAutoPlay(false);
                //设置轮播时间
                imageView.setDelayTime(2500);
                //设置指示器位置（当banner模式中有指示器时）
                imageView.setIndicatorGravity(BannerConfig.CENTER);
                imageView.start();

                //赋值
                double price = data.getPrice();
                xqprice.setText("￥" + price);
                title.setText(data.getTitle());
                yhprice.setText("优惠价￥"+data.getBargainPrice());



            }

            @Override
            public void failure(int code) {

            }
        });

    }


    //添加购物车
    public void addshop(View view) {

        Map<String,String> map = new HashMap<>();
        map.put("uid","10190");
        map.put("pid",pid);
        map.put("source","android");

        RetrofitManager.post("product/addCart", map, new BaseObserver<AddShopBean>() {
            @Override
            public void success(AddShopBean addShopBean) {
                String msg = addShopBean.getMsg();
                Toast.makeText(XiangQingactivity.this,msg,Toast.LENGTH_LONG).show();

            }

            @Override
            public void failure(int code) {

            }
        });

    }
}
