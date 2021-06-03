package com.example.canvas.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/*
    setStrokeCap 속성
    - 선 끝 모양을 지정하는데 사용됨
    - 인자값
      1) BUTT : 지정된 좌표에서 선이 끝남
      2) ROUND : 둥근 모양으로 끝이 장식됨
      3) SQUARE : 사각형 모양이며 지정된 좌표보다 조금 더 그어짐

    setStyle 속성
    - 사각형이나 원처럼 내부가 채워진 도형을 그릴 때 외곽선의 모양을 결정
    - 인자값
      1) FILL : 채우기만 하며 외곽선은 그리지 않음
      2) FILL_AND_STROKE : 채우기도 하고 외곽선도 그림
      3) STROKE : 채우지는 않고 외곽선만 그림

    setStrokeJoin 속성
    - 사각형의 모서리처럼 선분이 만나서 각지는 곳의 모양을 결정하는 속성
    - 인자값
      1) MITER : 90도로 각진 형태를 그림
      2) BEVEL : 깎인 모양
      3) ROUND : 둥근 모양
*/
public class TestView4 extends View {
    public TestView4(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas){
        canvas.drawRGB(212, 244, 250);
        Paint Pnt = new Paint();

        // 캡 모양 테스트
        Pnt.setColor(Color.RED);
        Pnt.setStrokeWidth(10);
        canvas.drawLine(30, 30, 180, 30, Pnt);

        Pnt.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(30, 70, 180, 70, Pnt);

        // 만나는 지점의 모양 테스트
        Pnt.setColor(Color.CYAN);
        Pnt.setStrokeWidth(15);
        Pnt.setStyle(Paint.Style.STROKE);
        Pnt.setStrokeJoin(Paint.Join.MITER);
        canvas.drawRect(30, 110, 70, 145, Pnt);

        Pnt.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawRect(100, 110, 140, 145, Pnt);

        Pnt.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawRect(170, 110, 210, 145, Pnt);

        // 원 스타일 테스트
        Pnt.setColor(Color.GREEN);
        Pnt.setStrokeWidth(10);
        Pnt.setAntiAlias(true);
        Pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(40, 200, 30, Pnt);

        Pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(120, 200, 30, Pnt);

        Pnt.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200, 200, 30, Pnt);

        Pnt.setColor(Color.YELLOW);
        Pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(40, 280, 30, Pnt);

        Pnt.setColor(Color.GREEN);
        Pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(40, 280, 30, Pnt);

        Pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(120, 280, 30, Pnt);

        Pnt.setColor(Color.YELLOW);
        Pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(120, 280, 30, Pnt);
    }
}
