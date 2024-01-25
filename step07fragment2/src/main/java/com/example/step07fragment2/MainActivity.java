package com.example.step07fragment2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.step07fragment2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fm = getSupportFragmentManager();
        MyFragment f1 = (MyFragment) fm.findFragmentById(R.id.fragment1);

        binding.resetBtn.setOnClickListener(v -> {
            f1.reset();
        });
    }

    @Override
    public void onTen(String msg) {
        binding.result.setText(msg);
    }
}