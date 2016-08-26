package com.jimmy.friend.fragment;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jimmy.friend.R;
import com.jimmy.friend.base.TemplateFragment;

/**
 * Created by Jimmy on 2016/8/26 0026.
 */
public class GameFragment extends TemplateFragment {

    @Nullable
    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_test, null, false);
    }

    @Override
    protected void bindData() {
        super.bindData();
        TextView tvFragmentName = searchViewById(R.id.tvFragmentName);
        tvFragmentName.setText("GameFragment");
    }
}
