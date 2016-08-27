package com.jimmy.friend.main;

import com.jimmy.common.base.mvp.IBaseModel;

/**
 * Created by Jimmy on 2016/8/27 0027.
 */
public interface IMainModel extends IBaseModel {
    void loadCommodities(OnLoadCommodityListener onLoadCommodityListener);
}
