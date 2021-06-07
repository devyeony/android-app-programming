package com.example.listview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

/*
    choiceMode 속성
    - ListView 내의 뷰를 선택하는 형식을 정의
    - choiceMode의 속성값 / 인수 / 설명
      1) none / CHOICE_MODE_NONE / 항목을 선택할 수 없음(default)
      2) singleChoice / CHOICE_MODE_SINGLE / 하나의 항목만 선택
      3) multipleChoice / CHOICE_MODE_MULTIPLE / 복수개의 항목을 선택

    divider 속성
    - 항목 사이의 구분선을 지정

    entries 속성
    - ImageView의 src 속성이나 TextView의 text 속성처럼 ListView에 표시할 배열을 지정
    - 정적인 배열이라면 entries 속성을 통해 간편하게 지정 가능
 */
public class ListViewActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayAdapter<CharSequence> Adapter;
        Adapter = ArrayAdapter.createFromResource
                (this, R.array.mobile, android.R.layout.simple_list_item_multiple_choice);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(Adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setDivider(new ColorDrawable(Color.BLUE)); //구분선의 색상 지정
        list.setDividerHeight(5); //구분선의 두께 지정
    }
}
