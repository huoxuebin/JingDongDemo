package com.example.jingdongdeom.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jingdongdeom.Bean.LoginBean;
import com.example.jingdongdeom.Fragment.Fragment_my;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText dname;
    private EditText password;
    private String code;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dname = findViewById(R.id.dname);
        password = findViewById(R.id.password);
        Intent intent1 = getIntent();
        String tell = intent1.getStringExtra("tel");
        dname.setText(tell);
        SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
        edit = test.edit();
    }


    //登录
    public void login(View view) {

        final String s = dname.getText().toString();
        String s1 = password.getText().toString();


        //网络请求
        final Map<String,String> map = new HashMap<>();
        map.put("mobile",s);
        map.put("password",s1);

        RetrofitManager.get("user/login", map, new BaseObserver<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                String name = dname.getText().toString();
                code = loginBean.getCode();
                String msg = loginBean.getMsg();

                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();

                //判断 请求成功传值
                if ("0".equals(code)){
                    edit.putString("name1",name);
                    edit.commit();
                    finish();
                }
            }

            @Override
            public void failure(int code) {

            }
        });


    }

    //注册
    public void zhuce(View view) {

        Intent intent = new Intent(LoginActivity.this,ZhuCeActivity.class);
        startActivity(intent);
        finish();
    }
}
