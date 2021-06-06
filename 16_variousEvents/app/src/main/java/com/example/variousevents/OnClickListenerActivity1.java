package com.example.variousevents;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
    익명 클래스의 임시 객체를 생성하여
    View.OnClickListener를 구현하고, onClick(View v) 메서드 작성
 */
public class OnClickListenerActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_listener);
        Button btnGood = (Button)findViewById(R.id.good);
        Button btnBad = (Button)findViewById(R.id.bad);
        btnGood.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textPoll = (TextView)findViewById(R.id.question);
                textPoll.setText("Good!!^^");
            }
        });
        btnBad.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView textPoll = (TextView)findViewById(R.id.question);
                textPoll.setText("Bad!!ㅠㅠ");
            }
        });
    }
}
