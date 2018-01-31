package com.example.quarterhour.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.quarterhour.R;
import com.example.quarterhour.adapter.TuiJianTvAdapter;
import com.example.quarterhour.model.bean.TuiJianTvBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private List<TuiJianTvBean.DataBean> data1;
    private RecyclerView tv_list;
    private ImageView fanhun;
    private SimpleDraweeView person_touxiang;
    private ImageView fenxiang;
    private LinearLayoutManager linearLayoutManager;
    private String weizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        data1 = (List<TuiJianTvBean.DataBean>) intent.getSerializableExtra("databean");
       String path= intent.getStringExtra("iamge");
        Log.i("TTT",path+"tttttttttttttttttttttttttpath");
        tv_list = findViewById(R.id.tv_list);
        fanhun = findViewById(R.id.fanhun);
        person_touxiang = findViewById(R.id.person_touxiang);
        fenxiang = findViewById(R.id.fenxiang);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        tv_list.setLayoutManager(linearLayoutManager);
        tv_list.setAdapter(new TuiJianTvAdapter(this,data1));
        Log.i("TTT","tTTTTTTTTTTTTTTT"+path);
        person_touxiang.setImageURI(path);
        fanhun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
