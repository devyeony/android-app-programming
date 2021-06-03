package com.example.attributechange;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SetGravityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_gravity);

        findViewById(R.id.buttonid).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                LinearLayout layout = (LinearLayout) findViewById(R.id.layoutid);
                layout.setGravity(Gravity.CENTER);
            }
        });
    }
}