package com.example.step11sharedpref;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

/*
    App 에서 문자열을 영구 저장하는 방법 (영구 저장이란 앱을 종료하고 다시 시작해도 불러올수 있는 문자열 )

    1. 파일 입출력을 이용해서 저장
    2. android 내장 DataBase를 이용해서 저장  => SQLite DataBase
    3. SharedPreference를 이용해서 저장 (느리지만 간단히 저장하고 불러올 수 있다.)
       내부적으로 xml 문서를 만들어서 문자열을 저장하고 불러온다.
       저장된 문자열을 boolean, int, double, String type 으로 변환해서 불러올 수 있다.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 참조값 저장
        editText = findViewById(R.id.editText);
        Button saveBtn = findViewById(R.id.saveBtn);
        Button readBtn = findViewById(R.id.readBtn);
        // 버튼에 리스너 등록
        saveBtn.setOnClickListener(this);
        readBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        
        // default SharedPreferences 객체 얻어내기
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String signature = pref.getString("signature", "");
        String reply = pref.getString("reply", "");
        boolean sync = pref.getBoolean("sync", false);
        boolean attachment = sync && pref.getBoolean("attachment", false);
    }

    @Override
    public void onClick(View v) {
        // 눌러진 아이디를 읽어와서
        int id = v.getId();
        SharedPreferences pref = getSharedPreferences("info", Context.MODE_PRIVATE);

        // 분기
        if (id == R.id.saveBtn) {
            // 입력한 문자열
            String msg = editText.getText().toString();
            // info라는 이름의 xml 문서를 만들 SharedPreferences 객체 참조값 저장
            // SharedPreferences pref = getSharedPreferences("info", Context.MODE_PRIVATE);
            // 에디터 객체
            SharedPreferences.Editor editor = pref.edit();
            // 에디터 객체를 이용해 저장
            editor.putString("msg", msg);
            editor.apply();
            // editor.commit(); // 동기 처리... Main Thread에서 비추

            new AlertDialog.Builder(this).setMessage("저장했습니다.").setNeutralButton("확인", null).create().show();
        } else if (id == R.id.readBtn) {
            // SharedPreferences pref = getSharedPreferences("info", Context.MODE_PRIVATE);
            // .getString(key 값, default 값)
            String msg = pref.getString("msg", "");
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    /*
        1. res => Mouse RC => new => Android Resource Directory => Resource Type(menu) 선택
        2. menu 폴더 Mouse RC => new => menu Reousece file => menu_main.xml 문서 생성
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴 전개자 객체를 이용해 res/menu/menu_main.xml 문서를 전개해서 메뉴에 추가
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // 위에서 구성된 메뉴 중 하나를 선택했을 때 호출되는 메서드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 선택된 메뉴의 아이디 추출
        int id = item.getItemId();
        // 아이디를 이용해서 분기
        if (id == R.id.setting) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        } else if (id == R.id.one) {

        } else if (id == R.id.two) {

        }

        return super.onOptionsItemSelected(item);
    }
}