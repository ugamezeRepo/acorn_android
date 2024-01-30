package com.example.step10bottomnavi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.step10bottomnavi.databinding.ActivityMainBinding;

/*
        - icon 으로 사용할 vector xml 문서 다운 받는곳

        https://fonts.google.com/icons?icon.platform=android

        https://materialdesignicons.com/

        - 직접 선택해서 만들고 싶다면

        res/drawable => 마우스 우클릭 => new Vector Asset  들어가서 원하는 옵션으로 만들수도 있다.
 */

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 하단 네비바의 참조값 저장. 바인딩해서 안 쓰이넹
        // BottomNavigationView navView = findViewById(R.id.nav_view);
        
        // 하단 메뉴바 설정 객체의 참조값 저장
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        // 네비 컨트롤러 객체의 참조값 저장
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        // 네비 컨트롤러 및 하단 메뉴바 작동을 위한 초기화 작업
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}