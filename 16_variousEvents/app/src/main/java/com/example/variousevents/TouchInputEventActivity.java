package com.example.variousevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/*
    터치 입력
    - 안드로이드 앱에서는 이벤트가 발생한 시점에 사전에 정의된 함수를 실행할 수 있으며
      손과 접촉된 지점의 좌표정보를 수집하여 활용할 수 있음

    - 이벤트를 처리하는 방식
      1) 콜백 메서드를 정의하는 방식
        : 콜백 메서드는 하나의 이벤트에 대한 정보를 가짐
      2) 이벤트리스너의 핸들러로 처리하는 방식
        : 리스너는 여러 대상에 대해 등록이 가능하므로 이벤트 대상인 View의 아이디를 전달받음

    - 터치 이벤트와 관련된 대표적인 콜백 메서드
      1) Boolean onTouchEvent(Motion event)
      2) Boolean onTouch(View v, Motion event)

    - MotionEvent 객체의 getAction 메서드는 사용자의 행동(화면 터치 등)에 대한 정보를 전달받음
    - 이용자가 터치한 부분의 좌표를 수집하는 기능을 구현할 시 MotionEvent 객체를 활용할 수 있음
 */
public class TouchInputEventActivity extends AppCompatActivity {

    private MyView vw;
    ArrayList<Vertex> arVertex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = new MyView(this);
        setContentView(vw);
        arVertex = new ArrayList<Vertex>();
    }

    public class Vertex {
        float x;
        float y;
        boolean Draw;

        Vertex(float ax, float ay, boolean ad){
            x = ax;
            y = ay;
            Draw = ad;
        }
    }

    protected class MyView extends View {
        Paint Pnt;

        public MyView(Context context) {
            super(context);
            Pnt = new Paint();
            Pnt.setColor(Color.BLUE);
            Pnt.setStrokeWidth(3);
            Pnt.setAntiAlias(true);
        }

        public void onDraw(Canvas canvas){
            canvas.drawColor(Color.LTGRAY);
            for(int i=0; i<arVertex.size(); i++){
                if(arVertex.get(i).Draw){
                    canvas.drawLine(arVertex.get(i-1).x, arVertex.get(i-1).y,
                            arVertex.get(i).x, arVertex.get(i).y, Pnt);
                }
            }
        }

        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
            }
            if(event.getAction() == MotionEvent.ACTION_MOVE){
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }
            return false;
        }
    }
}