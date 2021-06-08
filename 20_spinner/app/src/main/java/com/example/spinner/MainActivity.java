package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/*
    Spinner 기본 레이아웃
    - simple_spinner_item : 문자열만 나타냄
    - simple_spinner_dropdown_item : 문자열과 라디오 버튼이 같이 나타남
    -
 */
public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adspin;
    boolean mInitSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner)findViewById(R.id.myspinner);
        adspin = ArrayAdapter.createFromResource
                (this, R.array.colors, android.R.layout.simple_spinner_item);

        /*
            setDropDownViewResource 메서드
            - Spinner 자체에 적용할 레이아웃과는 별도로 클릭했을 때 나타나는 팝업의 레이아웃 지정
            - 매개변수로는 simple_spinner_item이나 simple_spinner_dropdown_item 사용
         */
        adspin.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adspin);

        /*
            Prompt 메시지
            - ListView와 달리 선택사항에 대한 Prompt 메시지를 팝업 상단에 표시할 수 있음
            - Prompt 메시지 내용은 리소스의 문자열 ID를 지정하거나 문자열 리터럴을 직접 지정
            - 지정 방식
              void setPromptId(int promptId)
              void setPrompt(CharSequence prompt)
            - XML 문서에서 prompt 속성을 지정할 수도 있으나 XML에서는 리소스만 지정 가능
         */
        spin.setPrompt("색상 선택");
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            /* 항목이 선택될 때 호출됨 */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, adspin.getItem(position), Toast.LENGTH_SHORT).show();
            }

            /* 항목이 선택 해제될 때 호출됨 */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}