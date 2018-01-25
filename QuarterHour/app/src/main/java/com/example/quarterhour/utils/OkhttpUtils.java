package com.example.quarterhour.utils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by zm on 2017/11/20.
 */

public class OkhttpUtils {
    private static OkHttpClient client ;

    private OkhttpUtils(){

    }

    public static OkHttpClient getInstance(){

        if(client == null){
            client = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .connectTimeout(20,TimeUnit.SECONDS)
//                    .addInterceptor(new LoggingInterceptor())
                    .build();
        }
        return client ;

    }







}
