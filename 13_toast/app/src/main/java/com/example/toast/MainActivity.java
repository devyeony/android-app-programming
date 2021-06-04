package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/*
    Toast 객체
    - 시스템 차원에서 제공되는 작은 팝업 대화상자
    - 사용자에게 임시적인 알림사항을 전달할 때 유용하게 사용
    - 볼륨 조절이나 문자 메시지가 전달되었다는 것을 알릴 때 주로 사용 / 디버깅 용도로도 사용 가능
    - 플로팅 형태로 화면 하단에 잠깐 나타나며 일정 시간이 지나면 자동으로 사라짐
    - 알림 사항을 전달하기만 할 뿐 포커스를 받지 않아서 사용자의 작업을 방해하지 않음

    makeText 메서드
    - 메세지를 출력하는 Context, 표시할 문장, 메시지 표시 시간 등의 속성을 가짐
 */
public class MainActivity extends AppCompatActivity {

    Toast mToast = null;
    int count;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.shortmsg).setOnClickListener(mClickListener);
        findViewById(R.id.longmsg).setOnClickListener(mClickListener);
        findViewById(R.id.count).setOnClickListener(mClickListener);
        findViewById(R.id.customview).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.shortmsg:
                    Toast.makeText(MainActivity.this, "Short Time Message", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.longmsg:
                    Toast.makeText(MainActivity.this, "Long Time Message", Toast.LENGTH_LONG).show();
                    break;
                case R.id.count:
                    str = "Count = " + count++;
                    if(mToast != null){
                        mToast.cancel();
                    }
                    mToast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                    mToast.show();
                    break;
                case R.id.customview:
                    LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.toast_view, null);
                    Toast t2 = new Toast(MainActivity.this);
                    t2.setView(linear);
                    t2.show();
                    break;
            }
        }

    };
}