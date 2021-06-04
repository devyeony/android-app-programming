package com.example.eventhandling;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

/*
    핸들러의 우선순위
    - 다양한 이벤트 처리 기법들이 하나의 뷰에 중복되어 저장된 경우,
      사전에 지정한 우선순위에 따라 핸들러의 호출되는 순서가 결정됨
 */
public class PriorityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vw = new MyView(this);

        /*
            - 리스너에서 true를 반환하면 이벤트가 완전히 처리된 사실을 나타내므로
              더 이상 이벤트를 추가적으로 전달할 필요가 없어 이벤트가 종료됨
            - false를 반환하면 이벤트가 아직 완벽하게 처리되지 못했다는 사실을 나타내므로
              다음 순위의 이벤트 핸들러 메서드가 호출됨
         */
        vw.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Toast.makeText(PriorityActivity.this, "No.1 Listener: Touch Event Received", Toast.LENGTH_SHORT).show();
                    return true; //이 부분을 주석 처리하면, 리스너의 Toast가 먼저 호출된 후 View의 onTouchEvent 콜백 메서드도 호출됨
                }
                return false;
            }
        });
        setContentView(vw);
    }

    /*
        View와 액티비티의 onTouchEvent 콜백 메서드 비교
        - 동일한 이벤트에 대해 호출되지만 다른 의미의 인수임
        - View의 onTouchEvent(MotionEvent event) :
            View의 터치를 처리하므로 event 인수는 View의 좌상단을 기준으로 한 좌표
        - 액티비티의 onTouchEvent(MotionEvent event) :
            액티비티에 속한 모든 View에 대한 터치 이벤트를 최종적으로 처리하므로
            액티비티의 좌상단을 기준으로 한 좌표가 전달됨
     */

    protected class MyView extends View {
        public MyView(Context context) {
            super(context);
        }
        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(PriorityActivity.this, "No.2 Listener: Touch Event Received", Toast.LENGTH_SHORT).show();
                return true; //이 부분도 함께 주석 처리하면, 마지막 우선순위인 액티비티의 콜백 메서드도 이벤트 처리 기회를 받음
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(PriorityActivity.this, "No.3 Listener: Touch Event Received", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
