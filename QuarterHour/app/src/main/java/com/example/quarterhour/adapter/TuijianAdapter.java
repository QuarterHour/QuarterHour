package com.example.quarterhour.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quarterhour.R;
import com.example.quarterhour.model.bean.LunBoBean;
import com.example.quarterhour.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by acer on 2018/1/24.
 */

public class TuijianAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {
    LunBoBean lunBoBean;
    Context context;

    public TuijianAdapter(Context context, LunBoBean lunBoBean) {
        this.lunBoBean = lunBoBean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tuijianlunbo, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        List<LunBoBean.DataBean> data = lunBoBean.getData();
        ArrayList<String> imageList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            imageList.add(data.get(i).getIcon());
        }
        ((BannerViewHolder) holder).tuijianBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        ((BannerViewHolder) holder).tuijianBanner.setImageLoader(new GlideImageLoader());
        ((BannerViewHolder) holder).tuijianBanner.setImages(imageList);
        ((BannerViewHolder) holder).tuijianBanner.setBannerAnimation(Transformer.Default);
        ((BannerViewHolder) holder).tuijianBanner.isAutoPlay(true);
        ((BannerViewHolder) holder).tuijianBanner.setDelayTime(3000);
        ((BannerViewHolder) holder).tuijianBanner.setIndicatorGravity(BannerConfig.CENTER);
        ((BannerViewHolder) holder).tuijianBanner.start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tuijian_banner)
        Banner tuijianBanner;
        BannerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
