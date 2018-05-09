package com.example.jingdongdeom.utils;

import android.content.SharedPreferences;
import android.view.View;

/**
 * Created by huoxuebin on 2018/4/26.
 */

public class CommonUtils {


    private static SharedPreferences sharedPreferences;

    /**
     * DashApplication.getAppContext()可以使用,但是会使用系统默认的主题样式，如果你自定义了某些样式可能不会被使用
     * @param layoutId
     * @return
     */
    public static View inflate(int layoutId) {
        View view = View.inflate(MyApplicaion.getAppContext(), layoutId, null);
        return view;
    }

    /**
     * 自己写的运行在主线程的方法
     * 如果是主线程,执行任务,否则使用handler发送到主线程中去执行
     *
     *
     * @param runable
     */
    public static void runOnUIThread(Runnable runable) {
        //先判断当前属于子线程还是主线程
        if (android.os.Process.myTid() == MyApplicaion.getMainThreadId()) {
            runable.run();
        } else {
            //子线程
            MyApplicaion.getAppHanler().post(runable);
        }
    }
}