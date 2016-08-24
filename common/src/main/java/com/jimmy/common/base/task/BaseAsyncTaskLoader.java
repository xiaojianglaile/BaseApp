package com.jimmy.common.base.task;

import android.support.v4.content.AsyncTaskLoader;

import com.jimmy.common.base.app.BaseActivity;

/**
 * Created by Jimmy on 2016/5/23 0023.
 */
public abstract class BaseAsyncTaskLoader<T> extends AsyncTaskLoader<T> {

    private T mData;
    protected BaseActivity mBaseActivity;

    public BaseAsyncTaskLoader(BaseActivity baseActivity) {
        super(baseActivity);
        this.mBaseActivity = baseActivity;
    }

    public abstract T loadInBackground();

    public void deliverResult(T data) {
        if (isReset()) {
            if (data != null) {
                onReleaseResources(data);
            }
        }
        T oldData = data;
        if (isStarted()) {
            super.deliverResult(data);
        }
        if (oldData != null) {
            onReleaseResources(oldData);
        }
    }

    protected void onStartLoading() {
        if (mData != null) {
            deliverResult(mData);
        }
        if (takeContentChanged() || mData == null) {
            forceLoad();
        }
    }

    protected void onStopLoading() {
        cancelLoad();
    }

    public void onCanceled(T data) {
        super.onCanceled(data);
        onReleaseResources(data);
    }

    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (mData != null) {
            onReleaseResources(mData);
            mData = null;
        }
    }

    protected void onReleaseResources(T data) {
    }

}
