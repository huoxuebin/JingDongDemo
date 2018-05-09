package com.example.jingdongdeom.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.jingdongdeom.Fragment.DingDanFragment;
import com.example.jingdongdeom.R;

import java.util.ArrayList;
import java.util.List;

public class Dingdan extends AppCompatActivity implements View.OnClickListener {


    private PopupWindow popupMenu;
    private ImageView imageView;
    private List<String> list;
    private Button daifukuan;
    private Button yiwancheng;
    private Button yiquxiao;
    private FrameLayout frameLayout;
    private DingDanFragment fragment;
    private String[] strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);
        findView();


                list = new ArrayList<>();

                list.add("待付款");
                list.add("已完成");
                list.add("已取消");
                strings = new String[]{"待付款","已完成","已取消"};
                //图片的点击事件
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPopWindow();
                    }
                });

                fragment = new DingDanFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();

            }

            private void findView() {
                imageView = findViewById(R.id.image);
                daifukuan = findViewById(R.id.btn_daifukuan);
                yiwancheng = findViewById(R.id.btn_yiwancheng);
                yiquxiao = findViewById(R.id.btn_yiquxiao);
                frameLayout = findViewById(R.id.frameLayout);
            }

            //popwindow显示
            private void showPopWindow() {
                //设置contentView
                View contentView = LayoutInflater.from(Dingdan.this).inflate(R.layout.popwindow_item, null);
                popupMenu = new PopupWindow(contentView);
                popupMenu.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupMenu.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                //设置各个控件的点击响应
                TextView tv1 = contentView.findViewById(R.id.pop_dai);
                TextView tv2 = contentView.findViewById(R.id.pop_wancheng);
                TextView tv3 = contentView.findViewById(R.id.pop_quxiao);
                tv1.setOnClickListener(this);
                tv2.setOnClickListener(this);
                tv3.setOnClickListener(this);

                popupMenu.showAsDropDown(imageView);

            }


    /**
     * 点击popwindow里的内容
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_daifukuan:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();

                break;
            case R.id.btn_yiwancheng:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();

                break;
            case R.id.btn_yiquxiao:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();

                break;


            case R.id.pop_dai:
                popupMenu.dismiss();
                break;
            case R.id.pop_wancheng:
                popupMenu.dismiss();
                break;
            case R.id.pop_quxiao:
                popupMenu.dismiss();
                break;
            default:
                break;
        }
    }
}