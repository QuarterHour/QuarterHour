package com.example.quarterhour.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quarterhour.R;
import com.example.quarterhour.base.BaseFragment;
import com.example.quarterhour.guo.fragment.GuanFragment;
import com.example.quarterhour.guo.fragment.ReFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 0.0 on 2018/1/23.
 */

public class Fragment_shipin extends BaseFragment {
    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.vp)
    ViewPager vp;
    private String[] mTitle=new String[]{"关注","热门"};
    private List<Fragment> fragments=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shipin;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView( inflater, container, savedInstanceState );
        ButterKnife.bind( this, rootView );
        initTab();
        fragments.add(new GuanFragment());
        fragments.add(new ReFragment());
        return rootView;
    }

    //vp与Tab连接

    private void initTab() {

        for (String str : mTitle) {
            tab.addTab(tab.newTab().setText(str));
        }
        //绑定Viewpager适配器
        // tab.setTabsFromPagerAdapter(new MyAdapter(getChildFragmentManager()));//给Tabs设置适配器
        vp.setAdapter(new MyAdapter(getChildFragmentManager()));
        //vp.setAdapter(new MyAdapter(getChildFragmentManager()));
        //vp.setAdapter(new MyAdapter(getFragmentManager()));
        //tab和vp关联
        tab.setupWithViewPager(vp);

    }




    //fragment
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return mTitle.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind( this );
    }
}
