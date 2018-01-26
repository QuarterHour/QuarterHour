package com.example.quarterhour.adapter;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quarterhour.MyItemDecoration;
import com.example.quarterhour.R;
import com.example.quarterhour.model.bean.LunBoBean;
import com.example.quarterhour.model.bean.TuiJianTvBean;
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

public class TuijianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LunBoBean lunBoBean;
    Context context;
    TuiJianTvBean tuiJianTvBean;
    public static final int LUNBO = 0;
    public static final int TV = 1;

    public TuijianAdapter(Context context, LunBoBean lunBoBean, TuiJianTvBean tuiJianTvBean) {
        this.lunBoBean = lunBoBean;
        this.context = context;
        this.tuiJianTvBean = tuiJianTvBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.tuijianlunbo, parent, false);
            return new BannerViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.tuijiantv, parent, false);
            return new TvViewHolder(view);
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;
        }
        return 1;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
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
                break;
            case 1:
                List<TuiJianTvBean.DataBean> data1 = tuiJianTvBean.getData();
        ((TvViewHolder) holder).recycleviewTv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        //安卓自带的分割线
        ((TvViewHolder) holder).recycleviewTv.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        ((TvViewHolder) holder).recycleviewTv.setAdapter(new TuiJianTvAdapter(context,data1));
        break;
    }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tuijian_banner)
        Banner tuijianBanner;

        BannerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }



    static class TvViewHolder  extends RecyclerView.ViewHolder{
        @Bind(R.id.recycleview_tv)
        RecyclerView recycleviewTv;

        TvViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
