package com.framgia.trongthien.mvvmpdemo.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class UserDataContract {
    public UserDataContract() {
    }

    public class UserEntry implements BaseColumns {
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PHONE_NUMBER = "phoneNumber";
        public static final String COLUMN_ADDRESS = "address";
        public static final String TABLE_NAME = "tbl_user";
    }
}
