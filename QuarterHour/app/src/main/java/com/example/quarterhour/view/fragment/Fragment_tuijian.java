package com.example.quarterhour.view.fragment;

import android.content.pm.PermissionGroupInfo;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 0.0 on 2018/1/23.
 */

public class Fragment_tuijian extends BaseFragment{


    private TabLayout tabLayout;
    private TabItem tab_remen;
    private TabItem tab_guanzhu;
    private FragmentTransaction ft;
    private FragmentManager fm;
    private ViewPager pager_tuijian;
    private List<Fragment> tuijianList;
    private List<String> pageList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tuijian;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        pager_tuijian = view.findViewById(R.id.pager_tuijian);
        tabLayout = view.findViewById(R.id.toolbar_tab);
        tab_remen = view.findViewById(R.id.tab_remen);
        tab_guanzhu = view.findViewById(R.id.tab_guanzhu);
    }

    @Override
    protected void initData() {
        pageList = new ArrayList<String>();
        pageList.add("热门");
        pageList.add("关注");
        tuijianList = new ArrayList<>();
        tuijianList.add(new FragmentTuijian_guanzhu());
        tuijianList.add(new FragmentTuijian_remen());
        pager_tuijian.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return tuijianList.get(position);
            }

            @Override
            public int getCount() {
                return tuijianList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pageList.get(position);
            }
        });
//TabLayout加载viewpager
        tabLayout.setupWithViewPager(pager_tuijian);



    }
}
