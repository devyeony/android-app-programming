package com.example.canvas.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TestView2 extends View {
    public TestView2(Context context) {
        super(context);
    }

    /*
        Canvas 클래스는 View의 그리기 표면이며 이 위에 그림을 그리는 메서드를 가짐
        Canvas 객체는 시스템이 초기화하며 View의 onDraw 인수를 전달하므로
        생성할 필요없이 전달받은 인수를 사용하면 됨
     */
    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.LTGRAY);
        Paint Pnt = new Paint();

        // 빨간색 사각형
        Pnt.setColor(Color.RED);
        canvas.drawRect(10, 80, 80, 200, Pnt);

        // 검정색 점
        Pnt.setColor(Color.BLACK);
        canvas.drawPoint(30, 30, Pnt);

        // 검정색 선
        canvas.drawLine(40, 150, 150, 150, Pnt);

        // 파란색 반투명한 원
        Pnt.setColor(0x800000ff); //0x는 16진수, 800000ff는 #aarrggbb 색상
        canvas.drawCircle(80, 80, 50, Pnt);

        // 초록색 문자열
        Pnt.setColor(Color.GREEN);
        canvas.drawText("Canvas Text Finish", 100, 100, Pnt);
    }
}
