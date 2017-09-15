package com.framgia.trongthien.mvvmpdemo.data.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.framgia.trongthien.mvvmpdemo.data.source.local.UserDataContract;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class User {
    private String username;
    private String phoneNumber;
    private String address;

    public User(String username, String phoneNumber, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User(Cursor cursor) {
        username = cursor.getString(cursor.getColumnIndex(UserDataContract.UserEntry.COLUMN_USERNAME));
        phoneNumber = cursor.getString(cursor.getColumnIndex(UserDataContract.UserEntry.COLUMN_PHONE_NUMBER));
        address = cursor.getString(cursor.getColumnIndex(UserDataContract.UserEntry.COLUMN_ADDRESS));
    }

    public ContentValues getValues() {
        ContentValues contentValues = new ContentValues();
        if (username != null) {
            contentValues.put(UserDataContract.UserEntry.COLUMN_USERNAME, username);
        }
        if (phoneNumber != null) {
            contentValues.put(UserDataContract.UserEntry.COLUMN_PHONE_NUMBER, phoneNumber);
        }
        if (address != null) {
            contentValues.put(UserDataContract.UserEntry.COLUMN_ADDRESS, address);
        }
        return contentValues;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
