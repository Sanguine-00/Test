package com.example.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.test.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class AnimationActivity extends AppCompatActivity {

    @InjectView(R.id.imageView)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.alpha, R.id.Scale, R.id.Rotate, R.id.Translate, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alpha:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                //1->0  从完全透明  ->  完全不透明
                alphaAnimation.setDuration(2000);
                mImageView.startAnimation(alphaAnimation);
                break;
            case R.id.Scale:
                //参数1：x轴的初始值
                //参数2：x轴收缩后的值
                //参数3：y轴的初始值
                //参数4：y轴收缩后的值
                //参数5：确定x轴坐标的类型
                //参数6：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
                //参数7：确定y轴坐标的类型
                //参数8：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 0.1f, 0, 0.1f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.ABSOLUTE,
                        100f);
                scaleAnimation.setDuration(2000);
                mImageView.startAnimation(scaleAnimation);
                break;
            case R.id.Rotate:
                //参数1：从哪个旋转角度开始
                //参数2：转到什么角度
                //后4个参数用于设置围绕着旋转的圆的圆心在哪里
                //参数3：确定x轴坐标的类型，
                // 有ABSOLUT绝对坐标、
                // RELATIVE_TO_SELF相对于自身坐标、
                // RELATIVE_TO_PARENT相对于父控件的坐标
                //参数4：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
                //参数5：确定y轴坐标的类型
                //参数6：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
                RotateAnimation rotateAnimation = new RotateAnimation(
                        0,
                        360,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.ABSOLUTE,
                        100f);
                rotateAnimation.setDuration(2000);
                mImageView.startAnimation(rotateAnimation);
                break;
            case R.id.Translate:
                //参数1～2：x轴的开始位置
                //参数3～4：y轴的开始位置
                //参数5～6：x轴的结束位置
                //参数7～8：x轴的结束位置
                TranslateAnimation translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                translateAnimation.setDuration(2000);
                mImageView.startAnimation(translateAnimation);
                break;

            case R.id.button:
                Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.double_anim_test);
                mImageView.startAnimation(animation);
                break;
        }
    }
}
