package com.example.variousevents;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
    - 타 이벤트와 달리 타이머는 프로그램 코드를 통해 이벤트가 실행됨
    - 매개변수로 지정한 값에 따라 이벤트 발생 간격, 횟수가 결정됨
    - 아래 코드는 1초에 한번씩 정수값을 증가시켜 TextView로 출력함
 */
public class TimerEventActivity extends AppCompatActivity {

    int value = 0;
    TextView mText;

    /*
        - 참고 : Handler의 기본 생성자는 deperecated 됨
        - 타이머 처리를 위해 Handler 클래스를 사용하며 스레드 간의 메시지 통신을 위한 장치로
          sendMessage 메서드로 특정 핸들러에게 메시지를 보낼 수 있음.
          메시지는 handleMessage 메서드로 전달되며 여기서 메시지의 의미를 해석해서 필요한 처리를 함.
     */
    Handler mHandler = new Handler(Looper.myLooper()){
        public void handleMessage(Message msg){
            value++;
            mText.setText("Timer Value = " + value);

            /*
                핸들러는 자신이 스스로 자신에게 다시 메시지를 보내며,
                이 때는 sendEmptyMessageDelayed 메서드로 1초간의 지연 시간을 두어 1초 후에 메시지를 보냄.
                onCreate는 시작만 하며 이후는 핸들러가 스스로를 재호출하면서 무한히 메시지를 받음.
             */
            mHandler.sendEmptyMessageDelayed(0,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_event);
        mText = (TextView)findViewById(R.id.text);

        //여기서 빈 메시지를 보냄으로써 처음으로 핸들러가 호출됨
        mHandler.sendEmptyMessage(0);
    }
}
