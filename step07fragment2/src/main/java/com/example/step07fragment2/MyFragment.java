package com.example.step07fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.step07fragment2.databinding.FragmentMyBinding;

/*
    하나의 액티비티는 여러 개의 프래그먼트로 구성할 수 있다.
    액티비티 제어 하에 동작하는 미니 액티비디라고 생각하면 된다.
 */

public class MyFragment extends Fragment {
    // 필드
    FragmentMyBinding binding;
    int count = 0;

    public interface MyFragmentListener {
        public void onTen(String msg);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 메서드에 전달된 객체를 활용해서 FragmentMyBinding 객체를 얻어낸다.
        binding = FragmentMyBinding.inflate(inflater, container, false);

        binding.textView.setOnClickListener(v -> {
            count++;
            binding.textView.setText(Integer.toString(count));

            // 이 프래그먼트를 제어하고 있는 액티비티의 참조값을 얻어와서
            FragmentActivity fa = getActivity();
            // 만일 해당하는 액티ㅣ빝가 MyFragmentListener type이고, count가 10의 배수이면
            if (fa instanceof MyFragmentListener && count % 10 == 0) {
                // MyfragmentListener type으로 액티비티를 casting한 다음
                MyFragmentListener listener = (MyFragmentListener) fa;
                // 메서드를 호출하면서 메세지 전달
                listener.onTen(count + " 입니다.");
            }
        });

        // 바인딩 객체가 리턴해주는 View를 리턴해준다.
        return binding.getRoot();
    }

    // 리셋 메서드
    public void reset() {
        // 카운트 초기화
        count = 0;
        binding.textView.setText(Integer.toString(count));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}