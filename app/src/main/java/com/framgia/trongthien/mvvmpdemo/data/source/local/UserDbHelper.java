package com.framgia.trongthien.mvvmpdemo.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class UserDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "user.db";
    public static final int DATABASE_VERSION = 1;
    public static final String SQL_CREATE_DATABASE = "CREATE TABLE "
            + UserDataContract.UserEntry.TABLE_NAME
            + " ( "
            + UserDataContract.UserEntry.COLUMN_USERNAME
            + " TEXT, "
            + UserDataContract.UserEntry.COLUMN_PHONE_NUMBER
            + " TEXT, "
            + UserDataContract.UserEntry.COLUMN_ADDRESS
            + " TEXT )";
    private static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + UserDataContract.UserEntry.TABLE_NAME;

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_USER);
        sqLiteDatabase.execSQL(SQL_CREATE_DATABASE);
    }
}
