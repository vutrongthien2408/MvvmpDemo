package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.framgia.trongthien.mvvmpdemo.BR;
import com.framgia.trongthien.mvvmpdemo.data.model.User;

import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoadUserViewModel extends BaseObservable implements LoadUserContract.ViewModel {
    @Bindable
    private UserAdapter userAdapter;
    @Bindable
    private LinearLayoutManager linearLayoutManager;
    private LoadUserContract.Presenter presenter;

    public LoadUserViewModel(UserAdapter userAdapter, Context context) {
        this.userAdapter = userAdapter;
        linearLayoutManager = new LinearLayoutManager(context);
    }

    public UserAdapter getUserAdapter() {
        return userAdapter;
    }

    public void setUserAdapter(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    public LoadUserContract.Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(LoadUserContract.Presenter presenter) {
        this.presenter = presenter;
        presenter.loadAllUser();
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return linearLayoutManager;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void showAllUser(List<User> users) {
        userAdapter.loadListUser(users);
    }
}
