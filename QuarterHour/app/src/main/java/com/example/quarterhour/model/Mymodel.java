package com.example.quarterhour.model;


import com.example.quarterhour.model.bean.LunBoBean;
import com.example.quarterhour.model.bean.TuiJianTvBean;
import com.example.quarterhour.present.MyPresentCallback;
import com.example.quarterhour.utils.InternetUtil;

import java.util.HashMap;
import java.util.Map;

public class Mymodel<T>{

    private Map<String, String> map;

    public void getTuiJian(Class<LunBoBean> lunBoBeanClass, final MyPresentCallback myPresentCallback) {
        InternetUtil.getInstance().getData(lunBoBeanClass,new MyModelCallback() {
            @Override
            public void getUtilData(Object o) {
                myPresentCallback.getModeData(o);

            }
        });

    }

    public void getTuiJianTv(Class<TuiJianTvBean> tuiJianTvBeanClass, final MyPresentCallback myPresentCallback) {
        map = new HashMap<>();
        map.put("uid", String.valueOf(71));
        map.put("type", String.valueOf(1));
        map.put("page", String.valueOf(1));
        map.put("source","android");
        map.put("appVersion", String.valueOf(101));
      InternetUtil.getInstance().getData2("quarter/getVideos", map, tuiJianTvBeanClass, new MyModelCallback() {
          @Override
          public void getUtilData(Object o) {
             myPresentCallback.getModeData(o);
          }
      });



    }
}
