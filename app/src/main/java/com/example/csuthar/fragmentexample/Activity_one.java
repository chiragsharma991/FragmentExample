package com.example.csuthar.fragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity_one extends AppCompatActivity {

    @Override
    protected    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
