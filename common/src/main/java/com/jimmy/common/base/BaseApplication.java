package com.jimmy.common.base;

import android.app.Application;

import com.jimmy.common.utils.HttpUtils;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtils.initRequestQueue(this);
    }

}
