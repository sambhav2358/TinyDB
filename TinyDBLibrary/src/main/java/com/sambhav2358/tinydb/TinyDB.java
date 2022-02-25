package com.sambhav2358.tinydb;

import android.content.Context;
import android.content.SharedPreferences;

public class TinyDB {

    private static TinyDBManager tinyDBManager;

    public static TinyDBManager getInstance(Context context){
        SharedPreferences prefs = context.getSharedPreferences("TinyDBData",Context.MODE_PRIVATE );
        if (tinyDBManager == null)
            tinyDBManager = new TinyDBManager(context,prefs);
        return tinyDBManager;
    }
}
