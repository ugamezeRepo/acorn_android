package com.example.step09viewmodel.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.step09viewmodel.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    // 자신의 참조값을 리턴해주는 static 메서드
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view model의 참조값을 필드에 저장
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    // res/layout/fragment_main.xml 문서를 전개해서 View를 만들고 화면 구성
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // /res/layout/fragment_main.xml 문서를 전개해서 View 객체 생성
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        // TextView의 참조값 얻어내기
        TextView textView = view.findViewById(R.id.textView);
        // 뷰 모델이 가지고있는 초기값을 TextView에 출력
        textView.setText(mViewModel.getData().getValue());
        // 버튼의 참조값
        Button changeBtn = view.findViewById(R.id.changeBtn);
        
        // 버튼에 리스너 등록
        changeBtn.setOnClickListener(v -> {
            // 뷰 모델이 가지고있는 데이터 변경
            mViewModel.setData("버튼이 눌렸넹??");
        });

        // .observe(데이터의 소유자, 데이터의 관찰자 객체)
        mViewModel.getData().observe(getViewLifecycleOwner(), new Observer<String>() {
            // MutableLiveData가 가지고있는 데이터가 변경되면 호출되는 메서드
            @Override
            public void onChanged(String s) { // 변경된 새로운 데이터가 매개변수에 전달
                // 새로운 데이터를 TextView에 출력
                textView.setText(s);
            }
        });

        return view;
    }

}