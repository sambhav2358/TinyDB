package com.sambhav2358.tinydb;

import android.content.Context;
import android.content.SharedPreferences;

public class TinyDBDatabaseHelper {

    private static TinyDefaultDB tinyDefaultDB;
    private static TinyCustomDB tinyCustomDB;
    private static SharedPreferences sharedPreferences;

    public TinyDefaultDB getDefaultDatabase(Context context){
        if (context == null) {
            throw new NullPointerException("The context cannot be null");
        }
        if (sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("TinyDBData",Context.MODE_PRIVATE );
        }
        if (tinyDefaultDB == null){
            tinyDefaultDB = new TinyDefaultDB(context, sharedPreferences);
        }

        return tinyDefaultDB;
    }

    public TinyCustomDB getCustomDatabase(Context context, String dbName){
        if (context == null || dbName == null || dbName.trim().isEmpty()) {
            throw new NullPointerException("The context or dbName cannot be null or empty");
        }
        if (sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("TinyDBData",Context.MODE_PRIVATE );
        }
        if (tinyCustomDB == null){
            tinyCustomDB = new TinyCustomDB(context, sharedPreferences, dbName);
        }

        return tinyCustomDB;
    }
}
