package com.example.buttonedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
        Button의 클릭 이벤트 리스너에서 EditText에 입력된 텍스트를 읽어 Toast라는 짧은 메세지로 출력
        결과적으로 화면 아래쪽에 임시적인 팝업이 열리고 팝업 안에 Toast가 나타남
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText edit = (EditText)findViewById(R.id.edit);
                String str = edit.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}