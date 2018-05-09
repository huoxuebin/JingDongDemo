package com.example.jingdongdeom.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongdeom.Bean.DingdanBean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

public class ChuangDingdanActivity extends AppCompatActivity {

    private TextView textView;
    private TextView xiadan;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuang_dingdan);

                textView = findViewById(R.id.dprice);
                xiadan = findViewById(R.id.xiadan);

                Intent intent = getIntent();
                price = intent.getStringExtra("price");

                textView.setText("合计:"+ price);


                //创建订单
                xiadan.setOnClickListener(new View.OnClickListener() {
                    @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>();
                map.put("uid","10190");
                map.put("price", price);
                map.put("source","android");
                RetrofitManager.post("product/createOrder", map, new BaseObserver<DingdanBean>() {
                    @Override
                    public void success(DingdanBean dingdanBean) {

                        String msg = dingdanBean.getMsg();
                        Toast.makeText(ChuangDingdanActivity.this, msg, Toast.LENGTH_SHORT).show();

                        Intent intent1 = new Intent(ChuangDingdanActivity.this,Dingdan.class);
                        startActivity(intent1);

                    }
                    @Override
                    public void failure(int code) {

                    }
                });

                 }
             });
    }
}
