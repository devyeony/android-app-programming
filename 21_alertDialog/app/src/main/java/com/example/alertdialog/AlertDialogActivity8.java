package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity8 extends AppCompatActivity {

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
                    .setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();

        }else{
            Toast.makeText(this, "This program was completed", Toast.LENGTH_LONG).show();
        }
    }
}
