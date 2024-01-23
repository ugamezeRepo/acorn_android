package com.example.step02activity2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 해석해서 화면 구성하기
        setContentView(R.layout.activity_main);
        // 이동하기2 버튼의 참조값 얻어오기
        Button moveBtn2 = findViewById(R.id.moveBtn2);
        moveBtn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        // id가 moveBtn3인 Button 객체의 참조값 얻어오기
        Button moveBtn3 = findViewById(R.id.moveBtn3);
        // 버튼에 클릭 리스너 등록하기 (함수형태)
        moveBtn3.setOnClickListener(v -> {
            Intent intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        });

        // MainActivity를 View.OnclickListener type으로 만들고
        // MainActivity를 이동하기4 버튼을 눌렀을 때 리스너 인터페이스로 등록하고
        // 동일한 동작을 하도록 프로그래밍 하기
        Button moveBtn4 = findViewById(R.id.moveBtn4);
        moveBtn4.setOnClickListener(this);
    }

    public void clicked(View v) {
        // 액티비티 이동
        // SubActivity로 이동할 의도(intent)를 가진 객체 생성
        Intent intent = new Intent(this, SubActivity.class);
        // 부모의 메서드를 이용해 Activity 이동
        startActivity(intent);
    }

    // implements View.OnClickListener 인터페이스를 구현했기 때문에 강제로 오버라이드된 메서드
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}