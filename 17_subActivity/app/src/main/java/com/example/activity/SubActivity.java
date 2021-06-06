package com.example.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/*
    서브 액티비티 절차
    1) 새로 만들 '서브 액티비티'의 레이아웃을 XML 파일에 정의
    2) 새로 만들 '서브 액티비티'의 실행 코드를 java 파일로 작성
    3) 새로 추가한 '서브 액티비티'를 Manifest 파일에 등록
    4) '메인 액티비티'에서 startActivity 메서드로 '서브 액티비티'를 호출하여 사용
 */
public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void mOnClick(View v) {
        finish();
    }
}