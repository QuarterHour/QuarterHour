package com.example.quarterhour.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.example.quarterhour.base.BaseFragment;
import com.example.quarterhour.duan.adapter.RecyclerViewAdapter;
import com.example.quarterhour.duan.bean.DuanBean;
import com.example.quarterhour.duan.presenter.Duanpresenter;
import com.example.quarterhour.duan.utils.DividerItemDecoration;
import com.example.quarterhour.duan.view.DView;
import com.example.quarterhour.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 0.0 on 2018/1/23.
 */

public class Fragment_duanzi extends BaseFragment implements DView{
    private View view;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter apadter;
    private SwipeRefreshLayout swipeRefreshView;
   private List<DuanBean.DataBean> lists=new ArrayList<>();
   int count=0;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_duanzi;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(apadter);


        swipeRefreshView=view.findViewById(R.id.swipe);
        // 设置颜色属性的时候一定要注意是引用了资源文件还是直接设置16进制的颜色，因为都是int值容易搞混
        // 设置下拉进度的背景颜色，默认就是白色的
        swipeRefreshView.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
        swipeRefreshView.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);

        // 下拉时触发SwipeRefreshLayout的下拉动画，动画完毕之后就会回调这个方法
        swipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // 开始刷新，设置当前为刷新状态
                //swipeRefreshLayout.setRefreshing(true);

                // 这里是主线程
                // 一些比较耗时的操作，比如联网获取数据，需要放到子线程去执行
                // TODO 获取数据
                final Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getContext(), "刷新了一条数据", Toast.LENGTH_SHORT).show();

                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        initData();
                        swipeRefreshView.setRefreshing(false);
                    }
                }, 1200);

                // System.out.println(Thread.currentThread().getName());

                // 这个不能写在外边，不然会直接收起来
                //swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    @Override
    protected void initData() {
        Duanpresenter duanpresenter=new Duanpresenter(this);
        duanpresenter.getliedata();

    }

    @Override
    public void success(DuanBean duanBean) {
         apadter = new RecyclerViewAdapter(getContext(),duanBean.getData());
        recyclerView.setAdapter(apadter);
    }
}
