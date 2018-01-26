package com.example.quarterhour.guo.perserter;

import android.util.Log;

import com.example.quarterhour.guo.model.Http.VideoModel;
import com.example.quarterhour.guo.model.bean.VideoInfo;
import com.example.quarterhour.guo.view.VideoView;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 111 on 2018/1/25.
 */

public class VideoPerserter {
    private VideoView videoView;
    private VideoModel videoModel;
    //订阅管理器管理订阅者
    CompositeDisposable compositeDisposable = null;

    public VideoPerserter() {

        videoModel=new VideoModel();
    }


    public void attachView(VideoView videoView) {
        this.videoView=videoView;

    }
    //p关联m
    public void relevance() {
        compositeDisposable = new CompositeDisposable();
        Flowable<VideoInfo> flowable = videoModel.geData();
        DisposableSubscriber<VideoInfo> disposableSubscriber = flowable.subscribeOn( Schedulers.io())
                .observeOn( AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<VideoInfo>() {
                    @Override
                    public void onNext(VideoInfo videoInfos) {
                        Log.i("ssss", videoInfos.getData().get( 0 ).getCreateTime());
                        videoView.onSuccess(videoInfos);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }
    public void dettachView() {
        videoView = null;
    }
}
