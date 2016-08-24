package com.jimmy.friend.activity;

import android.content.Intent;

import com.jimmy.common.base.app.BaseActivity;
import com.jimmy.friend.R;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void bindData() {
        super.bindData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
