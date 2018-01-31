package com.example.quarterhour;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.quarterhour.view.fragment.Fragment_local;
import com.example.quarterhour.view.fragment.Fragment_shangchuan;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ZuoPinActivity extends AppCompatActivity {

    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.relative)
    RelativeLayout relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuo_pin);
        ButterKnife.bind(this);

        tablayout.addTab(tablayout.newTab().setText("本地作品"));
        tablayout.addTab(tablayout.newTab().setText("已上传"));

        getSupportFragmentManager().beginTransaction().replace(R.id.relative,new Fragment_local()).commit();

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String s = tab.getText().toString();
                if (s.equals("本地作品")){

                    getSupportFragmentManager().beginTransaction().replace(R.id.relative,new Fragment_local()).commit();


                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.relative,new Fragment_shangchuan()).commit();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
