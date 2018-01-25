package com.example.quarterhour.utils;

import android.util.Log;

import com.example.quarterhour.appliction.Myapplication;
import com.example.quarterhour.model.MyModelCallback;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void getData(final Class<T> lunBoBeanClass, final MyModelCallback myModelCallback){
//        Observable<String> observable = Myapplication.iInterface.get();
//        observable.subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i("-----",s+"123");
//            }
//        });

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> e) throws Exception {
                Call<String> stringCall = Myapplication.iInterface.get();
                stringCall.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String s = response.body().toString();
                        e.onNext(s);
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                 Log.i("----12313",s);
                Gson gson = new Gson();
                T t = gson.fromJson(s, lunBoBeanClass);
                myModelCallback.getUtilData(t);
            }
        });


    }

}
