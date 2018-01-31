package com.example.quarterhour.guo.model.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.quarterhour.R;
import com.example.quarterhour.guo.model.bean.EventMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 111 on 2018/1/26.
 */

public class BoFanActivity extends AppCompatActivity {

            private String videoUrl;
            @Override
            protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate( savedInstanceState );
                setContentView( R.layout.activitybofang );
                EventBus.getDefault().register( this );
                JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
                jzVideoPlayerStandard.setUp(videoUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "未成年人禁止观看" );
                String path="http://i2.hdslb.com/bfs/archive/f925a4fa281ce3c70d5d5ca5c690b0d36895dea8.jpg";
                Glide.with(this).load(path).into(jzVideoPlayerStandard.thumbImageView);
            }


            @Override
            public void onBackPressed() {
                if (JZVideoPlayer.backPress()) {
                    return;
                }
                super.onBackPressed();
            }
            @Override
            protected void onPause() {
                super.onPause();
                JZVideoPlayer.releaseAllVideos();
    }


    @Subscribe(sticky = true)
    public void Event(EventMessage msg) {
        String imgUrl = msg.getImgUrl();
        videoUrl = msg.getVideoUrl();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister( this );
        EventBus.getDefault().removeStickyEvent( EventMessage.class );
    }
}
