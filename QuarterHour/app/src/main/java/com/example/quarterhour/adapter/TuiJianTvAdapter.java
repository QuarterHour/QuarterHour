package com.example.quarterhour.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quarterhour.R;
import com.example.quarterhour.model.bean.TuiJianTvBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by acer on 2018/1/26.
 */

public class TuiJianTvAdapter extends RecyclerView.Adapter<TuiJianTvAdapter.TuiJianTvViewHolder> {
    Context context;
    List<TuiJianTvBean.DataBean> data1;
    private String icon;

    public TuiJianTvAdapter(Context context, List<TuiJianTvBean.DataBean> data1) {
        this.context = context;
        this.data1 = data1;
    }

    @Override
    public TuiJianTvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tuijiantvitem, parent, false);
        return new TuiJianTvViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TuiJianTvViewHolder holder, int position) {

        String createTime = data1.get(position).getCreateTime();
        String[] ts = createTime.split("T");
        String nickname = data1.get(position).getUser().getNickname();

        String videoUrl = data1.get(position).getVideoUrl();
        icon = data1.get(position).getUser().getIcon();
        String workDesc = data1.get(position).getWorkDesc();
        if (nickname == null) {

        } else {
            holder.tuijiantvNickname.setText(nickname);
        }
        if (icon == null) {


        } else {
            holder.tuijiantvTouxiang.setImageURI(icon);
        }
        holder.tuijiantvTime.setText(ts[0] + "     " + ts[1]);
        if (workDesc == null) {

        } else {
            holder.tuijiantvDes.setText(workDesc);
        }
        Html.ImageGetter imgGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable drawable = null;
                drawable = Drawable.createFromPath(source); // Or fetch it from the URL
// Important
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable
                        .getIntrinsicHeight());
                return drawable;
            }
        };
        String html = "<font color='blue'>开着拖拉机唱情歌：</font>陈独秀";
        String html2 = "<font color='blue'>骑猪上高速：</font>李大钊";

        holder.firstPinglun.setText(Html.fromHtml(html, imgGetter, null));
        holder.secondPinglun.setText(Html.fromHtml(html2, imgGetter, null));
        holder.videoplayer.setUp(videoUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "未成年人禁止观看");
        String path="http://i2.hdslb.com/bfs/archive/f925a4fa281ce3c70d5d5ca5c690b0d36895dea8.jpg";
        Glide.with(context).load(path).into(holder.videoplayer.thumbImageView);
        holder.videoplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
    }

    @Override
    public int getItemCount() {

        return data1 == null ? 0 : data1.size();
    }

    static class TuiJianTvViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tuijiantv_touxiang)
        SimpleDraweeView tuijiantvTouxiang;
        @Bind(R.id.tuijiantv_nickname)
        TextView tuijiantvNickname;
        @Bind(R.id.tuijiantv_time)
        TextView tuijiantvTime;
        @Bind(R.id.button)
        Button button;
        @Bind(R.id.tuijiantv_des)
        TextView tuijiantvDes;
        @Bind(R.id.videoplayer)
        JZVideoPlayerStandard videoplayer;
        @Bind(R.id.first_pinglun)
        TextView firstPinglun;
        @Bind(R.id.second_pinglun)
        TextView secondPinglun;

        TuiJianTvViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
