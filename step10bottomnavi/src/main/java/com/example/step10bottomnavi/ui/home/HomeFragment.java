package com.example.step10bottomnavi.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.step10bottomnavi.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("HomeFragment", "onCreate() 호출됨");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.i("HomeFragment", "onCreateView() 호출됨");
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;

        // dashboardViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s);
        // 람다식에서 매개변수를 중복으로 쓰는 불편함을 없애는 이중콜론 :: 연산자
        // textView::setText 인자로 전달받은 값을 textView 객체의 setText 메서드를 호출하면서 전달하라는 의미
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("HomeFragment", "onDestroyView() 호출됨");
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("HomeFragment", "onDestroy() 호출됨");
    }
}
