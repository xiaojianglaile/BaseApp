package com.jimmy.common.base.view;

import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/6/15 0015.
 */
public interface IPageDataBinding<T> {

    void onStart(int page, int size, OnResponseListener<BaseResponse<List<T>>> listener);

    void onNext(int page, int size, OnResponseListener<BaseResponse<List<T>>> listener);
}
