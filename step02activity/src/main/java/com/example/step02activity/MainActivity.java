package com.example.step02activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// App이 처음 활성화될 때 사용자를 대면하는 Activity
public class MainActivity extends AppCompatActivity {

    // Activity가 활성화될 때 최초 한 번 호출되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
            부모의 메서드 .setContentView() 호출하면서
            어떤 xml 문서를 전개해서 화면을 구성할 지 정보 전달
            
            R: res
            layout: layout 폴더
            activity_main: activity_main.xml 문서  
            
            따라서,
            R.layout.activity_main은 res/layout/activity_main.xml 문서를 의미
         */
        setContentView(R.layout.activity_main);
    }

    // 카운트 값을 저장할 필드 생성 및 초기값 0 부여
    long count = 0;

    // 증가 버튼을 눌렀을 떄 호출될 예정인 메서드 생성
    public void add(View v) {
        // 카운트 1 증가 시키고
        count++;
        // 카운트 값을 TextView에 출력

        // id가 myCount인 TextView 객체 참조값 얻기
        TextView textView = findViewById(R.id.myCount);
        // 출력할 숫자를 문자로 변환
        String strCount = Long.toString(count);
        // TextView 객체의 setText() 메서드를 이용해서 출력된 값 수정
        textView.setText(strCount);
    }

    public void sub(View v) {
        count--;
        TextView textView = findViewById(R.id.myCount);
        String strCount = Long.toString(count);
        textView.setText(strCount);
    }

    public void reset(View v) {
        count = 0;
        TextView textView = findViewById(R.id.myCount);
        String strCount = Long.toString(count);
        textView.setText(strCount);
    }

    public void doubleCount(View v) {
        count *= 2;
        TextView textView = findViewById(R.id.myCount);
        String strCount = Long.toString(count);
        textView.setText(strCount);
    }
}