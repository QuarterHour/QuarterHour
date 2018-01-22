package com.example.quarterhour.appliction;

import android.app.Application;

import com.example.quarterhour.utils.IInterface;
import com.example.quarterhour.utils.OkhttpUtils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 0.0 on 2018/1/22.
 */

public class IAppliction extends Application{
    public static IInterface iInterface;
    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkhttpUtils.getInstance())
                .build();
        iInterface = retrofit.create(IInterface.class);

    }
}
