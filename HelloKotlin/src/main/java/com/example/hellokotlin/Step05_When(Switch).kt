package com.example.hellokotlin

import java.util.Scanner

fun main() {
    /*
        java 패키지에 있는 클래스 import 가능
        in은 예약어이므로 ``(backtick)으로 감싸 escape해서 사용
        new 예약어 없이 클래스명() 형식으로 객체 생성
     */
    val scan: Scanner = Scanner(System.`in`)
    println("Gun: 1, Sword: 2")
    println("무기를 선택하세요! (1 or 2): ")
    val weapon = scan.nextInt()

    // weapon 안에 들어있는 수자를 이용하여 분기
    when (weapon) { // kotlin에서 switch문이 없다.
        1 -> {
            println("총으로 공격해요.")
        }
        // 실행할 code가 한 줄이면 { } 생략 가능
        2 -> println("검으로 공격해요.")
        else -> println("주먹으로 공격해요.")
    }
    // 대입 연산자의 우측에 when문 작성 가능
    val selectedWeapon = when (weapon) {
        1 -> "총"
        2 -> "검"
        else -> "주먹"
    }
    // 여러 타입은 Java에서 Object 였지만, Kotlin은 Any 타입이다.
    val selectedWeapon2: Any = when (weapon) {
        1 -> "총"
        2 -> "검"
        else -> 0
    }
}