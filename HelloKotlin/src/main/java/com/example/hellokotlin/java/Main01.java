package com.example.hellokotlin.java;

import com.example.hellokotlin.MyUtil;
import com.example.hellokotlin.OurUtil;
import com.example.hellokotlin.YourUtil;

public class Main01 {
    public static void main(String[] args) {
        MyUtil util = new MyUtil();
        util.send();
        util.send(10);
        util.send(10, "hi");

        YourUtil util2 = new YourUtil();
        // Kotlin에서 매개변수에 기본값을 정의한 방법은 Java에서 사용할 수 없다.
        // 따라서, 매개변수의 형태를 지켜서 호출해야한다.
        util2.send(20, "hello");

        OurUtil util3 = new OurUtil();
        // @JvmOverload를 통해 Kotlin 언어와 오버로드 방식 호환하여 기본값 정의 방식 사용 가능
        // send() 메서드에 @JvmOverloads 어노테이션이 붙어있으므로 Java에서 모든 형태의 메서드 호출 가능
        util3.send();
        util3.send(30);
        util3.send(30, "bye");
    }
}
