package com.example.alertdialog;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
    AlertDialog의 주된 용도
    - 사용자에게 뭔가를 알리고 다음 작업에 대한 지시를 받는 것
    - 어떤 동작을 하던 중에 치명적인 에러가 발생했으면, 작업을 계속할 수 없음을 알려야 하며
      다음 동작을 어떻게 할지도 물어봐야 함
    - AlertDialog는 부모 액티비티의 사용을 금지시켜 놓고 출력되므로 이런 용도에 적합
 */
public class AlertDialogActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        try {
            Thread.sleep(500);
        }catch(Exception e){

        }

        /* 작업 중에 에러가 발생했다고 가정 */
        boolean errorOccur = true;
        if(errorOccur){
            new AlertDialog.Builder(this)
                            .setTitle("ERROR!!")
                            .setMessage("This is insufficient memory to continue." +
                                    "This program will exit.")
                            .setPositiveButton("EXIT", null)
                            .show();
            /*
                finish를 호출한다고 해서 액티비티가 바로 종료되지 않음
                finish는 액티비티를 조만간 종료하도록 등록만 해놓을 뿐이므로
                바로 아래쪽의 Toast 호출문이 실행됨
             */
            finish();
        }
        Toast.makeText(this, "This program was completed", Toast.LENGTH_LONG).show();
    }
    
}
