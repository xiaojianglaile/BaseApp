package com.jimmy.friend.main;

import com.jimmy.friend.bean.Commodity;

import java.util.List;

/**
 * Created by Jimmy on 2016/8/27 0027.
 */
public interface OnLoadCommodityListener {
    void onFinished(List<Commodity> data);
    void onFailed();
    void onDataIsNull();
}
