package com.framgia.trongthien.mvvmpdemo.screen.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Toast;

import com.framgia.trongthien.mvvmpdemo.screen.load_user.LoadUserActivity;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoginViewModel extends BaseObservable implements LoginContract.ViewModel {
    private String username;
    private LoginContract.Presenter presenter;
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public LoginContract.Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void onBtnOkClick(View view) {
        presenter.checkLogin(username);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, LoadUserActivity.class));
    }

    @Override
    public void loginFail() {
        Toast.makeText(context, "Login fail", Toast.LENGTH_SHORT).show();
    }
}
