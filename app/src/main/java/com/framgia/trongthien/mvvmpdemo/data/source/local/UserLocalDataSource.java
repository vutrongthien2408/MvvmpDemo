package com.framgia.trongthien.mvvmpdemo.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.framgia.trongthien.mvvmpdemo.data.model.User;
import com.framgia.trongthien.mvvmpdemo.data.source.UserDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class UserLocalDataSource implements UserDataSource {
    private UserDbHelper userDbHelper;
    private static UserLocalDataSource userLocalDataSource;

    private UserLocalDataSource(@NonNull Context context) {
        userDbHelper = new UserDbHelper(context);
    }

    public static UserLocalDataSource getInstance(@NonNull Context context) {
        if (userLocalDataSource == null) {
            userLocalDataSource = new UserLocalDataSource(context);
        }
        return userLocalDataSource;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        SQLiteDatabase db = userDbHelper.getWritableDatabase();
        Cursor cursor = db.query(UserDataContract.UserEntry.TABLE_NAME, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = new User(cursor);
            users.add(user);
            cursor.moveToNext();
        }
        db.close();
        return users;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void saveUser() {

    }

    @Override
    public boolean insert(User user) {
        SQLiteDatabase db = userDbHelper.getWritableDatabase();
        long result = db.insert(UserDataContract.UserEntry.TABLE_NAME, null, user.getValues());
        db.close();
        return result != -1;
    }

    @Override
    public boolean findUserByName(String name) {
        SQLiteDatabase db = userDbHelper.getWritableDatabase();
        String[] columns = {UserDataContract.UserEntry.COLUMN_USERNAME,};
        String selection = UserDataContract.UserEntry.COLUMN_USERNAME + " LIKE ? ";
        String[] selectionArgs = {name};
        Cursor cursor = db.query(UserDataContract.UserEntry.TABLE_NAME, columns, selection,
                selectionArgs, null, null, null);

        if (cursor.getCount() > 0 && cursor != null) {
            return true;
        } else {
            return false;
        }
    }
}
