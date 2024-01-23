package com.example.hellokotlin

/*
    [ in Java ]
    class Util {
        public static int number = 10;
        public static void get() { }
    }
    Util.number;
    Util.get();
 */

class Util {
    // Util 클래스와 함께하는 동반객체 (companion object)
    companion object {
        // 동반개체의 필드 및 메서드(함수) 정의
        val version: String = "1.0"
        fun send() {
            println("전송합니다.")
        }
    }
}

fun main() {
    // 동반 객체에 정의된 필드 혹은 메서드를 클래스명에 .을 찍어서 바로 사용 가능
    Util.send()
    println(Util.version)
}
