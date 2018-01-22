package com.example.quarterhour.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());

     initView();
     initData();

    }
    public abstract int setContentViewId();

    public abstract void initView();

    public abstract void initData();



}