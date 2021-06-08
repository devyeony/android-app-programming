package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/*
    AlertDialog의 버튼(Dialog 내에서의 위치 차이만 있음)
    - PositiveButton (긍정)
    - NeutralButton (중립)
    - NegativeButton (부정)

    - 버튼들의 인수로는 버튼에 표시할 텍스트와 클릭 리스너가 있다
    - AlertDialog
 */
public class AlertDialogActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        아래 코드에서 'CLOSE' 버튼을 배치하기 위해 setPositiveButton 메서드를 사용했는데
        setPositiveButton은 Button의 메서드 이름일 뿐임
        setNegativeButton, setNeutralButton 메서드를 사용해도 같은 결과가 나옴
     */
    public void mOnClick(View v){
        new AlertDialog.Builder(this)
                .setTitle("MESSAGE")
                .setMessage("AlertDialog Test is success!!")
                .setIcon(R.mipmap.ic_launcher)
                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

}
