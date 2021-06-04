package com.example.eventhandling;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
    뷰를 통한 리스너의 구현으로 이벤트 처리
    - View 클래스를 선언하는 부분에서 필요한 리스너 인터페이스를 구현

    특징
    - 이벤트 처리를 위해 필요한 onTouch 메서드(이벤트 핸들러)를
      이벤트가 발생한 View가 스스로 처리하는 셈
    - 이벤트를 처리하는 메서드를 내부에 포함하기 때문에 구조상 깔끔하고
      View의 재사용에도 유리함
    - 액티비티의 부담도 줄어들고 코드의 가독성도 향상됨
 */
public class EventActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        vw.setOnTouchListener(vw);
        setContentView(vw);
    }

    class MyView extends View implements View.OnTouchListener {

        public MyView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(EventActivity4.this, "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
}
