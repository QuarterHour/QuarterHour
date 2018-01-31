package com.example.quarterhour;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by 0.0 on 2018/1/30.
 */

public class CustomerView extends RelativeLayout{

    private ImageView image_show;
    private ImageView image_jian;
    private ImageView image_report;
    private ImageView image_copy;
    private ImageView image_pingbi;

    public CustomerView(Context context) {
        this(context,null);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.customer,this, false);
        image_show = view.findViewById(R.id.image_show);
        image_jian = view.findViewById(R.id.image_jian);
        image_report = view.findViewById(R.id.image_report);
        image_copy = view.findViewById(R.id.image_copy);
        image_pingbi = view.findViewById(R.id.image_pingbi);

        image_show.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                image_jian.setVisibility(View.VISIBLE);
                image_show.setVisibility(View.GONE);
                 showMenu();
            }
        });

        image_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                image_jian.setVisibility(View.GONE);
                image_show.setVisibility(View.VISIBLE);
               hideMenu();
            }
        });

        addView(view);

    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void showMenu(){

        ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(image_report,
                "translationX", 0, -100 * 3);
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy,
                "translationX", 0, -100 * 2);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_pingbi,
                "translationX", 0, -100 * 1);
        ObjectAnimator animator = ObjectAnimator.ofFloat(image_jian,"rotation",0,135,0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(image_copy,"rotation",0,180,0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(image_pingbi,"rotation",0,180,0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(image_report,"rotation",0,180,0);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(800);
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.playTogether(animator,animator2,animator3,animator4,firstAnimator, secondAnimator, thirdAnimator);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);



            }
        });
        animatorSet.start();

    }

    public void hideMenu(){

        ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(image_report,
                "translationX", image_report.getTranslationX(),0);
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy,
                "translationX", image_copy.getTranslationX(),0);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_pingbi,
                "translationX", image_pingbi.getTranslationX(),0);
        ObjectAnimator animator = ObjectAnimator.ofFloat(image_show,"rotation",0,135,0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(image_copy,"rotation",0,180,0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(image_pingbi,"rotation",0,180,0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(image_report,"rotation",0,180,0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(800);
        animatorSet.setInterpolator(new OvershootInterpolator ());
        animatorSet.playTogether(animator,animator2,animator3,animator4,firstAnimator, secondAnimator, thirdAnimator);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);


            }
        });

        animatorSet.addListener(new AnimatorListenerAdapter() {
        });
        animatorSet.start();

    }


}
