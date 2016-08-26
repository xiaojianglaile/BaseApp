package com.jimmy.friend.base;

import com.jimmy.common.base.app.BaseFragment;
import com.jimmy.common.base.param.MapParams;

import java.util.Map;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public abstract class TemplateFragment extends BaseFragment {

    private Map<String, Object> mParams;

    @Override
    protected void initData() {
        super.initData();
        if (getArguments() != null) {
            MapParams params = (MapParams) getArguments().getSerializable(TemplateActivity.PARAMS);
            if (params != null)
                mParams = params.getParams();
        }
    }

    public Map<String, Object> getParams() {
        return mParams;
    }
}
