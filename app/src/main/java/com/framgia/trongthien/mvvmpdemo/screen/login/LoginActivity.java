package com.framgia.trongthien.mvvmpdemo.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.framgia.trongthien.mvvmpdemo.R;
import com.framgia.trongthien.mvvmpdemo.data.source.UserRepository;
import com.framgia.trongthien.mvvmpdemo.data.source.local.UserLocalDataSource;
import com.framgia.trongthien.mvvmpdemo.databinding.LoginActivityBinding;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginActivityBinding loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.login_activity);

        LoginViewModel loginViewModel = new LoginViewModel(this);
        LoginContract.Presenter presenter = new LoginPresenter(loginViewModel,
                UserRepository.getInstance(UserLocalDataSource.getInstance(this)));
        loginViewModel.setPresenter(presenter);
        loginActivityBinding.setLoginViewModel(loginViewModel);
    }
}
