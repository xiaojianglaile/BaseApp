package com.jimmy.common.base.view;

import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/8 0008.
 */
public interface IDataBinding<T> {
    void onLoad(OnResponseListener<BaseResponse<List<T>>> listener);
}
