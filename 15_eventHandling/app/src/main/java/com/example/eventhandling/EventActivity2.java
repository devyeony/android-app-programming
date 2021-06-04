package com.example.eventhandling;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
    Listener 인터페이스의 구현을 통한 이벤트 처리
    - Listener는 특정 이벤트를 처리하는 인터페이스로, 이벤트가 발생하는 시점까지 대기하며,
      이벤트 발생 시 특정 메서드를 실행하는 기능
    - 여러 개의 메서드가 선언된 이벤트 리스너도 존재하며,
      모두 View 클래스의 내부 인터페이스로 선언되어 있음
    - 대표적인 이벤트 리스너
      1) View.OnTouchListener : boolean onTouch (View v, MotionEvent event)
      2) View.OnKeyListener : boolean onKey (View v, int keyCode, KeyEvent event)
      3) View.OnClickListener : void onClick (View v)
      4) View.OnLongClickListener : boolean onLongClick (View v)
      5) View.OnFocusChangeListener : void onFocusChange (View v, boolean hasFocus)

    특징 및 한계
    - 콜백 메서드는 상속을 받아야만 재정의할 수 있는데 비해,
      리스너는 인터페이스일 뿐이므로 임의의 클래스가 구현하여 사용할 수 있음
    - 리스너 인터페이스가 요구하는 onTouch 메서드를 구현하기만 하면 이벤트 핸들러로 등록 가능
    - View를 상속받을 필요 없이 View 객체에도 바로 붙일 수 있으며,
      위젯(Button, TextView 등)에서도 이벤트 처리 가능
    - 그러나 Listener 인터페이스를 구현하기 위해 별도의 클래스를 하나 더 선언해야 함
    - 모든 이벤트에 대해 클래스를 만든다면 소스 코드의 양도 많아지고,
      각 클래스마다 다른 명칭을 부여해야 함
 */
public class EventActivity2 extends AppCompatActivity {

    TouchListenerClass TouchListener = new TouchListenerClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vw = new View(this);
        vw.setOnTouchListener(TouchListener);
        setContentView(vw);
    }

    class TouchListenerClass implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(EventActivity2.this, "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
}