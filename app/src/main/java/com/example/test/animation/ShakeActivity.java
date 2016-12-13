package com.example.test.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.test.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShakeActivity extends AppCompatActivity {

    @InjectView(R.id.iv_shake)
    ImageView mIvShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.iv_shake)
    public void onClick() {
        Animation animation = AnimationUtils.loadAnimation(ShakeActivity.this, R.anim.shake_list_anim);
        mIvShake.startAnimation(animation);
    }
}
