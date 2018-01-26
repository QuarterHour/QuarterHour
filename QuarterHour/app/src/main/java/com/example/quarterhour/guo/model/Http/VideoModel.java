package com.example.quarterhour.guo.model.Http;

import android.util.Log;

import com.example.quarterhour.guo.api.Api;
import com.example.quarterhour.guo.api.ApiServer;
import com.example.quarterhour.guo.model.bean.VideoInfo;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 111 on 2018/1/25.
 */

public class VideoModel {

    public Flowable<VideoInfo> geData(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor( new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl( Api.url).addConverterFactory( GsonConverterFactory.create())
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create()).client(okHttpClient).build();
        //通过动态代理获得网络接口代理对象
        ApiServer apiService = retrofit.create(ApiServer.class);
        //uid=71&type=1&appVersion=101&source=android&page=1
        Flowable<VideoInfo> flowable = apiService.getVideo(71,1,101,"android",1);
        return flowable;
    }
}
