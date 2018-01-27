package com.example.quarterhour.guo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.quarterhour.R;
import com.example.quarterhour.guo.model.adapter.MyAdapter;
import com.example.quarterhour.guo.model.bean.VideoInfo;
import com.example.quarterhour.guo.perserter.VideoPerserter;
import com.example.quarterhour.guo.view.VideoView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 111 on 2018/1/23.
 */

public class GuanFragment extends Fragment implements VideoView {

    @Bind(R.id.rec)
    RecyclerView rec;
    private VideoPerserter videoPresenter;
    private MyAdapter adapter;
    private StaggeredGridLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_guan, container, false );
        ButterKnife.bind( this, view );
        initView();
        initData();
        return view;
    }

    private void initData() {
        videoPresenter=new VideoPerserter();
        videoPresenter.attachView( this );
        videoPresenter.relevance();
    }

    private void initView() {

        adapter = new MyAdapter( getActivity() );
        rec.setAdapter( adapter );
        //rec.setLayoutManager( new LinearLayoutManager( this  ) );
        manager = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        rec.setLayoutManager(manager);
    }

    @Override
    public void onSuccess(VideoInfo videoInfos) {
        adapter.setListData(videoInfos.getData());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind( this );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (videoPresenter!=null){
            videoPresenter.dettachView();
        }
    }
}
