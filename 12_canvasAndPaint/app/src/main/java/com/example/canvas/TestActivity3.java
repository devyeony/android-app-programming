package com.example.canvas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.canvas.customView.TestView3;

public class TestActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestView3 tv = new TestView3(this);
        setContentView(tv);
    }
}
