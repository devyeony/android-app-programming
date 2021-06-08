package com.example.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

/*
    - AlertDialog는 필요할 때 언제든지 Builder로부터 생성 가능
    - 앞에서의 AlertDialog는 매번 새로 만든 것이며 화면에서 사라지면 가비지 컬렉터에 의해 자동으로 회수
    - 복잡한 모양의 AlertDialog의 생성과 회수를 반복하면 프로그램 효율이 떨어짐
    - 매번 생성하지 않고 미리 AlertDialog를 만들어놓고 필요할 때 보이도록 하기
 */
public class AlertDialogActivity6 extends AppCompatActivity {
    final static int SAMPLE_DIALOG = 0;
    final static int QUESTION_DIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        - AlertDialog의 고유한 ID는 중복되면 안 되므로 0부터 시작하는 일련번호 부여
        - 형식성을 갖추기 위해 상수로 정의해둠
        - showDialog를 최초 호출시 AlertDialog를 생성하여 화면에 출력하며,
          두 번째 이후부터는 미리 생성해 놓은 AlertDialog를 사용하여 반응 속도를 높임
     */
    @SuppressWarnings("deprecation")
    public void mOnClick(View v){
        switch (v.getId()){
            case R.id.button:
                showDialog(SAMPLE_DIALOG);
                break;
            case R.id.button2:
                showDialog(QUESTION_DIALOG);
                break;
        }
    }

    /*
        - 전달된 AlertDialog의 ID에 대응되는 AlertDialog를 생성하여 반환함
        - 한번 생성된 AlertDialog는 시스템에 의해 관리됨
          하나의 AlertDialog에 대해서 한번만 호출되며,
        - 두번째 호출부터는 다시 생성할 필요없이 화면에 보이기만 하면 되므로 반응 속도가 훨씬 빨라짐
     */
    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id){
        switch (id){
            case SAMPLE_DIALOG:
                return new AlertDialog.Builder(AlertDialogActivity6.this)
                                    .setTitle("MESSAGE")
                                    .setMessage("SampleDialog Test is success!!")
                                    .setIcon(R.mipmap.ic_launcher)
                                    .setPositiveButton("CLOSE", null)
                                    .create();
            case QUESTION_DIALOG:
                return new AlertDialog.Builder(AlertDialogActivity6.this)
                                    .setTitle("QUESTION")
                                    .setMessage("Do you like the programming?")
                                    .setPositiveButton("YES!!", null)
                                    .setNegativeButton("NO!!", null)
                                    .create();
        }
        return null;
    }

    /*
        - AlertDialog가 화면에 나타나기 전에 호출되며, 응용 프로그램에 따라 AlertDialog 갱신
        - onCreateDialog 메서드와는 달리 이미 생성된 AlertDialog에 대해서도 호출됨
        - 상황에 따라 AlertDialog의 속성이나 위젯 속성을 변경하기에 적합
        - AlertDialog의 모양이 항상 일정하다면 onPreparedDialog 메서드는 재정의하지 않아도 됨
     */
    @SuppressWarnings("deprecation")
    protected void onPrepareDialog(int id, Dialog dialog){
        switch (id){
            case SAMPLE_DIALOG:
                break;
            case QUESTION_DIALOG:
                Calendar calendar = Calendar.getInstance();
                String stime = String.format("Time %d:%d:%d",
                                            calendar.get(Calendar.HOUR_OF_DAY),
                                            calendar.get(Calendar.MINUTE),
                                            calendar.get(Calendar.SECOND));
                dialog.setTitle(stime);
                break;
        }
    }
}
