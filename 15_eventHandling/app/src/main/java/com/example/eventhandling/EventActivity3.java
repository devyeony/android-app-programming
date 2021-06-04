package com.example.eventhandling;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
    액티비티를 통한 Listener의 구현으로 이벤트 처리
    - 인터페이스의 구현 클래스를 따로 선언해도 되지만 기존에 존재하는 클래스의 인터페이스로 구현 가능
    - EventActivity2의 TouchListenerClass는 인터페이스를 구현하는 역할만 할 뿐
      그 외에는 아무런 기능을 자지지 않음
    - 최소한 액티비티 하나는 존재하므로 액티비티가 리스너 인터페이스를 구현하는 것이 가능
    - 상속과 달리 인터페이스는 개수에 상관없이 얼마든지 구현 가능

    한계
    - 리스너 인터페이스가 구현된 View는 액티비티에 강하게 종속됨
    - 리스너 인터페이스가 구현된 View를 다른 액티비티에 재사용하려면
      액티비티가 구현하는 리스너를 분리하여 다른 액티비티로 옮겨야 함
    - View와 관련된 메서드가 View 자신에게 포함되어 있지 않고
      부모가 구현을 해주기 때문에 독립성이 떨어짐
 */
public class EventActivity3 extends AppCompatActivity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vw = new View(this);
        vw.setOnTouchListener(this);
        setContentView(vw);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(this, "Touch Event Received", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
