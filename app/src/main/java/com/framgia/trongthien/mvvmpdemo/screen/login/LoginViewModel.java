package com.framgia.trongthien.mvvmpdemo.screen.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.framgia.trongthien.mvvmpdemo.screen.load_user.LoadUserActivity;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoginViewModel extends BaseObservable implements LoginContract.ViewModel {

    private LoginContract.Presenter presenter;
    private Context context;
    private ObservableField<String> username = new ObservableField<>();

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public LoginContract.Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public ObservableField<String> getUsername() {
        return username;
    }

    public void setUsername(ObservableField<String> username) {
        rx.Observable.just(username)
                .subscribe(setName -> {
                    this.username = username;
                });
    }

    public void onBtnOkClick(View view) {
        presenter.checkLogin(username.get());
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, LoadUserActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    public void loginFail() {
        Toast.makeText(context, "Login fail", Toast.LENGTH_SHORT).show();
    }
}
