package com.jimmy.friend.main;

import com.jimmy.common.base.mvp.IBaseView;
import com.jimmy.friend.bean.Commodity;

import java.util.List;

/**
 * Created by Jimmy on 2016/8/27 0027.
 */
public interface IMainView extends IBaseView {
    void showLoading();
    void hideLoading();
    void initCommodityList(List<Commodity> commodities);
    void netError();
    void dataIsNull();
    void intoCommodityDetail(Commodity commodity);
}
