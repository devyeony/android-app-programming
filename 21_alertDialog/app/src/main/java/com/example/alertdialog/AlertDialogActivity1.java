package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/*
    AlertDialog
    - 사용자에게 전달사항을 알리고 질문을 통해 사용자의 선택을 받아들이는
      사용자와 애플리케이션 사이의 기본적인 통신 수단
    - Toast는 사용자에게 내용을 알리는 기능을 가지고 있으나 사용자와 상호작용 불가
    - 사용자가 닫기 전까지 사라지지 않음으로써 장시간 메시지 표시 가능
    - 메시지 내용이 길어서 한 화면에 다 표시할 수 없으면 스크롤바가 나타남
    - 문자열 메시지뿐만 아니라 타이틀바나 아이콘도 출력 가능, 버튼으로 사용자의 입력을 받을 수 있음
    - Dialog 클래스는 사용 방법이 복잡하여 간단한 AlertDialog를 주로 사용

    Builder 생성자
    - AlertDialog는 생성자가 protected로 숨겨져 있어서 직접 생성 불가
    - 내부 클래스인 Builder를 통해 생성해야 함
 */
public class AlertDialogActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        /*
            Builder 생성자는 Context 객체를 생성자 매개변수로 받음
            Activity는 Context를 상속하고 있으므로 자기 자신의 객체를 넣음

            Builder의 생성자와 속성에 대한 설정 메서드들은 모두 Builder 자체를 반환함
            그러므로 Builder 객체 생성 후, 별도의 메서드 호출문을 작성할 필요없이
            반환되는 메서드들을 연쇄적으로 호출해도 상관없음
         */
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setTitle("MESSAGE");
        bld.setMessage("AlertDialge Test is success!!");
        bld.setIcon(R.mipmap.ic_launcher);
        //bld.create(); //AlertDialog를 메모리에 생성만 하고 화면으로 출력하지는 않음
        bld.show();
    }
}