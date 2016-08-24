package com.jimmy.common.base.mvp;

/**
 * Created by Jimmy on 2016/8/23 0023.
 */
public class BasePresenter<V extends IBaseView, M extends IBaseModel> {

    protected V mView;
    protected M mModel;

    public BasePresenter(V view) {
        mView = view;
    }

}
