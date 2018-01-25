package com.example.quarterhour.appliction;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 0.0 on 2018/1/22.
 */

public class Myapplication extends Application{

    public static boolean isnight=false;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


    }
}
