package com.example.step11sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Preferences 리스너 등록
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
        //메소드에 전달되는 키값을 활용해서 변화된 값을 읽어온다.
        String value;
        switch (key) {
            case "signature":
            case "reply":
                value = sharedPreferences.getString(key, "");
                Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
                break;
            case "sync":
                value = "동기화 여부:" + sharedPreferences.getBoolean(key, false);
                Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
                break;
        }
        /*  분기
            if (key.equals("signature")) {
                String value = sharedPreferences.getString(key, "");
                Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            } else if (key.equals("reply")) {
                String value = sharedPreferences.getString(key, "");
                Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            } else if (key.equals("sync")) {
                boolean value = sharedPreferences.getBoolean(key, false);
                Toast.makeText(this, "동기화 여부:" + value, Toast.LENGTH_SHORT).show();
            }
         */
    }

    /*
        내부적으로 SharedPreferences를 사용하는 PrefereneceFragmentCompat 클래스를
        상속받아서 만든 특별한 Fragment
     */
    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            // res/xml/root_preferences.xml 문서를 전개해서 화면 구성
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}