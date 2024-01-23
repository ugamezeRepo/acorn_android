package com.example.step06customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    // 필드
    Context context;
    int layoutRes;
    List<CountryDto> list;

    // 생성자 ( 컨텍스트, cell의 layout 리소스 아이디, 모델)
    public CountryAdapter(Context context, int layoutRes, List<CountryDto> list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
    }

    // 모델의 개수 (cell의 개수)
    @Override
    public int getCount() {
        // List의 size 리턴
        return list.size();
    }

    // i 번째 인덱스 아이템 리턴
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    // i 번째 인덱스 아이템 아이디(PK)
    @Override
    public long getItemId(int i) {
        // 없으면 인덱스 리턴
        return i;
    }

    // i 번째 cell view를 만들어서 리턴
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("CountryAdapter", "getView() 호출됨 i: " + i);

        // 만약 null이면
        if (view == null) {
            Log.d("CountryAdapter", "view가 null이므로 cell view를 새로 생성합니다.");
            // 레이아웃 xml 문서를 전개해 View 객체 새로 생성
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layoutRes, viewGroup, false);
        }
        // i에 해당하는 CountryDto 객체
        CountryDto dto = list.get(i);
        // View 객체 안에 있는 ImageView, TextView의 참조값 저장
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        // ImageView, TextView에 정보 출력
        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getName());
        // i 번째 인덱스에 해당하는 View 리턴
        return view;
    }

}
