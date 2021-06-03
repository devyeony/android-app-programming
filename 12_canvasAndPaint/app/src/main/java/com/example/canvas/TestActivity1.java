package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.canvas.customView.TestView1;

public class TestActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestView1 tv = new TestView1(this);
        setContentView(tv); //xml 뿐만 아니라 Java 코드로도 화면을 그릴 수 있음
    }
}