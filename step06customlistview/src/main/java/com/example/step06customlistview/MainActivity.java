package com.example.step06customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 어댑터에 연결할 모델
        List<CountryDto> countries = new ArrayList<>();

        // 샘플 데이터
        countries.add(new CountryDto(R.drawable.austria, "오스트리아", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.belgium, "벨기에", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.brazil, "브라질", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.france, "프랑스", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.germany, "독일", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.greece, "그리스", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.israel, "이스라엘", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.italy, "이탈리아", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.japan, "일본", "그지 같은 나라~"));
        countries.add(new CountryDto(R.drawable.korea, "대한민국", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.poland, "폴란드", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.spain, "스페인", "어쩌구.. 저쩌구.."));
        countries.add(new CountryDto(R.drawable.usa, "미국", "어쩌구.. 저쩌구.."));

        // CountreyAdapter 객체 생성 및 모델 저장
        BaseAdapter adapter = new CountryAdapter(this, R.layout.listview_cell, countries);

        // ListView의 참조값 저장
        ListView listView = findViewById(R.id.listView);
        // 어댑터 연결
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // 액티비티를 이동할 Intent 객체
            Intent intent = new Intent(this, DetailActivity.class);
            // 클릭한 cell 데이터
            CountryDto dto = countries.get(position);
            // Intent 객체에 Serializable type (CountryDti) 객체 저장
            intent.putExtra("dto", dto);
            // 액티비티 이동
            startActivity(intent);
        });
    }
}