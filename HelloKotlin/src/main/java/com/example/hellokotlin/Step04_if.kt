package com.example.hellokotlin

fun main() {
    val num = 10
    // 변수나 상수를 미리 선언하고
    val result: String
    // 조건부로 다른 값을 대입
    if (num % 2 == 1) {
        result = "$num 은 홀수입니다."
    } else {
        result = "$num 은 짝수입니다."
    }
    println("result : " + result)

    // 3항 연산자?
    // val result2: String = num % 2 == 1 ? "$num 은 홀수" : "$num 은 짝수"

    // 대입 연산자 우측에 if문 대입이 가능하다.
    // if문이 어떤 data를 해당 위치에 남기기도 한다.
    // if문이 남긴 데이터(리턴한 데이터)가 대입 연사자를 통해 변수에 대입된다.
    val result3: String = if (num % 2 == 1) {"$num 은 홀수"} else {"$num 은 짝수"}
    println("result3 : " + result3)
    val result4: String = if (num % 2 == 1) "$num 은 홀수" else "$num 은 짝수"
    println("result4 : " + result4)
    val result5: String? = if (num % 2 == 1) "$num 은 홀수" else null
    println("result5 : " + result5)
}