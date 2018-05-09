package com.example.jingdongdeom.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdongdeom.R;

public class NewsActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //获取控件
        imageView = findViewById(R.id.touxiang);



        //接收保存的值
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Log.i("ss","bb"+name);
        textView = findViewById(R.id.news);
        textView.setText(name);

        //给头像设置点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    //退出登录
    public void tuichu(View view) {

        //获取当前状态
        SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
        String name1 = test.getString("name1", null);
        //给name赋值为空
        name1=null;
        SharedPreferences.Editor edit = test.edit();
        //传递到我的页面
        edit.putString("name1",name1);
        //退出完成
        edit.commit();
        finish();


    }
}
