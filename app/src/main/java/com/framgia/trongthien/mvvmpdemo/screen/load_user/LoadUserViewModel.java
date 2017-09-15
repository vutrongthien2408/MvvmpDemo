package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.framgia.trongthien.mvvmpdemo.BR;
import com.framgia.trongthien.mvvmpdemo.data.model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoadUserViewModel extends BaseObservable implements LoadUserContract.ViewModel {
    @Bindable
    private ObservableField<UserAdapter> userAdapter = new ObservableField<>();
    @Bindable
    private LinearLayoutManager linearLayoutManager;
    private LoadUserContract.Presenter presenter;

    public LoadUserViewModel(UserAdapter userAdapter, Context context) {

        Observable.just(userAdapter)
                .subscribe(setAdapter -> {
                    this.userAdapter.set(userAdapter);
                });
        linearLayoutManager = new LinearLayoutManager(context);
    }

    public ObservableField<UserAdapter> getUserAdapter() {
        return userAdapter;
    }

    public void setUserAdapter(ObservableField<UserAdapter> userAdapter) {

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
        userAdapter.get().loadListUser(users);
    }
}
