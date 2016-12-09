package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animation.AnimationActivity;
import com.example.jingfeng.android.CanTingActivity;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    private EditText mEtX;
    private EditText mEtY;
    private EditText mEtStr;
    private TextView tvResult;
    private TextView mTvHelloworldFromC;
    private Button mBtnCalculate;
    private Button mBtnSign, mBtnStartNewActivity, mBtnStartAnimationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvHelloworldFromC = (TextView) this.findViewById(R.id.tvHelloworldFromC);
        mBtnCalculate = (Button) this.findViewById(R.id.btnCalculate);
        mBtnStartNewActivity = (Button) this.findViewById(R.id.startCanTingActivity);
        mBtnStartAnimationActivity = (Button) this.findViewById(R.id.startAnimationActivity);
        mBtnSign = (Button) this.findViewById(R.id.btnSign);
        mEtX = (EditText) this.findViewById(R.id.etX);
        mEtY = (EditText) this.findViewById(R.id.etY);
        mEtStr = (EditText) this.findViewById(R.id.etStr);
        tvResult = (TextView) this.findViewById(R.id.tvResult);

        mTvHelloworldFromC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, new JniTest().helloworldFromC(), Toast.LENGTH_SHORT).show();
            }
        });

        mBtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

        mBtnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEtStr.getText() != null && !mEtStr.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "密文是:"
                            + new JniTest().sayHelloInC(mEtStr.getText().toString().trim()), Toast.LENGTH_SHORT).show();
                }
            }
        });


        mBtnStartNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CanTingActivity.class);
                startActivity(intent);
            }
        });

        mBtnStartAnimationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });
    }


}
