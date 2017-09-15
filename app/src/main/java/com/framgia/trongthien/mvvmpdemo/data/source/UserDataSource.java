package com.framgia.trongthien.mvvmpdemo.data.source;

import com.framgia.trongthien.mvvmpdemo.data.model.User;

import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public interface UserDataSource {
    List<User> getAllUser();

    void deleteUser();

    void saveUser();

    boolean insert(User user);

    boolean findUserByName(String name);
}
