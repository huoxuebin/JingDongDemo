package com.example.jingdongdeom.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.example.jingdongdeom.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huoxuebin on 2018/4/20.
 */

public class Fragment_faxian extends Fragment {
    //所有的tab标签
    private List<String> myTabs=new ArrayList<>();
    private DrawerLayout mydrawer;
    private RelativeLayout menu;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faxian, container, false);

        TabLayout myTab= view.findViewById(R.id.mytab);
        ViewPager viewPager= view.findViewById(R.id.vp);

        myTabs.add("关注");
        myTabs.add("发现");
        myTabs.add("同城");
        myTabs.add("直播");
        //创建适配器
        MyVpAdapter myVpAdapter = new MyVpAdapter(getActivity().getSupportFragmentManager());

        viewPager.setAdapter(myVpAdapter);

        //将TabLayout与viewPager创建关联
        myTab.setupWithViewPager(viewPager);
        return view;
    }

    class MyVpAdapter extends FragmentPagerAdapter {
        public MyVpAdapter(FragmentManager fm) {
            super(fm);
        }

        //返回每个页面的title
        @Override
        public CharSequence getPageTitle(int position) {
            return myTabs.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            //position:页面的下标
            ContentFragment contentFragment=new ContentFragment();

            //传递参数
            Bundle bundle=new Bundle();//key:string vavle:object
            bundle.putString("title",myTabs.get(position));
            contentFragment.setArguments(bundle);

            return contentFragment;
        }

        //返回viewPager的加载的页面的数量
        @Override
        public int getCount() {
            return myTabs.size();
        }
    }
}