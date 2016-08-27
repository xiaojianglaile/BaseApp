package com.jimmy.friend.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jimmy.friend.R;
import com.jimmy.friend.bean.Commodity;

import java.util.List;

/**
 * Created by Jimmy on 2016/8/27 0027.
 */
public class CommodityAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Commodity> mCommodities;
    private MainPresenter mPresenter;

    public CommodityAdapter(Context context, List<Commodity> commodities, MainPresenter presenter) {
        mContext = context;
        mCommodities = commodities;
        mPresenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommodityHolder(LayoutInflater.from(mContext).inflate(R.layout.item_commodity, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CommodityHolder commodityHolder = (CommodityHolder) holder;
        Glide.with(mContext).load(mCommodities.get(position).getUrl()).into(commodityHolder.ivCommodityImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.intoCommodityDetail(mCommodities.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCommodities.size();
    }

    private class CommodityHolder extends RecyclerView.ViewHolder {

        ImageView ivCommodityImage;

        public CommodityHolder(View itemView) {
            super(itemView);
            ivCommodityImage = (ImageView) itemView.findViewById(R.id.ivCommodityImage);
        }
    }
}
