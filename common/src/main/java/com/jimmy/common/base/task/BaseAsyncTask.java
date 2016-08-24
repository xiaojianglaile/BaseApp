package com.jimmy.common.base.task;

import android.os.AsyncTask;

import com.jimmy.common.listener.OnTaskFinishedListener;

/**
 * Created by Jimmy on 2016/8/24 0024.
 */
public abstract class BaseAsyncTask<T> extends AsyncTask<Void, Void, T> {

    private OnTaskFinishedListener<T> mOnTaskFinishedListener;

    public BaseAsyncTask(OnTaskFinishedListener<T> onTaskFinishedListener) {
        mOnTaskFinishedListener = onTaskFinishedListener;
    }

    public abstract T loadInBackground();

    @Override
    protected void onPostExecute(T data) {
        super.onPostExecute(data);
        if (mOnTaskFinishedListener != null) {
            mOnTaskFinishedListener.onTaskFinished(data);
        }
    }
}
