package com.example.quarterhour.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.ZuoPinActivity;
import com.example.quarterhour.adapter.MyCehuaAdapter;
import com.example.quarterhour.appliction.Myapplication;
import com.example.quarterhour.base.BaseActivity;
import com.example.quarterhour.view.fragment.Fragment_duanzi;
import com.example.quarterhour.view.fragment.Fragment_shipin;
import com.example.quarterhour.view.fragment.Fragment_tuijian;
import com.facebook.drawee.view.SimpleDraweeView;
import com.suke.widget.SwitchButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton radio_duanzi;
    private RadioButton radio_shipin;
    private RadioButton radio_tuijian;
    private SimpleDraweeView simple;
    private RelativeLayout linear;
    private DrawerLayout drawerLayout;
    private RelativeLayout relativeLayout;
    private boolean isDrawer=false;
    private SimpleDraweeView cebian;
    private ListView listView;
    private SwitchButton switchButton;
    private ImageView imageView_heiye;
    private LinearLayout linearLayout;
    private LinearLayout cehua_wodezuopin;
    private LinearLayout cehua_shezhi;
    public static TextView textView;


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
        simple = findViewById(R.id.simple_icon);
        linear = findViewById(R.id.linear);
        drawerLayout = findViewById(R.id.draw_layout);
        relativeLayout = findViewById(R.id.relative);
        cebian = findViewById(R.id.simple_icon);
        listView = findViewById(R.id.list_view);
        switchButton = findViewById(R.id.switch_button);
        imageView_heiye = findViewById(R.id.image_heiye);
         cehua_shezhi=findViewById(R.id.cehua_shezhi);
        cehua_wodezuopin=findViewById(R.id.cehua_wodezuopin);
        textView=findViewById(R.id.in_title);
    }

    @Override
    public void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_tuijian()).commit();
        radio_duanzi.setOnClickListener(this);
        radio_shipin.setOnClickListener(this);
        radio_tuijian.setOnClickListener(this);
        simple.setImageURI(Uri.parse("https://www.zhaoapi.cn/images/quarter/ad1.png"));


        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(isDrawer){
                    return linear.dispatchTouchEvent(motionEvent);
                }else{
                    return false;
                }
            }
        });
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();

                relativeLayout.layout(linear.getRight(), 0, linear.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isDrawer=false;
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        //点击侧边栏显示
        cebian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(linear);
            }
        });

        //侧滑的条目
        List<String> mlist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mlist.add(i + "");
        }
        MyCehuaAdapter adapter = new MyCehuaAdapter(this, mlist);
        listView.setAdapter(adapter);

        //夜间模式
        switchButton.setChecked(Myapplication.isnight);


        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

                if (isChecked){
                    Myapplication.isnight=true;
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }else {
                    Myapplication.isnight=false;
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
        if (switchButton.isChecked() == true){
            imageView_heiye.setImageResource(R.mipmap.yueliang_true);
        }else {
            imageView_heiye.setImageResource(R.mipmap.yueliang_false);
        }


        //listview 条目点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //我的关注
                if (position == 1){
                    Intent intent = new Intent(MainActivity.this, GuanzhuActivity.class);
                    startActivity(intent);
                }

                //我的收藏
                if (position == 2){
                    Intent intent = new Intent(MainActivity.this, CollectActivity.class);
                    startActivity(intent);
                }

                //搜索好友
                if (position == 3){
                    Intent intent = new Intent(MainActivity.this, SouActivity.class);
                    startActivity(intent);
                }

                //消息通知
                if (position == 4){
                    Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                    startActivity(intent);
                }
            }
        });

        cehua_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShezhiActivity.class);
                startActivity(intent);
            }
        });

        cehua_wodezuopin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ZuoPinActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio_duanzi :
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_duanzi()).commit();
                textView.setText("段子");
                //收到
                break;
            case R.id.radio_shipin :
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_shipin()).commit();
                textView.setText("视频");
                break;
            case R.id.radio_tuijian :
                getSupportFragmentManager().beginTransaction().replace(R.id.rela, new Fragment_tuijian()).commit();
                textView.setText("推荐");
                break;

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.draw_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
