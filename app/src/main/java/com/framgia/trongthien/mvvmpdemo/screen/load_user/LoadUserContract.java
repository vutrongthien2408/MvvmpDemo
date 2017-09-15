package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import com.framgia.trongthien.mvvmpdemo.data.model.User;

import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public interface LoadUserContract {
    interface Presenter {
        List<User> loadAllUser();
    }

    interface ViewModel {
        void showAllUser(List<User> users);
    }
}
