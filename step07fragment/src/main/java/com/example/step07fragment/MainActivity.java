package com.example.step07fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.step07fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // view biniding 객체를 필드에 저장하고 사용하면 편리
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 액티비티의 화면에 전개된 프래그먼트 참조값 얻어내기
        FragmentManager fm = getSupportFragmentManager();
        // MyFragment의 참조값을 얻어와서
        MyFragment f1 = (MyFragment)fm.findFragmentById(R.id.fragment1);
        MyFragment f2 = (MyFragment)fm.findFragmentById(R.id.fragment2);

        // 버튼에 클릭 리스너 등록
        binding.resetBtn.setOnClickListener(v -> {
            // MyFragment가 가지고있는 리셋 메서드 호출
            f1.reset();
            f2.reset();
        });

        binding.moveBtn.setOnClickListener(v -> {

        });
    }
}