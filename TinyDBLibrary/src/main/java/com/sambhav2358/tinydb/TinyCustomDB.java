package com.sambhav2358.tinydb;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import io.paperdb.Paper;

public class TinyCustomDB {

    private final SharedPreferences sharedPreferences;
    ValueChangeListener valueChangeListener;
    String dbName;

    public TinyCustomDB(Context context, SharedPreferences sharedPreferences, String dbName) {
        this.sharedPreferences = sharedPreferences;
        this.dbName = dbName;
        Paper.init(context);
    }

    public void putString(String key, String value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value,dbName);
        sharedPreferences.edit().putString(dbName+key,value).apply();
    }

    public void putInt(String key, int value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value,dbName);
        sharedPreferences.edit().putInt(dbName+key,value).apply();
    }

    public void putFloat(String key, float value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value,dbName);
        sharedPreferences.edit().putFloat(dbName+key,value).apply();
    }

    public void putBoolean(String key, boolean value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value,dbName);
        sharedPreferences.edit().putBoolean(dbName+key,value).apply();
    }

    public <E> void putList(String key, List<E> value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value,dbName);
        Paper.book().write(dbName+key,value);
    }

    public <E> void put(String key, E value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value,dbName);
        Paper.book().write(dbName+key,value);
    }

    public String getString(String key, String defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getString(dbName+key,defValue);
    }

    public int getInt(String key, int defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getInt(dbName+key,defValue);
    }

    public float getFloat(String key, float defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getFloat(dbName+key,defValue);
    }

    public boolean getBoolean(String key, boolean defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getBoolean(dbName+key,defValue);
    }

    public <E> E getList(String key){
        if (isNull(key)) throw new NullPointerException();
        return Paper.book().read(dbName+key);
    }

    public <E> E get(String key){
        if (isNull(key)) throw new NullPointerException();
        return Paper.book().read(dbName+key);
    }

    public void clearAll(){
        sharedPreferences.edit().clear().apply();
        if (!isNull(valueChangeListener)) valueChangeListener.onAllKeysRemoved(dbName);
        for (String key: Paper.book().getAllKeys()) {
            if (key.startsWith(dbName)) Paper.book().delete(key);
        }
    }

    public void clearKey(String key){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onKeyRemoved(key, dbName);
        sharedPreferences.edit().remove(dbName+key).apply();
        Paper.book().delete(key);
    }

    private <E> boolean isNull(E value){ return value == null; }

    public void setValueChangeListener(ValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }
}
