package com.example.quarterhour.appliction;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.example.quarterhour.utils.IInterface;
import com.example.quarterhour.utils.OkhttpUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 0.0 on 2018/1/22.
 */

public class Myapplication extends Application{
    public static IInterface iInterface;

    public static boolean isnight=false;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        //默认白天模式
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(OkhttpUtils.getInstance())
                .build();
        iInterface = retrofit.create(IInterface.class);

        UMShareAPI.get(this);//初始化sdk
        //开启debug模式，方便定位错误，具体错误检查方式可以查看http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
        Config.DEBUG = true;

    }
    {
        //微信
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //QQ
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //新浪微博(第三个参数为回调地址)
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com/sina2/callback");
        //QQ
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

}
