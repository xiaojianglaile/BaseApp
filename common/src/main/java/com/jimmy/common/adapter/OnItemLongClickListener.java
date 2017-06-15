package com.jimmy.common.adapter;

import android.view.View;

/**
 * OnItemLongClickListener for RecyclerView.
 * <p>
 * Created by Cheney on 16/2/24.
 */
public interface OnItemLongClickListener<T> {
    void onItemLongClick(T data, View itemView, int viewType, int position);
}
