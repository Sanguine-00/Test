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

    private float mScreenWidth, mScreenHeight; // ��Ļ��ߣ�������״̬��

    private float mMarginY; // ���·������Ŀռ�
    private float mMarginX;//���ҷ������Ŀռ�,Ĭ��Ϊ0

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

        // ��ȡ��Ļ���
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

        // ��ȡ����
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.SuspendButtonLayout, 0, 0);
        try {

            float minScreenWH = Math.min(mScreenWidth, mScreenHeight);
            // ���·������Ŀռ䣬Ĭ�Ϸֱ�С�ڿ���н�С�ߵ�һ��
            mMarginY = ta.getDimension(R.styleable.SuspendButtonLayout_marginY, mScreenHeight / 3);
            if (mMarginY > (minScreenWH / 2)) mMarginY = minScreenWH / 2;

            //���ҷ������Ŀռ�,Ĭ��Ϊ0  ���Ϊ��ȵ�һ��
            mMarginX = ta.getDimension(R.styleable.SuspendButtonLayout_marginX, 0);
            if (mMarginX > mScreenWidth / 2) mMarginX = mScreenWidth / 2;


            // ��ť�Ĵ�С��Ĭ��С������ť���Ӱ�ť���
            float mImageSize = ta.getDimension(R.styleable.SuspendButtonLayout_imageSize,
                    minScreenWH / 5);
            if (mImageSize > minScreenWH) mImageSize = minScreenWH;

            mResMainClose = ta.getResourceId(R.styleable.SuspendButtonLayout_imageMainClose,
                    R.drawable.video_recorder_start_btn);

            // ��ť����
            LayoutParams params = new LayoutParams((int) mImageSize, (int) mImageSize);

            imageMain = new ImageView(context);
            imageMain.setPadding(0, 0, 0, 0);
            imageMain.setImageResource(mResMainClose);
            addView(imageMain, params);
            imageMain.setOnTouchListener(this);

            // imageView_main�������ƣ�������imageView_main������ɺ��ʼ���ƶ������ؼ�
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
                // �ж�����
                if (viewX < mMarginX) {
                    endX = mMarginX - v.getWidth();
                } else if ((viewX + (v.getWidth() / 2)) < (mScreenWidth / 2)) { // ��
                    suspendedInLeft = true;
                    endX = mMarginX - v.getWidth();
                } else { // ��
                    suspendedInLeft = false;
                    endX = mScreenWidth - mMarginX;
                }
                // �ж�����
                if (viewY < mMarginY) {
                    endY = mMarginY;
                } else if ((viewY) < (mScreenHeight - mMarginY)) {
                    endY = viewY;
                } else {
                    endY = mScreenHeight - mMarginY;
                }

                suspendedStatus = SUSPEND_BUTTON_MOVED;
                moveAnimSingle(imageMain, startX, startY, endX, endY, 0, false);

                // ����¼����򿪹ر�
                if (Math.abs(lastX - downX) < 1 && Math.abs(lastY - downY) < 1) {
                    Toast.makeText(mContext, "�����������ť", Toast.LENGTH_SHORT).show();
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
         *               <br>Closed��SuspendButtonLayout.SUSPEND_BUTTON_CLOSED
         *               <br>Opend��SuspendButtonLayout.SUSPEND_BUTTON_OPENED
         *               <br>Closing��SuspendButtonLayout.SUSPEND_BUTTON_CLOSING
         *               <br>Opening��SuspendButtonLayout.SUSPEND_BUTTON_OPENING
         *               <br>Moving��SuspendButtonLayout.SUSPEND_BUTTON_MOVING
         *               <br>Moved��SuspendButtonLayout.SUSPEND_BUTTON_MOVED
         */
        void onButtonStatusChanged(int status);

    }
}
