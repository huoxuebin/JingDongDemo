package com.example.jingdongdeom.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongdeom.Activity.Dingdan;
import com.example.jingdongdeom.Activity.LoginActivity;
import com.example.jingdongdeom.Activity.NewsActivity;
import com.example.jingdongdeom.Activity.XiangQingactivity;
import com.example.jingdongdeom.Adapter.TuijianAdapter;
import com.example.jingdongdeom.Bean.SyBean;
import com.example.jingdongdeom.R;
import com.example.jingdongdeom.jiekou.OnItemClickListener;
import com.example.jingdongdeom.utils.BaseObserver;
import com.example.jingdongdeom.utils.RetrofitManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class Fragment_my extends Fragment {

    private ImageView touxiang;
    private TextView dz;
    private SharedPreferences test;
    private RecyclerView recyclerView;
    private LinearLayout linearLayout;
    private ImageView imageView;

    //图片
    private Bitmap mBitmap;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    protected static Uri tempUri;
    private static final int CROP_SMALL_PICTURE = 2;
    private FileOutputStream out;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        //获取控件
        recyclerView = view.findViewById(R.id.myry);
        //getSharedPreferences储存数据
        test = getActivity().getSharedPreferences("test", Context.MODE_PRIVATE);

        touxiang = view.findViewById(R.id.touxiang);
        dz = view.findViewById(R.id.dz);
        linearLayout = view.findViewById(R.id.liding);
        imageView = view.findViewById(R.id.chuanimg);

        //上传头像
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChoosePicDialog();
            }
        });


        //我的订单点击事件
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Dingdan.class);
                startActivity(intent);
            }
        });



        //登录注册设置点击事件
        dz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = dz.getText().toString();

               if(s.equals("登录/注册")) {

                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
              }
               else {
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                     String string = dz.getText().toString();
                    intent.putExtra("name",string);

                    startActivity(intent);


               }
            }
        });

        //推荐
        Map<String,String> map = new HashMap<>();
        RetrofitManager.post("ad/getAd", map, new BaseObserver<SyBean>() {
            @Override
            public void success(SyBean syBean) {
                final SyBean.TuijianBean tuijian = syBean.getTuijian();

                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,OrientationHelper.VERTICAL,false));

                TuijianAdapter tuijianAdapter = new TuijianAdapter(tuijian,getActivity());
                recyclerView.setAdapter(tuijianAdapter);
                //
                tuijianAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent = new Intent(getActivity(), XiangQingactivity.class);
                        int pid = tuijian.getList().get(position).getPid();
                        intent.putExtra("pid",String.valueOf(pid));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void failure(int code) {

            }
        });

        return view;
    }


    //给登录复制
    @Override
    public void onResume() {
        super.onResume();
        String name = test.getString("name1", null);
        if (name!=null){
           // Toast.makeText(getActivity(),name,Toast.LENGTH_LONG).show();
            dz.setText(name);
        }
        else{
            dz.setText("登录/注册");
        }
    }

    //上传图片
    protected void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("添加图片");
        String[] items = { "选择本地照片", "拍照" };
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        //用startActivityForResult方法，待会儿重写onActivityResult()方法，拿到图片做裁剪操作
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "temp_image.jpg"));
                        // 将拍照所得的相片保存到SD卡根目录
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE:
                    cutImage(tempUri); // 对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    cutImage(data.getData()); // 对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    protected void cutImage(Uri uri) {
        if (uri == null) {
            Log.i("alanjet", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        //com.android.camera.action.CROP这个action是用来裁剪图片用的
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            mBitmap = extras.getParcelable("data");
            //这里图片是方形的，可以用一个工具类处理成圆形（很多头像都是圆形，这种工具类网上很多不再详述）
            imageView.setImageBitmap(mBitmap);//显示图片

            //在这个地方可以写上上传该图片到服务器的代码，后期将单独写一篇这方面的博客，敬请期待...
        }


    }
}
