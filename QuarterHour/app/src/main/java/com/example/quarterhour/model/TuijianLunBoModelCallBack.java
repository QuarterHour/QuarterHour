package com.example.quarterhour.model;

import com.example.quarterhour.model.bean.LunBoBean;

/**
 * Created by acer on 2018/1/24.
 */

public interface TuijianLunBoModelCallBack {
    public void success(LunBoBean lunBoBean);
    public void failure(Exception e);
}
