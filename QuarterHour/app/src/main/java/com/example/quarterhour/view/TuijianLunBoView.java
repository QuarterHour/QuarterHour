package com.example.quarterhour.view;

import com.example.quarterhour.model.bean.LunBoBean;

/**
 * Created by acer on 2018/1/24.
 */

public interface TuijianLunBoView {
    public void success(LunBoBean lunBoBean);
    public void failure(Exception e);
}
