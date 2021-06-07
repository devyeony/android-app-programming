package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

/*
    고정적인 문자열이라면 컬렉션이나 배열을 쓰는 것보다
    리소스에 정의해놓고 사용하는 것이 바람직함.
    배열을 리소스에 정의하기 위해 패키지 탐색기의 values 폴더에 arrays.xml을 작성하여
    문자열들을 리소스로 등록할 수 있음
 */
public class ListViewActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayAdapter<CharSequence> Adapter;
        Adapter = ArrayAdapter.createFromResource
                (this, R.array.mobile, android.R.layout.simple_list_item_1);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(Adapter);
    }
}
