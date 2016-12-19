package com.example.test.suspend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.views.SuspendButtonLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main2Activity extends AppCompatActivity {

    @InjectView(R.id.sbl_suspend)
    SuspendButtonLayout mSblSuspend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.inject(this);
        mSblSuspend.setOnSuspendListener(new SuspendButtonLayout.OnSuspendListener() {
            @Override
            public void onButtonStatusChanged(int status) {
                switch (status) {
                    case SuspendButtonLayout.SUSPEND_BUTTON_MOVING:
                        // 移动时改变图片
                        mSblSuspend.setMainCloseImageResource(R.mipmap.ic_launcher);
                        break;
                    case SuspendButtonLayout.SUSPEND_BUTTON_MOVED:
                        // 移动到位后改变图片
                        mSblSuspend.setMainCloseImageResource(R.drawable.video_recorder_start_btn);
                        break;
                }
            }
        });
    }
}
