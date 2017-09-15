package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.framgia.trongthien.mvvmpdemo.R;
import com.framgia.trongthien.mvvmpdemo.data.model.User;
import com.framgia.trongthien.mvvmpdemo.data.source.UserRepository;
import com.framgia.trongthien.mvvmpdemo.data.source.local.UserLocalDataSource;
import com.framgia.trongthien.mvvmpdemo.databinding.LoadUserActivityBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoadUserActivity extends AppCompatActivity {
    private UserAdapter userAdapter;
    private LoadUserViewModel userViewModel;
    private LoadUserActivityBinding userBinding;
    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();
    }

    private void initBinding() {
        userBinding = DataBindingUtil.setContentView(this, R.layout.load_user_activity);
        userAdapter = new UserAdapter(users);
        userViewModel = new LoadUserViewModel(userAdapter, this);
        LoadUserContract.Presenter presenter = new LoadUserPresenter(userViewModel,
                UserRepository.getInstance(UserLocalDataSource.getInstance(this)));
        userViewModel.setPresenter(presenter);
        userBinding.setUserViewModel(userViewModel);
    }
}
