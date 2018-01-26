package com.example.quarterhour.guo.model.activity;

import com.example.quarterhour.R;
import com.example.quarterhour.base.BaseActivity;
import com.example.quarterhour.guo.model.bean.EventMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by 111 on 2018/1/26.
 */

public class BoFanActivity extends BaseActivity {
    @Override
    public int setContentViewId() {
        return R.layout.activitybofang;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        EventBus.getDefault().register( this );

    }


    @Subscribe(sticky = true)
    public void Event(EventMessage msg) {
        String imgUrl = msg.getImgUrl();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister( this );
        EventBus.getDefault().removeStickyEvent( EventMessage.class );
    }
}
