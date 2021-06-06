package com.example.variousevents;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
    액티비티가 OnClickListener 인터페이스를 직접 구현
    리스너는 액티비티 자신인 this가 됨
 */
public class OnClickListenerActivity2 extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_listener);
        Button btnGood = (Button)findViewById(R.id.good);
        Button btnBad = (Button)findViewById(R.id.bad);
        btnGood.setOnClickListener(this);
        btnBad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textPoll = (TextView)findViewById(R.id.question);
        switch (v.getId()){
            case R.id.good:
                textPoll.setText("Good!!^^");
                break;
            case R.id.bad:
                textPoll.setText("Bad!!ㅠㅠ");
                break;
        }
    }
}
