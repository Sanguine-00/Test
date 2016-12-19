package com.sanguine.zhang.flashtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.y;

/**
 * Created by 张高强 on 2016/12/19.
 * 邮箱: zhang.gaoqiang@mobcb.com
 * 可以做比重图用
 */

public class NeonLampView extends View implements View.OnTouchListener {
    private Context mContext;
    private int[] mColors = {Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED, Color.WHITE};
    private Canvas mCanvas;
    private Paint mPaint, paint2;
    private float mScreenWidth, mScreenHeight; // 屏幕宽高，不包含状态栏
    private int R = 200;
    private int N = 7;
    private Point mPoint;
    private Point p1;
    private Path mPath, path2, path3;
    private int α;
    private int[] mData = {3, 3, 2, 5, 2, 4, 2};//数据信息  以5作为分母


    public NeonLampView(Context context) {
        this(context, null);
    }

    public NeonLampView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NeonLampView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = getResources().getDisplayMetrics().heightPixels - statusBarHeight;
        mPoint = new Point((int) (mScreenWidth / 2), (int) (mScreenHeight / 2));
        p1 = new Point((int) mScreenWidth, (int) (mScreenHeight / 2));
        α = -360 / N;
        path2 = new Path();
        path2.moveTo(mPoint.x, mPoint.y);
//        setOnTouchListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);
        path3 = new Path();
        p1 = new Point((int) (mScreenWidth / 2 / 11), (int) (mScreenHeight / 2));
        R = p1.x - mPoint.x;
        float x2 = 0, y2 = 0;
        for (int i = 0; i < N; i++) {
            float x = Double.valueOf(R * Math.cos(jiaodu2hudu(α * i)) * mData[i] / 5 + mPoint.x).floatValue();
            float y = Double.valueOf(R * Math.sin(jiaodu2hudu(α * i)) * mData[i] / 5 + mPoint.y).floatValue();
            if (i == 0) {
//                path3.moveTo(x * mData[i] / 5, y * mData[i] / 5);
                path3.moveTo(x, y);
                x2 = x;
                y2 = y;
//                x2 = x * mData[i] / 5;
//                y2 = y * mData[i] / 5;
            } else {
                path3.lineTo(x, y);
//                path3.lineTo(x * mData[i] / 5, y * mData[i] / 5);
            }
            canvas.drawCircle(x, y, 5, paint2);
        }
        path3.lineTo(x2, y2);
        canvas.drawPath(path3, paint2);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);


        for (int j = 0; j < 11; j++) {
            p1 = new Point((int) (mScreenWidth / 2 * (j + 1) / 11), (int) (mScreenHeight / 2));
            mPath = new Path();
            R = p1.x - mPoint.x;
            for (int i = 0; i < N; i++) {
                float x = Double.valueOf(R * Math.cos(jiaodu2hudu(α * i)) + mPoint.x).floatValue();
                float y = Double.valueOf(R * Math.sin(jiaodu2hudu(α * i)) + mPoint.y).floatValue();
                if (i == 0) {
                    mPath.moveTo(x, y);

                } else {
                    mPath.lineTo(x, y);
                }
                path2.lineTo(x, y);
                canvas.drawPath(path2, mPaint);
                path2.moveTo(mPoint.x, mPoint.y);
            }
            mPath.lineTo(p1.x, p1.y);
            canvas.drawPath(mPath, mPaint);
        }



    }
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        this.mCanvas = canvas;
//        mPaint = new Paint();
//        for (int i = 0; i < mColors.length; i++) {
//            mPaint.setColor(mColors[i]);
//            canvas.drawRect(0, 0, getMeasuredWidth() / (i + 1), getMeasuredHeight() / (i + 1), mPaint);
//        }
//    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        try {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    int[] temp = new int[5];
                    for (int j = 0; j < 5; j++) {
                        temp[j] = mColors[(j + 1) % 5];
                    }
                    mColors = temp;
                    postInvalidate();
                }
            };
            timer.scheduleAtFixedRate(timerTask, 500, 500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private double jiaodu2hudu(double jiaodu) {
        return jiaodu * Math.PI / 180;
    }
}
