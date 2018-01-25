package com.example.quarterhour.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quarterhour.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by zm on 2018/1/1.
 */

public class MyCehuaAdapter extends BaseAdapter {
    Context context;
    List<String> mlist;
    public MyCehuaAdapter(Context context, List<String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    final int TYPE_1 = 0;
    final int TYPE_2 = 1;

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        viewHolder2 holder2;
        int type = getItemViewType(position);

        if (type == TYPE_1) {
            if (convertView == null) {
                holder = new viewHolder();
                convertView = View.inflate(context, R.layout.cehua_listviewitem1, null);
                holder.relativeLayout = convertView.findViewById(R.id.cehua_relative);
                holder.touxiang = convertView.findViewById(R.id.image_touxiang);
                holder.name = convertView.findViewById(R.id.cehua_name);
                holder.sex = convertView.findViewById(R.id.cehua_image_xingbie);
                convertView.setTag(holder);
            } else {
                holder = (viewHolder) convertView.getTag();

            }
            if (position == 0) {
                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "基本信息", Toast.LENGTH_SHORT).show();

                    }
                });
            }
            return convertView;

        } else {

            if (convertView == null) {
                holder2 = new viewHolder2();
                convertView = View.inflate(context, R.layout.cehua_listviewitem2, null);
                holder2.imageView = convertView.findViewById(R.id.cehua_image_tubiao);
                holder2.text_title = convertView.findViewById(R.id.cehua_text);
                convertView.setTag(holder2);
            } else {
                holder2 = (viewHolder2) convertView.getTag();

            }
            if (position == 1) {
                holder2.imageView.setImageResource(R.mipmap.xin);
                holder2.text_title.setText("我的关注");
            }

            if (position == 2) {
                holder2.imageView.setImageResource(R.mipmap.xingxing);
                holder2.text_title.setText("我的收藏");
            }
            if (position == 3) {
                holder2.imageView.setImageResource(R.mipmap.menu_sousuo);
                holder2.text_title.setText("搜索好友");
            }
            if (position == 4) {
                holder2.imageView.setImageResource(R.mipmap.lingdang);
                holder2.text_title.setText("消息通知");

            }

            return convertView;

        }
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0){
            return TYPE_1;
        }else{
            return TYPE_2;
        }
    }

    class viewHolder{
        RelativeLayout relativeLayout;
        SimpleDraweeView touxiang;
        TextView name;
        ImageView sex;
    }

    class viewHolder2{
        ImageView imageView;
        TextView text_title;
    }
}
