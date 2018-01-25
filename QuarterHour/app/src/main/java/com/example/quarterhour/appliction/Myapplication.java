package com.example.quarterhour.appliction;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.example.quarterhour.utils.IInterface;
import com.example.quarterhour.utils.OkhttpUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 0.0 on 2018/1/22.
 */

public class Myapplication extends Application{
    public static IInterface iInterface;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(OkhttpUtils.getInstance())
                .build();
        iInterface = retrofit.create(IInterface.class);
    }
}
