package com.example.quarterhour.duan.model;

import com.example.quarterhour.duan.bean.DuanBean;
import com.example.quarterhour.duan.utils.Api;
import com.example.quarterhour.duan.utils.ApiServer;
import com.example.quarterhour.duan.utils.HttpInterceptor;
import com.example.quarterhour.duan.utils.RetrofitUnitl;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/1/24.
 */

public class Model {
    public void duandata(final DModel iModel){
        OkHttpClient ok = new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
        RetrofitUnitl.getInstance(Api.path,ok)
                .setCreate(ApiServer.class)
                .duanzidata("","android","101")
                .subscribeOn(Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DuanBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DuanBean duanBean) {
                          iModel.success(duanBean);
                    }
                });

    }
}
