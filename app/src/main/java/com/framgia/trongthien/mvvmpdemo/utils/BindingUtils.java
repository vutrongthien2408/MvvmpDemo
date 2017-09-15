package com.framgia.trongthien.mvvmpdemo.utils;


import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class BindingUtils {
    private BindingUtils() {
    }

    @BindingAdapter("setLayout")
    public static void setLayout(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @BindingAdapter({"bind:recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
