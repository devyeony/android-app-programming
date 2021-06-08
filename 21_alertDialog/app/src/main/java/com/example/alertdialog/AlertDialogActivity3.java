package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        NEUTRAL은 항상 왼쪽에 배치되고,
        NEGATIVE, POSITIVE 순으로 오른쪽에 함께 배치됨
        (안드로이드 버전에 따라 다를 수 있음)
     */
    public void mOnClick(View v){
        new AlertDialog.Builder(this)
                .setTitle("MESSAGE")
                .setMessage("AlertDialog Test is success!!")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("POSITIVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("NEGATIVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("NEUTRAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
    
}
