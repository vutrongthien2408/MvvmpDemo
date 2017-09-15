package com.framgia.trongthien.mvvmpdemo.screen.login;

import android.util.Log;

import com.framgia.trongthien.mvvmpdemo.data.model.User;
import com.framgia.trongthien.mvvmpdemo.data.source.UserRepository;
import com.framgia.trongthien.mvvmpdemo.screen.load_user.LoadUserContract;

import java.util.ArrayList;
import java.util.List;

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
