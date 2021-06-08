package com.example.alertdialog;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
       setCancelable(false) : 스마트폰의 Back 버튼의 사용을 불가능하게 함
       -> 스마트폰의 Back 버튼에 반응하지 않으며 닫기 버튼을 눌러야 닫힘
     */
    public void mOnClick(View v){
        new AlertDialog.Builder(this)
                .setTitle("MESSAGE")
                .setMessage("AlertDialog Test is success!!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNeutralButton("CLOSE", null)
                .show();
    }
}
