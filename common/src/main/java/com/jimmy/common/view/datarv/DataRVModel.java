package com.jimmy.common.view.datarv;

import com.jimmy.common.base.net.BaseResponse;
import com.jimmy.common.base.view.IDataBinding;
import com.jimmy.common.listener.OnResponseListener;

import java.util.List;

/**
 * Created by Jimmy on 2017/7/8 0008.
 */
class DataRVModel implements IDataRV.IDataRecyclerModel {

    @Override
    public void loadData(IDataBinding dataBinding, OnResponseListener<BaseResponse<List>> listener) {
        dataBinding.onLoad(listener);
    }

}
