package com.sambhav2358.tinydb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TinyDBManager manger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.sampleTV);
        manger = TinyDB.getInstance(this);
        manger.putInt("abc",new Random().nextInt(10000));
        textView.setText(manger.getInt("abc",1) + "");
    }
}