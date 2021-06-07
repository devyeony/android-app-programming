package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayList<String> arGeneral = new ArrayList<>();
        arGeneral.add("APPLE");
        arGeneral.add("BANANA");
        arGeneral.add("ORANGE");
        arGeneral.add("MANGO");

        /*
            ArrayList와 ListView를 연결해줄 Adapter
            데이터 항목이 모두 문자열이므로 ArrayAdapter를 사용함
         */
        ArrayAdapter<String> Adapter;

        /*
            ArrayAdapter 초기화 함수의 매개변수
            - context : 현재 컨텍스트인 액티비티를 넘겨줌(this)
            - textViewResourceId : 항목을 표기할 레이아웃의 형태를 결정(리소스 ID)
            - object : Adapter로 공급될 데이터의 원본이자 두 가지 타입에 대해 오버로딩 되어있음

            ArrayAdapter 초기화
            1) ArrayList, LinkedList, Stack 같이 List 인터페이스를 지원하는 컬렉션 객체가 원본인 경우
            - ArrayAdapter(Context context, int textViewResourceId, List<T> objects)
            2) 단순 배열을 원본으로 사용하는 경우
            - ArrayAdapter(Context context, int textViewResourceId, T[] objects)

            ListView의 기본 레이아웃
            - simple_list_item_1 : 하나의 TextView로 구성된 레이아웃
            - simple_list_item_2 : 두 개의 TextView로 구성된 레이아웃
            - simple_list_item_checked : 오른쪽에 체크표시가 나타남
            - simple_list_item_single_choice : 오른쪽에 라디오 버튼이 나타남
            - simple_list_item_multiple_choice : 여러 개 선택 가능하면서 오른쪽에 체크 버튼이 나타남

            ListView는 직접 레이아웃을 정의할 수도 있지만 미리 정의된 레이아웃을 사용할 수 있음
         */
        Adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_checked, arGeneral);

        /*
            - Adapter 객체가 준비되었으면 ListView의 setAdapter 메서드를 호출해서 연결함
            - Adapter는 ListView에 출력할 데이터 원본을 가지고 있으며
              이 데이터 원본을 출력할 뷰를 생성하여 ListView에 제공함
            - ListView는 Adapter가 제공한 뷰를 사용자에게 보여주며
              터치 입력을 받아 항목 선택 및 스크롤을 처리함
         */
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(Adapter);
    }
}