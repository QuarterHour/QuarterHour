package com.example.quarterhour.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Bind(R.id.login_fanhui)
    ImageView loginFanhui;
    @Bind(R.id.login_weixin)
    ImageView loginWeixin;
    @Bind(R.id.login_qq)
    ImageView loginQq;
    @Bind(R.id.login_qita)
    TextView loginQita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.login_fanhui, R.id.login_weixin, R.id.login_qq, R.id.login_qita})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_fanhui:
                finish();
                break;
            case R.id.login_weixin:
                //微信登录
                authorization(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.login_qq:
                //qq登录

                authorization(SHARE_MEDIA.QQ);
                break;
            case R.id.login_qita:
                //其他方式登录
                Intent intent = new Intent(LoginActivity.this, QitaLoginActivity.class);
                startActivity(intent);

                break;
        }
    }

    private void authorization(SHARE_MEDIA share_media) {
        UMShareAPI.get(this).getPlatformInfo(this, share_media, new UMAuthListener() {



            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Log.d(TAG, "onStart " + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.d(TAG, "onComplete " + "授权完成");

                //sdk是6.4.4的,但是获取值的时候用的是6.2以前的(access_token)才能获取到值,未知原因
                String name = map.get("name");
                String gender = map.get("gender");


                Toast.makeText(getApplicationContext(), "name=" + name + ",gender=" + gender, Toast.LENGTH_SHORT).show();

                //拿到信息去请求登录接口。。。
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Log.d(TAG, "onError " + "授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Log.d(TAG, "onCancel " + "授权取消");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
