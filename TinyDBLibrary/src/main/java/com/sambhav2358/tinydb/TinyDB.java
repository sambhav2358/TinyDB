package com.sambhav2358.tinydb;

import android.content.Context;
import android.content.SharedPreferences;

public class TinyDB {

    private static TinyDBDatabaseHelper tinyDBDatabaseHelper;

    public static TinyDBDatabaseHelper getInstance(){
        if (tinyDBDatabaseHelper == null)
            tinyDBDatabaseHelper = new TinyDBDatabaseHelper();
        return tinyDBDatabaseHelper;
    }
}
