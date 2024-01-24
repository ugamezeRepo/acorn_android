package com.example.hellokotlin.java;

import com.example.hellokotlin.MyData;
import com.example.hellokotlin.OurData;
import com.example.hellokotlin.YourData;
import com.example.hellokotlin.YourData2;

public class Main02 {
    public static void main(String[] args) {
        // 다양한 모양으로 MyData() 객체 생성 가능
        MyData d1 = new MyData();
        MyData d2 = new MyData(10);
        MyData d3 = new MyData(10, "김구라");

        // Java에서 Kt의 파라미터 디폴트값 정의 오버로드 방식 사용 불가
        // YourData d4 = new YourData();
        YourData d4 = new YourData(20, "해골");
        
        // @JvmOverloads가 선언된 디폴트값 명시 오버로드 함수 호출
        YourData2 d5 = new YourData2();
        YourData2 d6 = new YourData2(30);
        YourData2 d7 = new YourData2(30, "원숭이");

        // Primary Constructor @JvmOverloads 함수 호출
        OurData d8 = new OurData();
        // d8.getNum();
        // d8.setNames("");
        OurData d9 = new OurData(40);
        OurData d10 = new OurData(40, "덩어리");
    }
}
