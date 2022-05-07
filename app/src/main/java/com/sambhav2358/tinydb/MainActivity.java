package com.sambhav2358.tinydb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ValueChangeListener{

    TextView textView;
    TinyDefaultDB customDB;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.sampleTV);
        customDB = TinyDB.getInstance().getDefaultDatabase(this);
        customDB.putInt("abc",new Random().nextInt(10000));
        textView.setText(customDB.getInt("abc",1)+ "");
    }

    @Override
    public <E> void onValueAdded(String key, E value, String dbName) {

    }

    @Override
    public void onKeyRemoved(String key, String dbName) {

    }

    @Override
    public void onAllKeysRemoved(String dbName) {

    }
}