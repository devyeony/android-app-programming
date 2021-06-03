package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /*
        버튼 클릭 이벤트에 대한 리스너를 작성하여 ImageView의 보이기 상태를 변경하는 예제
        ImageView의 보이기 상태를 조사한 후 visibility 속성을 바꾸는 기능을 구현
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout_2);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ImageView img = (ImageView)findViewById(R.id.img);
                if(img.getVisibility() == View.VISIBLE){
                    img.setVisibility(View.GONE);
                }else{
                    img.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}