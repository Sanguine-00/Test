package com.example.test.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by 张高强 on 2016/12/12.
 * 邮箱: zhang.gaoqiang@mobcb.com
 */

public class LocationView extends ImageView {

    private float preDegree = -45;
    private float degree = 0;
    private RotateAnimation animation;


    public float getDegree() {
        return degree;
    }

    public float getPreDegree() {
        return preDegree;
    }

    public void setPreDegree(float preDegree) {
        this.preDegree = preDegree;
    }

    public LocationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**动画效果*/
        animation = new RotateAnimation(preDegree, degree,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(200);
        this.startAnimation(animation);
        preDegree = -degree;
    }



    public void setDegree(float d) {
        this.degree = d;
        showPicByDegree();
    }

    private void showPicByDegree() {
        /**动画效果*/
        animation = new RotateAnimation(preDegree, degree,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(200);
        this.startAnimation(animation);
        preDegree = -degree;

    }


}
