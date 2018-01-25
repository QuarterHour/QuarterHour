package com.example.quarterhour.model;


import android.util.Log;

import com.example.quarterhour.model.bean.LunBoBean;
import com.example.quarterhour.present.MyPresentCallback;
import com.example.quarterhour.utils.InternetUtil;
import com.example.quarterhour.view.MyViewCallback;

import java.util.Map;

public class Mymodel<T>{

    public void getTuiJian( Class<LunBoBean> lunBoBeanClass, final MyPresentCallback myPresentCallback) {
        InternetUtil.getInstance().getData(lunBoBeanClass,new MyModelCallback() {
            @Override
            public void getUtilData(Object o) {
                myPresentCallback.getModeData(o);

            }
        });


    }
}
