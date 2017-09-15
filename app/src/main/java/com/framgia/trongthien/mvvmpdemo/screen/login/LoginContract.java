package com.framgia.trongthien.mvvmpdemo.screen.login;

/**
 * Created by TrongThien on 9/15/2017.
 */

public interface LoginContract {
    interface Presenter {
        void checkLogin(String name);
    }

    interface ViewModel {
        void loginSuccess();

        void loginFail();
    }
}
