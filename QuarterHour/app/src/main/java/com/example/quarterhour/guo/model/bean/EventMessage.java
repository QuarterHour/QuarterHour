package com.example.quarterhour.guo.model.bean;

/**
 * Created by 111 on 2018/1/26.
 */

public class EventMessage {
    String videoUrl;
    String imgUrl;

    public EventMessage(String videoUrl, String imgUrl) {
        this.videoUrl = videoUrl;
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
