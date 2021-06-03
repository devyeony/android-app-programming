package com.example.attributechange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SetTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_text);

        findViewById(R.id.buttonid).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView txt = (TextView) findViewById(R.id.textid);
                txt.setText("Success!!");
                txt.setTextSize(40);
                txt.setTextColor(Color.parseColor("#FF007F"));
                txt.setBackgroundColor(Color.parseColor("#D9E5FF"));
            }
        });
    }
}