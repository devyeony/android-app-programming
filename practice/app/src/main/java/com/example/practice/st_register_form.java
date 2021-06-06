package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class st_register_form extends AppCompatActivity implements View.OnClickListener {

    EditText edtSno, edtSname, edtSyear, edtMajor, edtScore;
    RadioGroup rdoGender;
    RadioButton rdoMale, rdoFemale;
    Button btnList, btnInsert, btnUpdate, btnDelete, btnReset, btnSearch;
    myDbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_register_form);

        edtSno = findViewById(R.id.edtSno);
        edtSname = findViewById(R.id.edtSname);
        edtSyear = findViewById(R.id.edtSyear);
        edtMajor = findViewById(R.id.edtMajor);
        edtScore = findViewById(R.id.edtScore);
        rdoGender = findViewById(R.id.rdoGender);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        btnList = findViewById(R.id.btnList);
        btnInsert = findViewById(R.id.btnInsert);
        btnSearch = findViewById(R.id.btnSearch);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnReset = findViewById(R.id.btnReset);

        btnList.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        helper = new myDbHelper(getApplicationContext(), "TBL_STUDENT", null, 1);
    }

    @Override
    public void onClick(View v) {
        if(v == btnInsert) {
            String strSno = edtSno.getText().toString();
            String strSname = edtSname.getText().toString();
            String strSyear = edtSyear.getText().toString();
            String strMajor = edtMajor.getText().toString();
            String strScore = edtScore.getText().toString();
            String strGender = "";
            if(rdoMale.isChecked()) {
                strGender="M";
            } else if(rdoFemale.isChecked()) {
                strGender="F";
            }
            int year = Integer.parseInt(strSyear);
            int score = Integer.parseInt(strScore);
            String sql = "insert into TBL_STUDENT (sno, sname, syear, gender, major, score)";
            sql += "values ('" + strSno + "' , '" + strSname + "', " + year + ", '" + strGender.toString() + "', '" + strMajor + "', " + score + ")";
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL(sql);
            db.close();
            AlertDialog.Builder dlg = new AlertDialog.Builder(st_register_form.this);
            dlg.setTitle("등록 성공");
            dlg.setMessage("등록이 완료되었습니다");
            dlg.setPositiveButton("확인", null);
            dlg.show();
        } else if(v == btnSearch) {
            SQLiteDatabase db = helper.getReadableDatabase();
            String sql = "select * from TBL_STUDENT";
            Cursor cursor = db.rawQuery(sql, null);
            String strSno = "";
            String strSname = "";
            String strSyear = "";
            String strMajor = "";
            String strScore = "";
            String strGender = "";
            if(strGender.equals("남")) {
                rdoMale.setSelected(true);
            } else if(strGender.equals("여")) {
                rdoFemale.setSelected(true);
            }
            while(cursor.moveToNext()) {
                strSno += cursor.getString(cursor.getColumnIndex("sno")) + "\n";
                strSname += cursor.getString(cursor.getColumnIndex("sname")) + "\n";
                strSyear += cursor.getString(cursor.getColumnIndex("syear")) + "\n";
                strMajor += cursor.getString(cursor.getColumnIndex("major")) + "\n";
                strScore += cursor.getString(cursor.getColumnIndex("score")) + "\n";
                strGender += cursor.getString(cursor.getColumnIndex("gender")) + "\n";
            }
            edtSno.setText(strSno);
            edtSname.setText(strSname);
            edtSyear.setText(strSyear);
            edtMajor.setText(strMajor);
            edtScore.setText(strScore);
            rdoGender.setSelected(true);
            cursor.close();
            db.close();
        } else if(v == btnUpdate) {

        } else if(v == btnDelete) {

        } else if(v == btnReset) {
            SQLiteDatabase db = helper.getWritableDatabase();
            helper.onUpgrade(db, 1, 2);
            db.close();
            Toast.makeText(getApplicationContext(), "테이블 생성 완료", Toast.LENGTH_SHORT).show();
        } else if(v == btnList) {
            finish();
        }
    }

    class myDbHelper extends SQLiteOpenHelper {

        public myDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "create table TBL_STUDENT (";
            sql += " sno char(8) primary key,";
            sql += " sname char(10) not null,";
            sql += " syear int(1) not null,";
            sql += " gender varchar(10) not null,";
            sql += " major char(10) not null,";
            sql += " score int(3) default(0) not null)";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "drop table if exists TBL_STUDENT";
            db.execSQL(sql);
            onCreate(db);
        }

    }
}