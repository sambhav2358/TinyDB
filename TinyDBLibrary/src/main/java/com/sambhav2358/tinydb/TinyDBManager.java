package com.sambhav2358.tinydb;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import io.paperdb.Paper;

public class TinyDBManager {

    private final SharedPreferences sharedPreferences;
    ValueChangeListener valueChangeListener;

    public TinyDBManager(Context context, SharedPreferences prefs) {
        this.sharedPreferences = prefs;
        Paper.init(context);
    }

    public void putString(String key, String value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value);
        sharedPreferences.edit().putString(key,value).apply();
    }

    public void putInt(String key, int value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value);
        sharedPreferences.edit().putInt(key,value).apply();
    }

    public void putFloat(String key, float value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value);
        sharedPreferences.edit().putFloat(key,value).apply();
    }

    public void putBoolean(String key, boolean value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value);
        sharedPreferences.edit().putBoolean(key,value).apply();
    }

    public <E> void putList(String key, List<E> value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value);
        Paper.book().write(key,value);
    }

    public <E> void put(String key, E value){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onValueAdded(key,value);
        Paper.book().write(key,value);
    }

    public String getString(String key, String defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getString(key,defValue);
    }

    public int getInt(String key, int defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getInt(key,defValue);
    }

    public float getFloat(String key, float defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getFloat(key,defValue);
    }

    public boolean getBoolean(String key, boolean defValue){
        if (isNull(key)) throw new NullPointerException();
        return sharedPreferences.getBoolean(key,defValue);
    }

    public <E> List<E> getList(String key, List<E> defValue){
        if (isNull(key)) throw new NullPointerException();
        return Paper.book().read(key);
    }

    public <E> List<E> get(String key, E defValue){
        if (isNull(key)) throw new NullPointerException();
        return Paper.book().read(key);
    }

    public void clearAll(){
        sharedPreferences.edit().clear().apply();
        if (!isNull(valueChangeListener)) valueChangeListener.onAllKeysRemoved();
        Paper.book().destroy();
    }

    public void clearKey(String key){
        if (isNull(key)) throw new NullPointerException();
        if (!isNull(valueChangeListener)) valueChangeListener.onKeyRemoved(key);
        sharedPreferences.edit().remove(key).apply();
        Paper.book().delete(key);
    }

    private <E> boolean isNull(E value){ return value == null; }

    public void setValueChangeListener(ValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }

    public interface ValueChangeListener{
        <E> void onValueAdded(String key, E value);
        void onKeyRemoved(String key);
        void onAllKeysRemoved();
    }
}
