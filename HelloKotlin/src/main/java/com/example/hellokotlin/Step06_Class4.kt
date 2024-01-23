package com.example.hellokotlin

class Cat {
    // 선언만 하고 값을 나중에 넣을 예정인 필드는 lateinit 예약어로 선언
    // 값을 나중에 넣고싶지만 null이 가능한 type이 싫을 때 사용
    lateinit var name: String

    // 필드에 값을 넣어주는 메서드
    fun putName(name: String) {
        this.name = name
    }
}

class Cat2 {
    // nullable type도 가능하지만 번거로워질 수 있다.
    var name: String? = null

    // 필드에 값을 넣어주는 메서드
    fun putName(name: String) {
        this.name = name
    }
}

fun main() {
    val c1 = Cat()
    c1.putName("톰캣")
    println(c1.name)

    val c2 = Cat2()
    c2.putName("나비")
    println(c2.name)
}