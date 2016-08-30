package com.jimmy.friend.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jimmy.common.base.app.BaseActivity;
import com.jimmy.common.util.TemplateUtils;
import com.jimmy.common.util.ToastUtils;
import com.jimmy.friend.R;
import com.jimmy.friend.bean.Commodity;
import com.jimmy.friend.commodity.CommodityDetailFragment;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainView {

    private RecyclerView rvMainCommodityList;
    private CommodityAdapter mCommodityAdapter;
    private View vLoading;
    private MainPresenter mMainPresenter;

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_main);
        rvMainCommodityList = searchViewById(R.id.rvMainCommodityList);
        vLoading = searchViewById(R.id.vLoading);
    }

    @Override
    protected void initData() {
        super.initData();
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.loadCommodities();
    }

    @Override
    public void showLoading() {
        vLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        vLoading.setVisibility(View.GONE);
    }

    @Override
    public void initCommodityList(List<Commodity> commodities) {
        mCommodityAdapter = new CommodityAdapter(this, commodities, mMainPresenter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMainCommodityList.setLayoutManager(manager);
        rvMainCommodityList.setItemAnimator(new DefaultItemAnimator());
        rvMainCommodityList.setAdapter(mCommodityAdapter);
    }

    @Override
    public void netError() {
        Toast.makeText(this, "Net Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dataIsNull() {
        ToastUtils.showShortToast(this, "No Data!");
    }

    @Override
    public void intoCommodityDetail(Commodity commodity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CommodityDetailFragment.COMMODITY, commodity);
        TemplateUtils.startTemplate(this, "CommodityDetailFragment", commodity.getTitle(), bundle);
    }
}
