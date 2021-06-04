package com.example.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
/*
    이벤트 핸들러
    - 특정 이벤트가 발생하는 것을 대기하다가 이벤트 발생시 정의된 함수를 실행하는 기능 수행

    안드로이드에서 이벤트 처리 방법
    - 콜백 메서드 재정의
    - 리스너 인터페이스의 구현
    - 액티비티를 통한 리스너의 구현
    - 뷰를 통한 리스너의 구현

    콜백 메서드 재정의를 통한 이벤트 처리
    - 이벤트가 발생하는 시점에 실행되는 콜백 메서드를 재정의하는 방식
    - 콜백 메서드 : 특정 이벤트가 발생했을 때 시스템에 의해 자동으로 호출되는 메서드
    - 콜백 메서드 내부에 명령어를 구성하여 이벤트 발생 시점에 명령어가 실행되는 기능 구현
    - 콜백 메서드는 사용자와 상호 작용을 수행하는 주체인 View에 적용되며,
      View 클래스 내부에 존재하는 추상적인 함수를 재정의하여 활용됨
    - 대표적인 콜백 메서드
      1) boolean onTouchEvent(MotionEvent event)
      2) boolean onKeyDown(int keyCode, KeyEvent event)
      3) boolean onKeyUp(int keyCode, KeyEvent event)
      4) boolean onTrackballEvent(MotionEvent event)

    한계
    - 콜백 메서드를 재정의하기 위해서는 반드시 슈퍼 클래스(View)를 상속받아야 함
    - 위젯이 콜백 메서드를 직접 사용하지 못하고 항상 새로운 클래스를 생성해야 함
    - 모든 이벤트에 대한 콜백 메서드가 정의되어 있지 않음
    - 선택 변경, 포커스 이동, 드래그, 진동 센서, 조도 센서 등과 같은 다양한 이벤트들에 대해
      모두 콜백 메서드를 정의해서 제공할 수 없음
    - 확장성 제한 때문에 콜백 메서드를 재정의하는 방법은 자주 사용하는 몇 가지 이벤트에만
      제한적으로 적용할 수 있으며 반드시 상속을 통해 콜백 메서드를 재정의해야 함
 */
public class EventActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vw = new MyView(this);
        setContentView(vw);
    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }
        public boolean onTouchEvent(MotionEvent event){
            super.onTouchEvent(event);
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(EventActivity1.this, "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
}