package com.framgia.trongthien.mvvmpdemo.screen.login;

import com.framgia.trongthien.mvvmpdemo.data.source.UserRepository;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.ViewModel viewModel;
    private UserRepository userRepository;

    public LoginPresenter(LoginContract.ViewModel viewModel, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.viewModel = viewModel;
    }

    @Override
    public void checkLogin(String name) {
        if (userRepository.findUserByName(name)) {
            viewModel.loginSuccess();
        } else {
            viewModel.loginFail();
        }
    }
}
