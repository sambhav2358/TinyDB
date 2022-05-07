package com.sambhav2358.tinydb;

public interface ValueChangeListener{
    <E> void onValueAdded(String key, E value, String dbName);
    void onKeyRemoved(String key, String dbName);
    void onAllKeysRemoved(String dbName);
}
