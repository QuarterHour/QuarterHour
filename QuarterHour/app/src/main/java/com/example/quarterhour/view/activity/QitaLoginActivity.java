package com.example.quarterhour.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.base.LoginBean;
import com.example.quarterhour.base.ZhuCeBean;
import com.example.quarterhour.model.MyModelCallback;
import com.example.quarterhour.utils.InternetUtil;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QitaLoginActivity extends AppCompatActivity {

    @Bind(R.id.login2_fanhui)
    ImageView login2Fanhui;
    @Bind(R.id.login2_zc)
    TextView login2Zc;
    @Bind(R.id.login2_zh)
    EditText login2Zh;
    @Bind(R.id.login2_mm)
    EditText login2Mm;
    @Bind(R.id.linear_dl)
    LinearLayout linearDl;
    @Bind(R.id.login2_btn)
    Button login2Btn;
    @Bind(R.id.login2_wj)
    TextView login2Wj;
    @Bind(R.id.login2_ykdl)
    TextView login2Ykdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qita_login2);
        ButterKnife.bind(this);




    }

    @OnClick({R.id.login2_fanhui, R.id.login2_zc, R.id.login2_zh, R.id.login2_mm, R.id.linear_dl, R.id.login2_btn, R.id.login2_wj, R.id.login2_ykdl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login2_fanhui:
                finish();
                break;
            case R.id.login2_zc:
                Intent intent = new Intent(QitaLoginActivity.this, ZhuceActivity.class);
                startActivity(intent);
                break;
            case R.id.login2_zh:

                break;
            case R.id.login2_mm:

                break;
            case R.id.linear_dl:

                break;
            case R.id.login2_btn:
                Editable text_zh = login2Zh.getText();
                Editable text_mm = login2Mm.getText();

//                https://www.zhaoapi.cn/quarter/register
                HashMap<String, String> map = new HashMap<>();
                map.put("mobile",String.valueOf(text_zh));
                map.put("password",String.valueOf(text_mm));
                InternetUtil.getInstance().getData2("https://www.zhaoapi.cn/user/login",map,LoginBean.class, new MyModelCallback<LoginBean>() {

                    @Override
                    public void getUtilData(LoginBean loginBean) {
                        Toast.makeText(QitaLoginActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
                        if(loginBean.getMsg().equals("登录成功")){
                            Intent intent = new Intent(QitaLoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            Log.i("---100000000","11111111111111");
                        }
                    }


                });

                break;
            case R.id.login2_wj:
                Intent intent2 = new Intent(QitaLoginActivity.this, WjPasswordActivity.class);
                startActivity(intent2);
                break;
            case R.id.login2_ykdl:
                Intent intent1 = new Intent(QitaLoginActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
