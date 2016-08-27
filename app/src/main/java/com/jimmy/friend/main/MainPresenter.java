package com.jimmy.friend.main;

import com.jimmy.common.base.mvp.BasePresenter;
import com.jimmy.friend.bean.Commodity;

import java.util.List;

/**
 * Created by Jimmy on 2016/8/27 0027.
 */
public class MainPresenter extends BasePresenter<IMainView, IMainModel> {

    public MainPresenter(IMainView view) {
        super(view);
        mModel = new MainModel();
    }

    public void loadCommodities() {
        mView.showLoading();
        mModel.loadCommodities(new OnLoadCommodityListener() {
            @Override
            public void onFinished(List<Commodity> data) {
                mView.initCommodityList(data);
                mView.hideLoading();
            }

            @Override
            public void onFailed() {
                mView.netError();
                mView.hideLoading();
            }

            @Override
            public void onDataIsNull() {
                mView.dataIsNull();
                mView.hideLoading();
            }
        });
    }

    public void intoCommodityDetail(Commodity commodity) {
        mView.intoCommodityDetail(commodity);
    }

}
