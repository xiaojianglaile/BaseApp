package com.jimmy.common.listener;

import com.jimmy.common.base.net.BaseResponse;

/**
 * Created by Jimmy on 2016/7/31.
 */
public interface OnResponseListener<T> {
    void onResponse(BaseResponse<T> response);
}
