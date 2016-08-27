package com.jimmy.friend.main;

import android.os.AsyncTask;

import com.jimmy.common.listener.OnTaskFinishedListener;
import com.jimmy.friend.bean.Commodity;

import java.util.List;

/**
 * Created by Jimmy on 2016/8/27 0027.
 */
public class MainModel implements IMainModel {

    @Override
    public void loadCommodities(final OnLoadCommodityListener onLoadCommodityListener) {
        new LoadCommoditiesTask(new OnTaskFinishedListener<List<Commodity>>() {
            @Override
            public void onTaskFinished(List<Commodity> data) {
                if (onLoadCommodityListener != null) {
                    if (data != null) {
                        if (data.size() == 0) {
                            onLoadCommodityListener.onDataIsNull();
                        } else {
                            onLoadCommodityListener.onFinished(data);
                        }
                    } else {
                        onLoadCommodityListener.onFailed();
                    }
                }
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}
