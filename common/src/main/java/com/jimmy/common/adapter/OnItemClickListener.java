package com.jimmy.common.adapter;

import android.view.View;

/**
 * OnItemClickListener for RecyclerView.
 * <p>
 * Created by Cheney on 16/1/13.
 */
public interface OnItemClickListener<T> {
    void onItemClick(T data, View itemView, int viewType, int position);
}
