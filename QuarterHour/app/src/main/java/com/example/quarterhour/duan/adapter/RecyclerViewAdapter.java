package com.example.quarterhour.duan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quarterhour.R;
import com.example.quarterhour.duan.bean.DuanBean;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2018/1/24.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ReViewHolder> implements View.OnClickListener{
  private Context context;
    private List<DuanBean.DataBean> list;

    public RecyclerViewAdapter(Context context, List<DuanBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ReViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ReViewHolder reViewHolder = new ReViewHolder(LayoutInflater.from(context).inflate(R.layout.session_item_layout,parent,false));
        return reViewHolder;
    }

    @Override
    public void onBindViewHolder(ReViewHolder holder, int position) {
        holder.textContent.setText(list.get(position).getContent());
        holder.textTime.setText(list.get(position).getCreateTime());
        String nickname = ""+list.get(position).getUser().getNickname();
        if (nickname.equals("null")){
            holder.textTitle.setText("lianxiqingdashsabi");
        }else{
        holder.textTitle.setText(""+list.get(position).getUser().getNickname());
//            holder.textTitle.setText(list.get(position).getUser().getNickname() + "");
        }




        Glide.with(context).load(R.mipmap.user_icon).bitmapTransform(new CropCircleTransformation(context)).into(holder.igView);
        holder.imageView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }

    public static class ReViewHolder extends RecyclerView.ViewHolder{
        TextView textContent;
        TextView textTime;
        TextView textTitle;
        ImageView imageView;
        ImageView igView;
        public ReViewHolder(View itemView) {
            super(itemView);
            textContent = itemView.findViewById(R.id.tv_content);
            textTime  =itemView.findViewById(R.id.tv_time);
            textTitle = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_add);
            igView = itemView.findViewById(R.id.iv_session);
        }
    }
}

