package com.example.jingfeng.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.jingfeng.android.bean.APIHostInfo;
import com.example.jingfeng.android.bean.Restaurant;
import com.example.jingfeng.android.util.JSONTools;
import com.example.jingfeng.android.util.ScreenUtils;
import com.example.test.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张高强 on 2016/12/7.
 * 邮箱: zhang.gaoqiang@mobcb.com
 */

public class MListAdapter extends BaseAdapter implements ListAdapter {

    private FrameLayout.LayoutParams lpImage;
    private List<Restaurant> mList;
    private Context mContext;
    private APIHostInfo apiHostInfo = null;
    private int screenWidth;
    int heightImage = 100;
    private Animation mAnimation;
//    private Map<Integer, Boolean> isFirst;

    public MListAdapter(List<Restaurant> list, Context context, APIHostInfo apiHostInfo) {
        super();
        mList = list;
        mContext = context;
        this.apiHostInfo = apiHostInfo;
        screenWidth = (int) new ScreenUtils(context).getScreenWidth();
        heightImage = screenWidth * 11 / 18;
        lpImage = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, heightImage);
//        isFirst = new HashMap<>();
        mAnimation = AnimationUtils.loadAnimation(context, R.anim.list_anim);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup group) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_restaurant, null);
            viewHolder.shop_dec = (TextView) view.findViewById(R.id.shop_dec);
            viewHolder.shop_pic = (ImageView) view.findViewById(R.id.shop_pic);
            viewHolder.shop_title = (TextView) view.findViewById(R.id.shop_title);
            viewHolder.shop_info = (ImageView) view.findViewById(R.id.shop_info);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Restaurant restaurant = null;
        try {
            restaurant = mList.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            viewHolder.shop_dec.setText(restaurant.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            viewHolder.shop_title.setText(restaurant.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Picasso.with(mContext)
                    .load(JSONTools.formatURL(
                            mList.get(i).getIcon(),
                            apiHostInfo.getSchema(),
                            apiHostInfo.getHost(),
                            apiHostInfo.getContextPath(),
                            180))
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(viewHolder.shop_pic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            viewHolder.shop_info.setLayoutParams(lpImage);
            Picasso.with(mContext)
                    .load(restaurant.getDoorImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(viewHolder.shop_info);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        if (isFirst.get(i) == null || isFirst.get(i)) {
//            view.startAnimation(mAnimation);
//            isFirst.put(i, false);
//        }
        return view;
    }


    final class ViewHolder {
        public ImageView shop_pic;
        public TextView shop_title;
        public TextView shop_dec;
        public ImageView shop_info;
    }


}
