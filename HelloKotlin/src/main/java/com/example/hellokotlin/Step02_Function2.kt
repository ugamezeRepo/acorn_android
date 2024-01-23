package com.example.hellokotlin

// 함수 type을 전달받는 함수 정의
fun useFun(a: () -> Unit) {
    // 매개변수 a 함수 호출
    a()
}

// 메인 메서드
fun main() {
    // useFun() 함수 호출
    useFun(fun() {
        println("오잉?")
    })
    // fun() 생략 가능
    useFun({
        println("오잉??")
    })
    // 함수를 호출하는 표현식 () 생략 가능
    useFun {
        println("오잉???")
    }

}