package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        다이얼패드로 연결되는 ACTION_DIAL 액션을 가진 인텐트를 선언한 뒤,
        EditText에 입력된 전화번호를 인텐트의 Data로 지정함
        그 후 startActivity 함수를 사용해 Action(ACTION_DIAL)과 Data(전화번호)를
        이용한 암시적 인텐트로 관련 액티비티인 다이얼패드 연결 액티비티를 호출함
     */
    public void mOnClick(View v) {
        EditText telText = (EditText) findViewById(R.id.telText);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + telText.getText()));
        startActivity(intent);
    }
}