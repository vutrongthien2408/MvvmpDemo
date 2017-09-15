package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.trongthien.mvvmpdemo.data.model.User;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class ItemUserViewModel extends BaseObservable {
    @Bindable
    private String username;
    @Bindable
    private String address;

    private User user;

    public ItemUserViewModel(User user) {
        this.user = user;
        username = user.getUsername();
        address = user.getAddress();
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }
}
