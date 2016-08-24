package com.jimmy.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by Jimmy on 2016/8/24 0024.
 */
public class AbsoluteGridView extends GridView {

    public AbsoluteGridView(Context context) {
        super(context);
        setFocusable(false);
    }

    public AbsoluteGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(false);
    }

    public AbsoluteGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
