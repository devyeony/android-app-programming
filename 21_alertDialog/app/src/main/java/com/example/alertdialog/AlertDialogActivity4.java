package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        버튼의 클릭리스너가 아무런 동작도 하지 않는다면, 클릭리스너 자체를 null로 지정해도 됨
        클릭리스너가 지정되어 있지 않다는 것은 버튼을 클릭했을 때 특별한 동작을 하지 않는다는 뜻.
        프로그래머가 특별한 동작을 정해주지 않는다면 기본 동작인 닫기가 수행됨
        (AlertDialogActivity2, AlertDialogActivity3과 같은 결과)
     */
    public void mOnClick(View v){
        new AlertDialog.Builder(this)
                .setTitle("MESSAGE")
                .setMessage("AlertDialog Test is success!!")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("CLOSE", null)
                .show();
    }
    
}
