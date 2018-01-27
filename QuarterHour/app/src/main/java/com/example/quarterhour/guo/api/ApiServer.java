package com.example.quarterhour.guo.api;

import com.example.quarterhour.guo.model.bean.VideoInfo;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 111 on 2018/1/25.
 */

public interface ApiServer {
//https://www.zhaoapi.cn/quarter/getVideos?uid=71&type=1&appVersion=101&source=android&page=1
    @GET("getVideos")
    Flowable<VideoInfo> getVideo(@Query("uid") int uid, @Query("type") int type,@Query("appVersion") int appVersion,@Query( "source" ) String source,@Query( "page" ) int page);
}
