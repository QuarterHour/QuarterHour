package com.example.quarterhour.present;


import android.support.v4.app.FragmentActivity;

import com.example.quarterhour.model.Mymodel;
import com.example.quarterhour.model.bean.LunBoBean;
import com.example.quarterhour.view.fragment.FragmentTuijian_remen;

import java.util.Map;

public class Mypresent<T>{
    FragmentTuijian_remen activity;

    public Mypresent(FragmentTuijian_remen activity) {
        this.activity=activity;
    }

    public void getTuiJian(Class<LunBoBean> lunBoBeanClass) {
        Mymodel<T> mymodel= new Mymodel<>();
        mymodel.getTuiJian(lunBoBeanClass, new MyPresentCallback() {
            @Override
            public void getModeData(Object o) {

                activity.getViewDate(o);
            }
        });

    }
}
