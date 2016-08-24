package com.jimmy.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Jimmy on 2016/8/24 0024.
 */
public class AbsoluteListView extends ListView {

    public AbsoluteListView(Context context) {
        super(context);
        setFocusable(false);
    }

    public AbsoluteListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(false);
    }

    public AbsoluteListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
