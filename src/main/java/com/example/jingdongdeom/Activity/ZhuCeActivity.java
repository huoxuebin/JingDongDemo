package com.example.jingdongdeom.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongdeom.Bean.ZhuCeBean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

public class ZhuCeActivity extends AppCompatActivity {


    private EditText zname;
    private EditText zpass;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        zname = findViewById(R.id.zname);
        zpass = findViewById(R.id.zpass);



    }

    //注册
    public void zc(View view) {

        Map<String,String> map = new HashMap<>();
        s = zname.getText().toString();

        String s1 = zpass.getText().toString();
        map.put("mobile", s);
        map.put("password", s1);
        RetrofitManager.post("user/reg", map, new BaseObserver<ZhuCeBean>() {
            @Override
            public void success(ZhuCeBean zhuCeBean) {

                //String code = zhuCeBean.getCode();


                String msg = zhuCeBean.getMsg();
                Toast.makeText(ZhuCeActivity.this,msg,Toast.LENGTH_LONG).show();
                if(msg.equals("注册成功")){

                    Intent intent = new Intent(ZhuCeActivity.this,LoginActivity.class);
                    intent.putExtra("tel",s);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void failure(int code) {

            }
        });


    }
}
