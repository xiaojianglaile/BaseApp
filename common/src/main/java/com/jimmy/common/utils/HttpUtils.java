package com.jimmy.common.utils;

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
import com.jimmy.common.base.BaseResponse;
import com.jimmy.common.listener.OnResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
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
        try {
            RequestFuture future = RequestFuture.newFuture();
            Gson gson = new Gson();
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, future, future);
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
     * @param <T>
     * @param <BT>
     * @return 返回数据实体类
     */
    public static <T, BT> BaseResponse<T> syncHttpPost(String url, BT params) {
        try {
            RequestFuture future = RequestFuture.newFuture();
            Gson gson = new Gson();
            if (params != null) {
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(gson.toJson(params)), future, future);
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
    public static <T> void httpGet(String url, final OnResponseListener<T> onResponseListener) {
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
                Log.e("onErrorResponse", "VolleyError.");
            }
        });
        mRequestQueue.add(request);
    }

    /**
     * 异步Post请求
     *
     * @param url                请求地址
     * @param params             请求参数
     * @param onResponseListener 请求回调接口
     * @param <T>
     * @param <BT>
     */
    public static <T, BT> void httpPost(String url, BT params, final OnResponseListener<T> onResponseListener) {
        if (params == null)
            return;
        try {
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
                    Log.e("onErrorResponse", "VolleyError.");
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };
            mRequestQueue.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("onErrorResponse", "Params is error.");
        }
    }


}
