package com.example.quarterhour.utils;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 0.0 on 2018/1/22.
 */


    public interface IInterface<T>{

        @GET("/nba")
        Observable<T> get(@QueryMap Map<String,String> map);
    }

