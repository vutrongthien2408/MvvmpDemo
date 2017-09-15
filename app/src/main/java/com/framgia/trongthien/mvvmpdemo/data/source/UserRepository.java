package com.framgia.trongthien.mvvmpdemo.data.source;

import com.framgia.trongthien.mvvmpdemo.data.model.User;
import com.framgia.trongthien.mvvmpdemo.data.source.local.UserLocalDataSource;

import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class UserRepository implements UserDataSource {
    private UserLocalDataSource userLocalDataSource;
    private static UserRepository userRepository;

    private UserRepository(UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    public static UserRepository getInstance(UserLocalDataSource userLocalDataSource) {
        if (userRepository == null) {
            userRepository = new UserRepository(userLocalDataSource);
        }
        return userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userLocalDataSource.getAllUser();
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void saveUser() {

    }

    @Override
    public boolean insert(User user) {
        return userLocalDataSource.insert(user);
    }

    @Override
    public boolean findUserByName(String name) {
        return userLocalDataSource.findUserByName(name);
    }
}
