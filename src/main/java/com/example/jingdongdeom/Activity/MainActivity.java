package com.example.jingdongdeom.Activity;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jingdongdeom.Fragment.Fragment_faxian;
import com.example.jingdongdeom.Fragment.Fragment_fenlei;
import com.example.jingdongdeom.Fragment.Fragment_my;
import com.example.jingdongdeom.Fragment.Fragment_shop;
import com.example.jingdongdeom.Fragment.Fragment_shouye;
import com.example.jingdongdeom.R;
import com.hjm.bottomtabbar.BottomTabBar;


public class MainActivity extends AppCompatActivity  {


    private BottomTabBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = findViewById(R.id.ll_bottom_bar);



        bar.init(getSupportFragmentManager())
                .setImgSize(160,160)
                .setFontSize(0)
                .setTabPadding(0,0,0)
                .setChangeColor(Color.RED,Color.DKGRAY)

                .addTabItem("",R.drawable.ac1,R.drawable.ac0, Fragment_shouye.class)
                .addTabItem("",R.drawable.abx,R.drawable.abw, Fragment_fenlei.class)
                .addTabItem("",R.drawable.abz,R.drawable.aby, Fragment_faxian.class)
                .addTabItem("",R.drawable.abv,R.drawable.abu, Fragment_shop.class)
                .addTabItem("",R.drawable.ac3,R.drawable.ac2, Fragment_my.class)

                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });




    }
}