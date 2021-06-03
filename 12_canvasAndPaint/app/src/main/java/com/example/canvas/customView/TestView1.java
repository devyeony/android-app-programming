package com.example.canvas.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/*
    CustomView
    - View 또는 그 파생 클래스를 상속받은 후에 onMeasure, onDraw 메서드를 재정의하여
      원하는 크기와 모양의 이미지를 그리거나 텍스트를 쓰는 방법
 */
public class TestView1 extends View {

    public TestView1(Context context) {
        super(context); //Context는 클래스, 액티비티, 혹은 그 외의 것들에 관한 정보
    }

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.CYAN);
        Paint Pnt = new Paint();
        Pnt.setColor(Color.RED);
        canvas.drawRect(120, 100, 320, 500, Pnt);
    }
}
