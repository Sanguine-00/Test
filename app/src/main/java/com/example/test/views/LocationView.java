package com.example.test.views;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.example.test.R;

/**
 * Created by 张高强 on 2016/12/12.
 * 邮箱: zhang.gaoqiang@mobcb.com
 */

public class LocationView extends ImageView {

    private float preDegree = 0;
    private float degree = 0;
    private RotateAnimation animation;
    private SensorManager mSensorManager;
    private Sensor sensor;
    private Context mContext;

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
        this.mContext = context;
        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mSensorManager.registerListener(mSensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
//        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
//        mSensorManager.registerListener(mSensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mSensorManager.unregisterListener(mSensorEventListener);
    }

    //    public void setDegree(float d) {
//        this.degree = d;
//        showPicByDegree();
//    }
//
//    private void showPicByDegree() {
//        /**动画效果*/
//        animation = new RotateAnimation(preDegree, degree,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        animation.setDuration(200);
//        this.startAnimation(animation);
//        preDegree = -degree;
//
//    }


    private SensorEventListener mSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            /**
             * values[0]: x-axis 方向加速度
             * values[1]: y-axis 方向加速度
             * values[2]: z-axis 方向加速度
             */
//            float Ax = event.values[0];
//            float Ay = event.values[1];
//            float Az = event.values[2];
//            double α1 = Math.atan(Ax / Math.sqrt(Ay * Ay + Az * Az));
//
//            float degree = (float) (α1 * 180 / Math.PI);
            float degree = event.values[0];
            if (Math.abs(preDegree - degree) > 2) {
                animation = new RotateAnimation(preDegree, degree,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                animation.setFillAfter(true);
                preDegree = degree;
                LocationView.this.startAnimation(animation);
//                Log.e("sensor=", String.valueOf(degree));
//                Log.e("degree<1=", String.valueOf(degree < 1));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };


}
