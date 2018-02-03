package com.example.quarterhour.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.base.ZhuCeBean;
import com.example.quarterhour.model.MyModelCallback;
import com.example.quarterhour.utils.InternetUtil;
import com.example.quarterhour.utils.Md5mi;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuceActivity extends AppCompatActivity {

    @Bind(R.id.login4_fanhui)
    ImageView login4Fanhui;
    @Bind(R.id.login4_you)
    TextView login4You;
    @Bind(R.id.login4_zh)
    EditText login4Zh;
    @Bind(R.id.login4_mm)
    EditText login4Mm;
    @Bind(R.id.linear_dl)
    LinearLayout linearDl;
    @Bind(R.id.login4_btn)
    Button login4Btn;
    @Bind(R.id.login4_ykdl)
    TextView login4Ykdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.login4_fanhui, R.id.login4_you, R.id.login4_btn, R.id.login4_ykdl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login4_fanhui:
                finish();
                break;

            case R.id.login4_you:
                finish();
                break;

            case R.id.login4_btn:
                Editable text_zh = login4Zh.getText();
                Editable text_mm = login4Mm.getText();

//                https://www.zhaoapi.cn/quarter/register
                HashMap<String, String> map = new HashMap<>();
                map.put("mobile",String.valueOf(text_zh));
                map.put("password",String.valueOf(text_mm));

                String s = Md5mi.md5(String.valueOf(text_mm));

                InternetUtil.getInstance().getData2("https://www.zhaoapi.cn/quarter/register",map,ZhuCeBean.class, new MyModelCallback<ZhuCeBean>() {
                    @Override
                    public void getUtilData(ZhuCeBean zhuCeBean) {
                        Toast.makeText(ZhuceActivity.this,zhuCeBean.getMsg(),Toast.LENGTH_SHORT).show();
                        if(zhuCeBean.getMsg().equals("注册成功")){
                            finish();
                        }
                    }
                });


                break;

            case R.id.login4_ykdl:
                Intent intent1 = new Intent(ZhuceActivity.this, MainActivity.class);
                startActivity(intent1);

                break;
        }
    }
}
