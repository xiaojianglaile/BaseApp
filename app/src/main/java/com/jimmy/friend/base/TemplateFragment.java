package com.jimmy.friend.base;

import com.jimmy.common.base.app.BaseFragment;
import com.jimmy.common.base.param.MapParams;
import com.jimmy.friend.activity.TemplateActivity;

import java.util.Map;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public abstract class TemplateFragment extends BaseFragment {

    protected Map<String, Object> mParams;

    @Override
    protected void bindData() {
        super.bindData();
        MapParams params = (MapParams) getArguments().getSerializable(TemplateActivity.PARAMS);
        if (params != null)
            mParams = params.getParams();
    }
}
