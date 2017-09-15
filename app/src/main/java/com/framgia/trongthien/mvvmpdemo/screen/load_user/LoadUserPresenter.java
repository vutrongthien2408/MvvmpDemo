package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import android.util.Log;

import com.framgia.trongthien.mvvmpdemo.data.model.User;
import com.framgia.trongthien.mvvmpdemo.data.source.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class LoadUserPresenter implements LoadUserContract.Presenter {
    private List<User> users = new ArrayList<>();
    private LoadUserContract.ViewModel viewModel;
    private UserRepository userRepository;

    public LoadUserPresenter(LoadUserContract.ViewModel viewModel, UserRepository userRepository) {
        this.viewModel = viewModel;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> loadAllUser() {
        users.clear();
        users = userRepository.getAllUser();
        viewModel.showAllUser(users);
        return null;
    }
}
