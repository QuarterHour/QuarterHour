package com.example.quarterhour.duan.presenter;

import com.example.quarterhour.duan.bean.DuanBean;
import com.example.quarterhour.duan.model.DModel;
import com.example.quarterhour.duan.model.Model;
import com.example.quarterhour.duan.view.DView;

/**
 * Created by Administrator on 2018/1/24.
 */

public class Duanpresenter {
    private Model model;
    private DView iView;

    public Duanpresenter(DView iView) {
        this.iView=iView;
        this.model = new Model();

    }

    public void getliedata() {
         model.duandata(new DModel() {
             @Override
             public void success(DuanBean duanBean) {
                 iView.success(duanBean);
             }
         });
    }
}
