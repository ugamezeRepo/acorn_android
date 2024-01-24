package com.example.hellokotlin

// 생성자 다중 정의
class MyData {
    constructor()
    constructor(num: Int)
    constructor(num: Int, name: String)
}

class YourData {
    // 매개변수에 기본 값을 설정하면 다중정의된 효과를 낼 수 있다.
    constructor(num: Int = 0, name: String = "")
}

class YourData2 {
    // 매개변수에 기본 값을 설정하면 다중정의된 효과를 낼 수 있다.
    @JvmOverloads constructor(num: Int = 0, name: String = "")
}

// Primay Constructor가 강제되는 data class의 다중 정의 방식
data class OurData @JvmOverloads constructor(var num: Int = 0, var names: String = "")

fun main() {
    // 다중정의된 MyData의 다양한 방법으로 객체 생성
    val a = MyData()
    val b = MyData(1)
    val c = MyData(1, "김구라")

    // Default Value를 넣은 YourData도 다양한 모양으로 객체를 생성 가능
    val d = YourData()
    val e = YourData(2)
    val f = YourData(2, "해골")

    // data class인 OurData의 객체 생성
    val g = OurData()
    val h = OurData(3)
    val i = OurData(3, "원숭이")
}