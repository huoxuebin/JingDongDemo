package com.example.jingdongdeom.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jingdongdeom.R;

public class TiaozhuanActivity extends AppCompatActivity {

    private TextView textView;
    private int time = 4;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                time--;
                if(time>=1){

                    handler.sendEmptyMessageDelayed(0,1000);
                    textView.setText("剩余"+time+"秒");
                }else{
                    Intent intent = new Intent(TiaozhuanActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiaozhuan);

        textView = findViewById(R.id.time);

        handler.sendEmptyMessageDelayed(0,1000);

    }
}
