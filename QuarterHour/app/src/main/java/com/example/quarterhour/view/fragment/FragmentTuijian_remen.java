package com.example.quarterhour.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.quarterhour.R;
import com.example.quarterhour.adapter.TuijianAdapter;
import com.example.quarterhour.base.BaseFragment;
import com.example.quarterhour.model.bean.LunBoBean;
import com.example.quarterhour.present.Mypresent;
import com.example.quarterhour.view.MyViewCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by acer on 2018/1/24.
 */

public class FragmentTuijian_remen extends BaseFragment implements MyViewCallback{

    private RecyclerView remen_recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private LunBoBean lunBoBean;
    private TuijianAdapter tuijianAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragmenttuijianremen;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        remen_recyclerview = view.findViewById(R.id.remen_recyclerview);

    }

    @Override
    protected void initData() {

        Mypresent mypresent = new Mypresent(this);
        mypresent.getTuiJian(LunBoBean.class);
        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        remen_recyclerview.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void getViewDate(Object o) {
        lunBoBean = (LunBoBean) o;
        tuijianAdapter = new TuijianAdapter(getActivity(),lunBoBean);
        remen_recyclerview.setAdapter(tuijianAdapter);

    }
}
