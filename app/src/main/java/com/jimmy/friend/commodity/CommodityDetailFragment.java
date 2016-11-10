package com.jimmy.friend.commodity;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jimmy.common.base.app.BaseFragment;
import com.jimmy.common.base.app.TemplateFragment;
import com.jimmy.friend.R;
import com.jimmy.friend.bean.Commodity;

/**
 * Created by Jimmy on 2016/8/27 0027.
 */
public class CommodityDetailFragment extends TemplateFragment {

    public static final String COMMODITY = "commodity.object";

    @Nullable
    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_commodity_detail, container, false);
    }

    @Override
    protected void bindData() {
        super.bindData();
        if (getArguments() != null) {
            Commodity commodity = (Commodity) getArguments().getSerializable(COMMODITY);
            if (commodity != null) {
                Glide.with(mActivity).load(commodity.getUrl()).into((ImageView) searchViewById(R.id.ivCommodityDetailImage));
                TextView tvCommodityDetailDesc = searchViewById(R.id.tvCommodityDetailDesc);
                tvCommodityDetailDesc.setText(commodity.getDesc());
            }
        }
    }
}
