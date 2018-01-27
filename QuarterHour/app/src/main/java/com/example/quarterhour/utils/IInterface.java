package com.example.quarterhour.utils;

import com.example.quarterhour.model.bean.LunBoBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 0.0 on 2018/1/22.
 */


    public interface IInterface{

        @GET("quarter/getAd")
         Call<String> get();
      @GET
      Call<String> getAll(@Url String url, @QueryMap Map<String,String> map);
}

