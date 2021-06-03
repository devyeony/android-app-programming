package com.example.canvas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.canvas.customView.TestView4;

public class TestActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestView4 tv = new TestView4(this);
        setContentView(tv);
    }
}
