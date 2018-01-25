package com.example.quarterhour.duan.utils;

import com.example.quarterhour.duan.bean.DuanBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/1/24.
 */

public interface ApiServer {
    //https://www.zhaoapi.cn/quarter/getJokes?token=1&source=android&appVersion=101
    @GET("getJokes")
    Observable<DuanBean> duanzidata(@Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion);
}
