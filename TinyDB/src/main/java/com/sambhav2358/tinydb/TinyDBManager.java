package com.sambhav2358.tinydb;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import io.paperdb.Paper;

public class TinyDBManager {

    private SharedPreferences sharedPreferences;

    public TinyDBManager(Context context, SharedPreferences prefs) {
        this.sharedPreferences = prefs;
        Paper.init(context);
    }

    public void putString(String key, String value){ sharedPreferences.edit().putString(key,value).apply(); }

    public void putInt(String key, int value){ sharedPreferences.edit().putInt(key,value).apply(); }

    public void putFloat(String key, float value){ sharedPreferences.edit().putFloat(key,value).apply(); }

    public void putBoolean(String key, boolean value){ sharedPreferences.edit().putBoolean(key,value).apply(); }

    public <E> void putList(String key, List<E> value){ Paper.book().write(key,value); }

    public <E> void put(String key, E value){ Paper.book().write(key,value); }

    public String getString(String key, String defValue){return sharedPreferences.getString(key,defValue);}

    public int getInt(String key, int defValue){return sharedPreferences.getInt(key,defValue);}

    public float getFloat(String key, float defValue){return sharedPreferences.getFloat(key,defValue);}

    public boolean getBoolean(String key, boolean defValue){return sharedPreferences.getBoolean(key,defValue);}

    public <E> List<E> getList(String key, List<E> defValue){return Paper.book().read(key);}

    public <E> List<E> get(String key, E defValue){return Paper.book().read(key);}

    public void clearAll(){
        sharedPreferences.edit().clear().apply();
        Paper.book().destroy();
    }

    public void clearKey(String key){
        sharedPreferences.edit().remove(key).apply();
        Paper.book().delete(key);
    }
}
