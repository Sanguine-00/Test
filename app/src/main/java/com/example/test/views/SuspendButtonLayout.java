package com.example.test.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.test.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class SuspendButtonLayout extends RelativeLayout implements View.OnTouchListener {

    private float mScreenWidth, mScreenHeight; // 屏幕宽高，不包含状态栏

    private float mMarginY; // 上下方留出的空间
    private float mMarginX;//左右方留出的空间,默认为0

    private int mResMainClose, mResMainOpen;
    private ImageView imageMain;

    private float lastX, lastY;
    private float downX, downY;
    private boolean suspendedInLeft = true;

    public static final int SUSPEND_BUTTON_CLOSED = 0;
    public static final int SUSPEND_BUTTON_OPENED = 1;
    public static final int SUSPEND_BUTTON_CLOSING = 2;
    public static final int SUSPEND_BUTTON_OPENING = 3;
    public static final int SUSPEND_BUTTON_MOVING = 4;
    public static final int SUSPEND_BUTTON_MOVED = 5;
    private int suspendedStatus = 0;

    private OnSuspendListener listener = null;
    private Context mContext;

    public SuspendButtonLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        // mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        mScreenHeight = getResources().getDisplayMetrics().heightPixels - statusBarHeight;

        // 获取属性
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.SuspendButtonLayout, 0, 0);
        try {

            float minScreenWH = Math.min(mScreenWidth, mScreenHeight);
            // 上下方留出的空间，默认分别小于宽高中较小者的一半
            mMarginY = ta.getDimension(R.styleable.SuspendButtonLayout_marginY, mScreenHeight / 3);
            if (mMarginY > (minScreenWH / 2)) mMarginY = minScreenWH / 2;

            //左右方留出的空间,默认为0  最大为宽度的一半
            mMarginX = ta.getDimension(R.styleable.SuspendButtonLayout_marginX, 0);
            if (mMarginX > mScreenWidth / 2) mMarginX = mScreenWidth / 2;


            // 按钮的大小，默认小于主按钮与子按钮间距
            float mImageSize = ta.getDimension(R.styleable.SuspendButtonLayout_imageSize,
                    minScreenWH / 5);
            if (mImageSize > minScreenWH) mImageSize = minScreenWH;

            mResMainClose = ta.getResourceId(R.styleable.SuspendButtonLayout_imageMainClose,
                    R.drawable.video_recorder_start_btn);

            // 按钮布局
            LayoutParams params = new LayoutParams((int) mImageSize, (int) mImageSize);

            imageMain = new ImageView(context);
            imageMain.setPadding(0, 0, 0, 0);
            imageMain.setImageResource(mResMainClose);
            addView(imageMain, params);
            imageMain.setOnTouchListener(this);

            // imageView_main在最后绘制，所以在imageView_main绘制完成后初始化移动几个控件
            ViewTreeObserver vto = imageMain.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    moveAnimSingle(imageMain, 0f, 0f, mMarginX, mMarginY, 0, false);
                    //noinspection deprecation
                    imageMain.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });

        } finally {
            ta.recycle();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float viewX = v.getX();
        float viewY = v.getY();
        float eventX = event.getRawX();
        float eventY = event.getRawY();
        float startX, startY, endX = 0, endY;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = eventX;
                lastY = eventY;
                downX = eventX;
                downY = eventY;
                break;
            case MotionEvent.ACTION_MOVE:
                startX = viewX;
                startY = viewY;
                endX = viewX + (eventX - lastX);
                endY = viewY + (eventY - lastY);
                moveAnimSingle(imageMain, startX, startY, endX, endY, 0, false);

                if (Math.abs(lastX - downX) > 1 && Math.abs(lastY - downY) > 1) {
                    suspendedStatus = SUSPEND_BUTTON_MOVING;
                    if (listener != null) {
                        listener.onButtonStatusChanged(suspendedStatus);
                    }
                }
                lastX = eventX;
                lastY = eventY;
                break;
            case MotionEvent.ACTION_UP:
                startX = viewX;
                startY = viewY;
                // 判断左右
                if (viewX < mMarginX) {
                    endX = mMarginX - v.getWidth();
                } else if ((viewX + (v.getWidth() / 2)) < (mScreenWidth / 2)) { // 左
                    suspendedInLeft = true;
                    endX = mMarginX - v.getWidth();
                } else { // 右
                    suspendedInLeft = false;
                    endX = mScreenWidth - mMarginX;
                }
                // 判断上下
                if (viewY < mMarginY) {
                    endY = mMarginY;
                } else if ((viewY) < (mScreenHeight - mMarginY)) {
                    endY = viewY;
                } else {
                    endY = mScreenHeight - mMarginY;
                }

                suspendedStatus = SUSPEND_BUTTON_MOVED;
                moveAnimSingle(imageMain, startX, startY, endX, endY, 0, false);

                // 点击事件，打开关闭
                if (Math.abs(lastX - downX) < 1 && Math.abs(lastY - downY) < 1) {
                    Toast.makeText(mContext, "点击了悬浮按钮", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
        return true;
    }


    private void moveAnimSingle(Object object, float startX, float startY, float endX, float endY,
                                long duration, final boolean isAll) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(object, "translationX", startX, endX);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(object, "translationY", startY, endY);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorX, animatorY);
        set.setDuration(duration);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * Hide SuspendButton
     */
    public void hideSuspendButton() {
        imageMain.setVisibility(View.GONE);
    }

    /**
     * Show SuspendButton
     */
    public void showSuspendButton() {
        imageMain.setVisibility(View.VISIBLE);
    }


    /**
     * Set Main Button(Close) Image Resource
     *
     * @param res Resource
     */
    public void setMainCloseImageResource(int res) {
        mResMainClose = res;
        imageMain.setImageResource(mResMainClose);
    }

    /**
     * Set Main Button(Open) Image Resource
     *
     * @param res Resource
     */
    public void setMainOpenImageResource(int res) {
        mResMainOpen = res;
        if (suspendedStatus == SUSPEND_BUTTON_OPENED
                || suspendedStatus == SUSPEND_BUTTON_OPENING) {
            imageMain.setImageResource(mResMainOpen);
        }
    }

    /**
     * Set Listener
     *
     * @param listener Callback
     */
    public void setOnSuspendListener(OnSuspendListener listener) {
        this.listener = listener;
    }

    public interface OnSuspendListener {
        /**
         * Button Status Listener
         *
         * @param status Button Status
         *               <br>Closed：SuspendButtonLayout.SUSPEND_BUTTON_CLOSED
         *               <br>Opend：SuspendButtonLayout.SUSPEND_BUTTON_OPENED
         *               <br>Closing：SuspendButtonLayout.SUSPEND_BUTTON_CLOSING
         *               <br>Opening：SuspendButtonLayout.SUSPEND_BUTTON_OPENING
         *               <br>Moving：SuspendButtonLayout.SUSPEND_BUTTON_MOVING
         *               <br>Moved：SuspendButtonLayout.SUSPEND_BUTTON_MOVED
         */
        void onButtonStatusChanged(int status);

    }
}
