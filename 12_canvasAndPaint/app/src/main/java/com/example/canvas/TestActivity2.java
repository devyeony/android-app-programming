package com.example.canvas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.canvas.customView.TestView2;

public class TestActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestView2 tv = new TestView2(this);
        setContentView(tv);
    }
}
