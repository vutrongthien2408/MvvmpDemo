package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.framgia.trongthien.mvvmpdemo.data.model.User;

import rx.Observable;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class ItemUserViewModel extends BaseObservable {

    private ObservableField<User> user = new ObservableField<>();

    public ItemUserViewModel(User user) {
        Observable.just(user)
                .subscribe(setUser -> {
                    this.user.set(user);
                });
    }

    public String getUsername() {
        return user.get().getUsername();
    }

    public String getAddress() {
        return user.get().getAddress();
    }

}
