package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.jingfeng.CanTingActivity;
import com.example.test.animation.AnimationActivity;
import com.example.test.animation.ShakeActivity;
import com.example.test.map.MapActivity;
import com.example.test.suspend.Main2Activity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mEtX;
    private EditText mEtY;
    private EditText mEtStr;
    private TextView tvResult;
    private TextView mTvHelloworldFromC;
    private Button mBtnCalculate;
    private Button mBtnSign;
    private Button mBtnStartNewActivity;
    private Button mBtnStartAnimationActivity;
    private Button mBtnShake;
    private Button btn_mapView;
    private Button btn_suspend;
    private ImageView mImageView;


    private float preDegree = -45;
    private float degree = 0;
    private RotateAnimation animation;
    private SensorManager mSensorManager;
    private Sensor sensor;

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
                animation = new RotateAnimation(degree, preDegree,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                animation.setFillAfter(true);
                preDegree = -degree;
                mImageView.startAnimation(animation);
//                Log.e("sensor=", String.valueOf(degree));
//                Log.e("degree<1=", String.valueOf(degree < 1));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initSensor();
    }

    private void initView() {
        mTvHelloworldFromC = (TextView) this.findViewById(R.id.tvHelloworldFromC);
        mBtnCalculate = (Button) this.findViewById(R.id.btnCalculate);
        mBtnStartNewActivity = (Button) this.findViewById(R.id.startCanTingActivity);
        mBtnStartAnimationActivity = (Button) this.findViewById(R.id.startAnimationActivity);
        btn_suspend = (Button) this.findViewById(R.id.btn_suspend);
        mBtnShake = (Button) findViewById(R.id.btn_shake);
        btn_mapView = (Button) findViewById(R.id.btn_mapView);
        mImageView = (ImageView) findViewById(R.id.image_loc);
        mBtnSign = (Button) this.findViewById(R.id.btnSign);
        mEtX = (EditText) this.findViewById(R.id.etX);
        mEtY = (EditText) this.findViewById(R.id.etY);
        mEtStr = (EditText) this.findViewById(R.id.etStr);
        tvResult = (TextView) this.findViewById(R.id.tvResult);
        mTvHelloworldFromC.setOnClickListener(this);
        mBtnCalculate.setOnClickListener(this);
        mBtnSign.setOnClickListener(this);
        mBtnStartNewActivity.setOnClickListener(this);
        mBtnStartAnimationActivity.setOnClickListener(this);
        mBtnShake.setOnClickListener(this);
        btn_mapView.setOnClickListener(this);
        btn_suspend.setOnClickListener(this);
    }


    /**
     * 初始化传感器
     */
    private void initSensor() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

    }


    @Override
    protected void onResume() {
        mSensorManager.registerListener(mSensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorEventListener);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_mapView:
                intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_shake:
                intent = new Intent(MainActivity.this, ShakeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_suspend:
                intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btnCalculate:
                Editable mEtXText = mEtX.getText();
                Editable mEtYText = mEtY.getText();
                if (mEtXText != null && mEtYText != null) {
                    String mStrX = mEtXText.toString().trim();
                    String mStrY = mEtYText.toString().trim();
                    if (mStrX != null && mStrY != null && !mStrX.equals("") && !mStrY.equals("")) {
                        tvResult.setText(String.valueOf(new JniTest().add(Integer.parseInt(mStrX), Integer.parseInt(mStrY))));
                    } else {
                        Toast.makeText(MainActivity.this, "数字输入有误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "数字输入有误", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnSign:
                if (mEtStr.getText() != null && !mEtStr.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "密文是:"
                            + new JniTest().sayHelloInC(mEtStr.getText().toString().trim()), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.startAnimationActivity:
                intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.startCanTingActivity:
                intent = new Intent(MainActivity.this, CanTingActivity.class);
                startActivity(intent);
                break;
            case R.id.tvHelloworldFromC:
                Toast.makeText(MainActivity.this, new JniTest().helloworldFromC(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
