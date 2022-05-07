package com.sambhav2358.tinydb;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;
import java.util.Map;

import io.paperdb.Paper;

public class TinyDefaultDB {

    private final SharedPreferences sharedPreferences;
    private ValueChangeListener valueChangeListener;
    public static String defaultDbName = "6vbwoc7ebvehe8f3"; // it has meaning!

    public TinyDefaultDB(Context context, SharedPreferences prefs) {
        this.sharedPreferences = prefs;
        Paper.init(context);
    }

    public void putString(String key, String value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value, defaultDbName);
        sharedPreferences.edit().putString(defaultDbName+key,value).apply();
    }

    public void putInt(String key, int value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value, defaultDbName);
        sharedPreferences.edit().putInt(defaultDbName+key,value).apply();
    }

    public void putFloat(String key, float value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value, defaultDbName);
        sharedPreferences.edit().putFloat(defaultDbName+key,value).apply();
    }

    public void putBoolean(String key, boolean value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value, defaultDbName);
        sharedPreferences.edit().putBoolean(defaultDbName+key,value).apply();
    }

    public <E> void putList(String key, List<E> value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value, defaultDbName);
        Paper.book().write(defaultDbName+key,value);
    }

    public <E> void put(String key, E value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value, defaultDbName);
        Paper.book().write(defaultDbName+key,value);
    }

    public String getString(String key, String defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getString(defaultDbName+key,defValue);
    }

    public int getInt(String key, int defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getInt(defaultDbName+key,defValue);
    }

    public float getFloat(String key, float defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getFloat(defaultDbName+key,defValue);
    }

    public boolean getBoolean(String key, boolean defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getBoolean(defaultDbName+key,defValue);
    }

    public <E> E getList(String key, List<E> defValue){
        if (isNull(key)) throw new NullPointerException();
        return Paper.book().read(defaultDbName+key);
    }

    public <E> E get(String key, E defValue){
        if (isNull(key)) throw new NullPointerException();
        return Paper.book().read(defaultDbName+key);
    }

    public void clearAll(){
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if (entry.getKey().startsWith(defaultDbName)){
                sharedPreferences.edit().remove(entry.getKey()).apply();
            }
        }
        if (!isNull(valueChangeListener)) valueChangeListener.onAllKeysRemoved(defaultDbName);
        Paper.book().destroy();
    }

    public void clearKey(String key){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onKeyRemoved(key, defaultDbName);
        sharedPreferences.edit().remove(key).apply();
        Paper.book().delete(key);
    }

    private <E> boolean isNull(E value){ return value == null; }

    public void setValueChangeListener(ValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }

    public ValueChangeListener getValueChangeListener() {
        return valueChangeListener;
    }

    public static String getDefaultDbName(){
        return defaultDbName;
    }
}
