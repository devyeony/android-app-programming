package com.example.attributechange;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SetImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_image);

        findViewById(R.id.buttonid).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ImageView img = (ImageView) findViewById(R.id.imageid);
                img.setColorFilter(Color.BLUE);
            }
        });
    }
}