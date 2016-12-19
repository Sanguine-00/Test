package com.example.test.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by 张高强 on 2016/12/19.
 * 邮箱: zhang.gaoqiang@mobcb.com
 */

public class RadarView extends View {

    private Context mContext;
    private Paint mPaint;//画圆的画笔
    private Paint mSaoMiaoPaint;//扫描的画笔
    private float scanSpeed = 5;//扫描速度
    private float scanAngle;//扫描速度
    private Shader scanShader; // 扫描渲染shader
    private Matrix mMatrix = new Matrix();//矩阵

    private float[] pots = {0.05f, 0.1f, 0.15f, 0.2f, 0.25f};


    private float mWidth;//屏幕宽度
    private float mHeight;//屏幕高度

    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
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


        // 画圆用到的paint
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE); // 描边
        mPaint.setStrokeWidth(1); // 宽度
        mPaint.setAlpha(100); // 透明度
        mPaint.setAntiAlias(true); // 抗锯齿
        mPaint.setColor(Color.parseColor("#B0C4DE")); // 设置颜色 亮钢兰色

        // 扫描用到的paint
        mSaoMiaoPaint = new Paint();
        mSaoMiaoPaint.setStyle(Paint.Style.FILL_AND_STROKE); // 填充
        mSaoMiaoPaint.setAntiAlias(true); // 抗锯齿
        post(mRunnable);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 5; i++) {
            canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth * pots[i], mPaint);
        }

        // 画布的旋转变换 需要调用save() 和 restore()
        canvas.save();

        scanShader = new SweepGradient(mWidth / 2, mHeight / 2,
                new int[]{Color.TRANSPARENT, Color.parseColor("#84B5CA")}, null);
        mSaoMiaoPaint.setShader(scanShader); // 设置着色器
        canvas.concat(mMatrix);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth * pots[4], mSaoMiaoPaint);

        canvas.restore();
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            scanAngle = (scanAngle + scanSpeed) % 360;
            mMatrix.postRotate(scanSpeed, mWidth / 2, mHeight / 2);//旋转矩阵
            invalidate();//通知从新绘制
            postDelayed(mRunnable, 130);//自己调用自己  重复绘制
        }
    };
}
