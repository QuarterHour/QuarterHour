package com.example.quarterhour.guo.api;

/**
 * Created by 111 on 2018/1/25.
 */

public class Api {
    //https://www.zhaoapi.cn/quarter/getVideos?uid=71&type=1&appVersion=101&source=android&page=1
    public static boolean isDug=true;
    //本地
    public static final String onTesturl="https://www.zhaoapi.cn/quarter/";
    //线上
    public static final String onLinurl="https://www.zhaoapi.cn/quarter/";

    public static final String url=baseUrl();


    private static String baseUrl(){

        return isDug?onTesturl:onLinurl;
    }
}
