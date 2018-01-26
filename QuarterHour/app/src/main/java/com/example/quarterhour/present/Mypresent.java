package com.example.quarterhour.present;


import com.example.quarterhour.model.Mymodel;
import com.example.quarterhour.model.bean.LunBoBean;
import com.example.quarterhour.model.bean.TuiJianTvBean;
import com.example.quarterhour.view.fragment.FragmentTuijian_guanzhu;
import com.example.quarterhour.view.fragment.FragmentTuijian_remen;

public class Mypresent<T>{
    FragmentTuijian_remen activity;
    private Mymodel<T> mymodel;

    public Mypresent(FragmentTuijian_remen activity) {
        this.activity=activity;
    }


    public void getTuiJian(Class<LunBoBean> lunBoBeanClass) {
        mymodel = new Mymodel<>();
        mymodel.getTuiJian(lunBoBeanClass, new MyPresentCallback() {
            @Override
            public void getModeData(Object o) {

                activity.getViewDate(o);
            }
        });

    }

    public void getTuiJianTv(Class<TuiJianTvBean> tuiJianTvBeanClass) {

          mymodel.getTuiJianTv(tuiJianTvBeanClass, new MyPresentCallback() {
              @Override
              public void getModeData(Object o) {

                  activity.getviewdata(o);

              }
          });

    }
}
