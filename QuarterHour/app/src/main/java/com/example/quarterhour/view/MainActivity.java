package com.example.quarterhour.view;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.base.BaseActivity;
import com.example.quarterhour.view.fragment.Fragment_duanzi;
import com.example.quarterhour.view.fragment.Fragment_shipin;
import com.example.quarterhour.view.fragment.Fragment_tuijian;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private RadioButton radio_duanzi;
    private RadioButton radio_shipin;
    private RadioButton radio_tuijian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        radio_duanzi = findViewById(R.id.radio_duanzi);
        radio_shipin = findViewById(R.id.radio_shipin);
        radio_tuijian = findViewById(R.id.radio_tuijian);
    }

    @Override
    public void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_tuijian()).commit();

        radio_duanzi.setOnClickListener(this);
        radio_shipin.setOnClickListener(this);
        radio_tuijian.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio_duanzi :
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_duanzi()).commit();
                Log.i("--------","哈哈");
                break;
            case R.id.radio_shipin :
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_shipin()).commit();
                Log.i("--------","哈哈2");
                break;
            case R.id.radio_tuijian :
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_tuijian()).commit();
                Log.i("--------","哈哈3");
                break;

        }
    }
}
