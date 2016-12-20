package com.example.test.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by 张高强 on 2016/12/19.
 * 邮箱: zhang.gaoqiang@mobcb.com
 * 自定义View之 闪烁的字
 */

public class MyShimmerTextView extends TextView {
    private Context mContext;
    private int speed = 200;//闪烁时间间隔
    private float length = 0;//闪烁距离
    private Matrix mMatrix;//矩阵
    private Shader mShader;//着色器
    private Paint mPaint;//画笔
    private String mText;// 文字
    private float mWidth;//屏幕宽度
    private float mHeight;// 屏幕高度


    public MyShimmerTextView(Context context) {
        this(context, null);
    }

    public MyShimmerTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyShimmerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 获取屏幕宽高
        int statusBarHeight = 0;
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            statusBarHeight = getResources().getDimensionPixelSize(
                    Integer.parseInt(field.get(obj).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mWidth = context.getResources().getDisplayMetrics().widthPixels;
        mHeight = context.getResources().getDisplayMetrics().heightPixels - statusBarHeight;

        measure(0, 0);

        mText = "Hello Shimmer!";
        mMatrix = new Matrix();
//        mShader =  new LinearGradient(0, 0, mWidth, 0, new int[] { Color.BLACK, Color.WHITE, Color.BLACK }, null, Shader.TileMode.CLAMP);
        //创建线性着色器对象
        mShader = new LinearGradient((mWidth - getMeasuredWidth()) / 2,
                mHeight / 2,
                (mWidth + getMeasuredWidth() / 2), mHeight / 2,
                new int[]{Color.BLUE,
                        Color.WHITE, Color.YELLOW, Color.RED},
                null,
                Shader.TileMode.CLAMP);//创建线性着色器对象

        mPaint = getPaint();
        mPaint.setShader(mShader);
        mPaint.setColor(Color.YELLOW);
        mPaint.setAntiAlias(true);//是否抗锯齿
//        post(mRunnable);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mMatrix != null) {
            length += mWidth / 10;//每次移动屏幕的1/10宽
            if (length > 2 * mWidth) {
                length = -mWidth;
            }
            length += mWidth / 10;
//            if (length > mWidth) {
//                length = 0;
//            }
            mMatrix.setTranslate(length, 0);
            mShader.setLocalMatrix(mMatrix);//在指定矩阵上渲染
            postInvalidateDelayed(speed);
        }

    }


//    private Runnable mRunnable = new Runnable() {
//        @Override
//        public void run() {
//            length += mWidth / 10;
//            length = length % (int) mWidth;
//            mMatrix.setTranslate(length, mHeight / 2);//设置平移矩阵
//            invalidate();//通知重绘
//            postDelayed(mRunnable, speed);//自己调用自己  返回绘制
//        }
//    };


}
