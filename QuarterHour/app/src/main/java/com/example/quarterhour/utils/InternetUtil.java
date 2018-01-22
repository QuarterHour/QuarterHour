package com.example.quarterhour.utils;

import com.example.quarterhour.appliction.IAppliction;
import com.example.quarterhour.model.MyModelCallback;

import java.util.Map;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 0.0 on 2018/1/22.
 */

public class InternetUtil<T>{

    private static InternetUtil internetUtil = null ;

    private InternetUtil(){

    }

    public static InternetUtil getInstance(){

        if(internetUtil == null){
            internetUtil = new InternetUtil();

        }
        return internetUtil ;

    }

    private void getData(Map<String,String> map, final MyModelCallback myModelCallback){
        Observable<T> beanObservable = IAppliction.iInterface.get(map);
        beanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(T t) {
                        myModelCallback.getUtilData(t);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }

}
