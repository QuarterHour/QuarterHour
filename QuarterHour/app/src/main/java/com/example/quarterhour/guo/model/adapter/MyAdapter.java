package com.example.quarterhour.guo.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.quarterhour.R;
import com.example.quarterhour.guo.model.activity.BoFanActivity;
import com.example.quarterhour.guo.model.bean.EventMessage;
import com.example.quarterhour.guo.model.bean.VideoInfo;
import com.example.quarterhour.guo.utils.GlideCircleTransform;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 111 on 2018/1/25.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ImageView img;
    private List<Integer> mHeights;

    public MyAdapter(Context context) {
        this.context = context;
    }

    private List<VideoInfo.DataBean> list = new ArrayList<>();

    public void setListData(List<VideoInfo.DataBean> lists) {
        mHeights = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            //随机的获取一个范围为200-600直接的高度
            mHeights.add( (int) (300 + Math.random() * 400) );
        }


        list.addAll( lists );
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item, parent, false );
        return new IViewHolder( view );
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        //IViewHolder iViewHolder= (IViewHolder) holder;
        //((IViewHolder) holder).songName.setText( list.get( position ).getName() );
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = mHeights.get( position );
        holder.itemView.setLayoutParams( layoutParams );

        Glide.with( context ).load( list.get( position ).getCover() ).transform( new GlideCircleTransform( context ) ).into( img );

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky( new EventMessage( list.get( position ).getVideoUrl(), list.get( position ).getCover() ) );
                Intent intent = new Intent( context, BoFanActivity.class );
                context.startActivity( intent );
            }
        } );

        //Glide.with(context).load(list.get( position ).getBgPicture()).into(img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class IViewHolder extends RecyclerView.ViewHolder {
        public IViewHolder(View itemView) {
            super( itemView );
            img = itemView.findViewById( R.id.img );
        }
    }
}
