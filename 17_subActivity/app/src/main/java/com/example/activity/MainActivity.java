package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
    액티비티를 호출할 때는 startActivity 메서드를 사용하며
    호출할 대상을 지정하는 Intent 객체는 startActivity의 인수로 전달됨.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v) {
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}