package com.jimmy.common.listener;

import com.android.volley.VolleyError;

/**
 * Created by Jimmy on 2016/7/31.
 */
public abstract class OnResponseListener<T> {
    public abstract void onResponse(T response);
    public void onError(VolleyError error) {

    }
}
