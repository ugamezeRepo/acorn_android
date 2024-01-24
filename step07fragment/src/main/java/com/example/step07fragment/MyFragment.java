package com.example.step07fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/*
    하나의 액티비티는 여러 개의 프래그먼트로 구성할 수 있다.
    액티비티 제어 하에 동작하는 미니 액티비디라고 생각하면 된다.
 */

public class MyFragment extends Fragment {
    // 필드
    int count = 0;
    TextView textView;

    // 여기서 리턴된 View 객체가 MyFragment가 차지하고 있는 영역에 채워진다.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // res/layout/fragment_my.xml 문서를 전개해서 View 생성
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        // 만들어진 View에서 TextView의 참조값 찾아오기
        textView = view.findViewById(R.id.textView);
        // TextView의 클릭 리스너 등록
        textView.setOnClickListener(v -> {
            // TextView를 클릭했을 때 count 값을 1 증가시키고
            count++;
            // TextView에 출력
            textView.setText(Integer.toString(count));
        });

        return view;
    }

    // 리셋 메서드
    public void reset() {
        // 카운트 초기화
        count = 0;
        // TextView에 0 출력
        textView.setText("0");
    }
}