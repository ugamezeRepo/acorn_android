package com.example.hellokotlin

class Person constructor(name: String) {
    // 필드 선언
    var name: String

    init {
        this.name = name
    }
}

// 위 코드를 줄인 경우.
// 생성자에 정의한 매개변수의 모양 그대로 필드가 만들어지고 생성자에 전달한 값이 자동 저장된다.
class Person2(var name: String)

/// var와 val의 차이는 수정 가능 여부의 차이
class Person3(val name: String)

fun main() {
    val p1 = Person("김구라")
    val p2 = Person2("해골")
    val p3 = Person3("원숭이")

    println(p1.name)
    println(p2.name)
    println(p3.name)
}