package com.example.attributechange;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SetOrientationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_orientation);

        findViewById(R.id.buttonid).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                LinearLayout layout = (LinearLayout)findViewById(R.id.layoutid);
                if(layout.getOrientation() == LinearLayout.VERTICAL){
                    layout.setOrientation(LinearLayout.HORIZONTAL);
                }else{
                    layout.setOrientation(LinearLayout.VERTICAL);
                }

            }
        });
    }
}