package com.example.layoutoverlay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    View Page1, Page2, Page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_overlay_2);

        Page1 = findViewById(R.id.page1);
        Page2 = findViewById(R.id.page2);
        Page3 = findViewById(R.id.page3);
        findViewById(R.id.btn1).setOnClickListener(mClickListner);
        findViewById(R.id.btn2).setOnClickListener(mClickListner);
        findViewById(R.id.btn3).setOnClickListener(mClickListner);

    }

    View.OnClickListener mClickListner = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Page1.setVisibility(View.INVISIBLE);
            Page2.setVisibility(View.INVISIBLE);
            Page3.setVisibility(View.INVISIBLE);

            switch(v.getId()){
                case R.id.btn1:
                    Page1.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn2:
                    Page2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn3:
                    Page3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}