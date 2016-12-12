package com.sanguine.zhang.flashtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by 张高强 on 2016/12/9.
 * 邮箱: zhang.gaoqiang@mobcb.com
 */

public class MyFirstView extends View {

    /* * 文本
     */
    private String mTitleText;
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    private float mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;


    public MyFirstView(Context context) {
        this(context, null);
    }

    public MyFirstView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context
                .getTheme()
                .obtainStyledAttributes(attrs, R.styleable.MyFirstView, defStyleAttr, 0);
        int num = typedArray.length();
        for (int i = 0; i < num; i++) {
            int attr = i;
            if (attr == R.styleable.MyFirstView_myText) {
                mTitleText = typedArray.getString(attr);
            } else if (attr == R.styleable.MyFirstView_textColor) {
                mTitleTextColor = typedArray.getInt(attr, Color.BLACK);
            } else if (attr == R.styleable.MyFirstView_textSize) {
                mTitleTextSize = typedArray.getDimension(attr,
                        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                                16f,
                                getResources().getDisplayMetrics()));
            }

        }

        if (mTitleText == null) {
            mTitleText = "null";
        }

        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        // mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
    }


    float mStartX = 0, mStartY = 0,
            mEndX = 0,
            mEndY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = event.getX();
                mStartY = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                mEndX = event.getX();
                mEndY = event.getY();
                break;
        }

//        if (Math.abs(mEndX - mStartX) < 1 && Math.abs(mEndY - mStartY) < 1) {
            mTitleText = getRandom();
            postInvalidate();

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this.getContext(), "onKeyDown", Toast.LENGTH_SHORT).show();
        mTitleText = getRandom();
        postInvalidate();
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.d("widthMode=", String.valueOf(widthMode));
        Log.d("widthSize=", String.valueOf(widthSize));
        Log.d("heightMode=", String.valueOf(heightMode));
        Log.d("heightSize=", String.valueOf(heightSize));
        int width = 0, height = 0;
        switch (widthMode) {
            case MeasureSpec.EXACTLY:// 明确指定了
                width = getPaddingLeft() + getPaddingRight() + widthSize;
                break;
            case MeasureSpec.AT_MOST:// 一般为WARP_CONTENT
                width = getPaddingLeft() + getPaddingRight() + mBound.width();
                break;
            default:
                width = widthSize;
                break;
        }
        switch (heightMode) {
            case MeasureSpec.EXACTLY:// 明确指定了
                height = getPaddingTop() + getPaddingBottom() + heightSize;
                break;
            case MeasureSpec.AT_MOST:// 一般为WARP_CONTENT
                height = getPaddingTop() + getPaddingBottom() + mBound.height();
                break;
            default:
                height = heightSize;
                break;
        }


        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }


    public String getRandom() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
