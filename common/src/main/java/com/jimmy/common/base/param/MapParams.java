package com.jimmy.common.base.param;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class MapParams implements Serializable{

    private Map<String, Object> mParams;

    public Map<String, Object> getParams() {
        return mParams;
    }

    public void setParams(Map<String, Object> params) {
        this.mParams = params;
    }
}
