package com.jimmy.common.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.listener.OnResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Jimmy on 2016/7/31.
 */
public class HttpUtils {

    private static RequestQueue mRequestQueue;

    public synchronized static void initRequestQueue(Context context) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
    }

    /**
     * 同步Get请求
     *
     * @param url 请求地址
     * @return 返回数据实体类
     */
    public static <T> BaseResponse<T> syncHttpGet(String url) {
        return syncHttpGet(url, null);
    }

    /**
     * 同步Get请求
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 返回数据实体类
     */
    public static <T> BaseResponse<T> syncHttpGet(String url, Map<String, Object> params) {
        return syncHttpGet(url, params, null);
    }


    /**
     * 同步Get请求
     *
     * @param url     请求地址
     * @param params  请求参数
     * @param headers 请求头
     * @return 返回数据实体类
     */
    public static <T> BaseResponse<T> syncHttpGet(String url, Map<String, Object> params, final Map<String, String> headers) {
        try {
            if (params != null)
                url = getParamsUrl(url, params);
            RequestFuture future = RequestFuture.newFuture();
            Gson gson = new Gson();
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, future, future) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    if (headers == null)
                        return super.getHeaders();
                    else
                        return headers;
                }
            };
            mRequestQueue.add(request);
            return gson.fromJson(future.get().toString(), new TypeToken<BaseResponse<T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse();
        }
    }


    /**
     * 同步Post请求
     *
     * @param url    请求地址
     * @param params 请求参数实体类
     * @return 返回数据实体类
     */
    public static <T, P> BaseResponse<T> syncHttpPost(String url, P params) {
        return syncHttpPost(url, null, params);
    }

    /**
     * 同步Post请求
     *
     * @param url        请求地址
     * @param pathParams 请求参数
     * @param params     请求参数实体类
     * @return 返回数据实体类
     */
    public static <T, P> BaseResponse<T> syncHttpPost(String url, Map<String, Object> pathParams, P params) {
        return syncHttpPost(url, pathParams, null, params);
    }

    /**
     * 同步Post请求
     *
     * @param url        请求地址
     * @param pathParams 请求参数
     * @param headers    请求头
     * @param params     请求参数实体类
     * @return 返回数据实体类
     */
    public static <T, P> BaseResponse<T> syncHttpPost(String url, Map<String, Object> pathParams, final Map<String, String> headers, P params) {
        try {
            if (pathParams != null)
                url = getParamsUrl(url, pathParams);
            RequestFuture future = RequestFuture.newFuture();
            Gson gson = new Gson();
            if (params != null) {
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(gson.toJson(params)), future, future) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        if (headers == null)
                            return super.getHeaders();
                        else
                            return headers;
                    }
                };
                mRequestQueue.add(request);
                return new Gson().fromJson(future.get().toString(), new TypeToken<BaseResponse<T>>() {
                }.getType());
            } else {
                return new BaseResponse();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse();
        }
    }


    /**
     * 异步Get请求
     *
     * @param url                请求地址
     * @param onResponseListener 请求回调接口
     */
    public static <T> void httpGet(String url, OnResponseListener<T> onResponseListener) {
        httpGet(url, null, onResponseListener);
    }

    /**
     * 异步Get请求
     *
     * @param url                请求地址
     * @param params             请求参数
     * @param onResponseListener 请求回调接口
     */
    public static <T> void httpGet(String url, Map<String, Object> params, final OnResponseListener<T> onResponseListener) {
        httpGet(url, params, null, onResponseListener);
    }

    /**
     * 异步Get请求
     *
     * @param url                请求地址
     * @param params             请求参数
     * @param headers            请求头
     * @param onResponseListener 请求回调接口
     */
    public static <T> void httpGet(String url, Map<String, Object> params, final Map<String, String> headers, final OnResponseListener<T> onResponseListener) {
        if (params != null)
            url = getParamsUrl(url, params);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (onResponseListener != null) {
                    onResponseListener.onResponse((BaseResponse<T>) new Gson().fromJson(response.toString(), new TypeToken<BaseResponse<T>>() {
                    }.getType()));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (onResponseListener != null) {
                    onResponseListener.onError();
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null)
                    return super.getHeaders();
                else
                    return headers;
            }
        };
        mRequestQueue.add(request);
    }

    /**
     * 异步Post请求
     *
     * @param url                请求地址
     * @param params             请求参数实体类
     * @param onResponseListener 请求回调接口
     */
    public static <T, P> void httpPost(String url, P params, final OnResponseListener<T> onResponseListener) {
        httpPost(url, null, params, onResponseListener);
    }

    /**
     * 异步Post请求
     *
     * @param url                请求地址
     * @param pathParams         请求参数
     * @param params             请求参数实体类
     * @param onResponseListener 请求回调接口
     */
    public static <T, P> void httpPost(String url, Map<String, Object> pathParams, P params, final OnResponseListener<T> onResponseListener) {
        httpPost(url, pathParams, params, null, onResponseListener);
    }

    /**
     * 异步Post请求
     *
     * @param url                请求地址
     * @param pathParams         请求参数
     * @param headers            请求头
     * @param params             请求参数实体类
     * @param onResponseListener 请求回调接口
     */
    public static <T, P> void httpPost(String url, Map<String, Object> pathParams, P params, final Map<String, String> headers, final OnResponseListener<T> onResponseListener) {
        if (params == null)
            return;
        try {
            if (pathParams != null)
                url = getParamsUrl(url, pathParams);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(new Gson().toJson(params)),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            if (onResponseListener != null) {
                                onResponseListener.onResponse((BaseResponse<T>) new Gson().fromJson(response.toString(), new TypeToken<BaseResponse<T>>() {
                                }.getType()));
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (onResponseListener != null) {
                        onResponseListener.onError();
                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    if (headers == null)
                        return super.getHeaders();
                    else
                        return headers;
                }
            };
            mRequestQueue.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("onErrorResponse", "Params is error.");
        }
    }

    /**
     * 获取带参数的Url地址
     *
     * @param url    原地址
     * @param params 参数
     * @return 带参数的Url地址
     */
    private static String getParamsUrl(String url, Map<String, Object> params) {
        String sbParams = "?";
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            sbParams += "&" + entry.getKey() + "=" + entry.getValue();
        }
        return url + sbParams.replaceFirst("&", "");
    }

}
