package com.example.canvas.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/*
    Paint 객체
    - 그리기에 대한 속성정보를 가지는 객체이며, 모든 그리기 함수에게 인수로 전달됨
    - 채워지는 색상, 선의 굵기 등과 같은 속성들을 Paint 객체로 지정
    - new 연산자로 빈 Paint 객체를 생성하면 디폴트 속성으로 생성
    - 속성을 조절하는 메서드를 호출하면 원하는 속성으로 적용 가능
 */
public class TestView3 extends View {
    public TestView3(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.TRANSPARENT);
        Paint Pnt = new Paint(); // 디폴트 색상값은 검은색
        Pnt.setColor(Color.BLACK);
        Pnt.setTextSize(80);

        canvas.drawOval(new RectF(10, 10, 200, 120), Pnt);
        canvas.drawText("Basic Text", 210, 70, Pnt);

        /*
            setAntiAlias 메서드
            - 색상 차가 뚜렷한 경계 부근에 중간색을 삽입하거나
              도형이나 글꼴이 주변 배경과 부드럽게 잘 어울리도록 하는 기법
         */
        Pnt.setAntiAlias(true);
        canvas.drawOval(new RectF(10, 130, 200, 240), Pnt);
        canvas.drawText("AntiAlias Text", 210, 190, Pnt);
    }
}
