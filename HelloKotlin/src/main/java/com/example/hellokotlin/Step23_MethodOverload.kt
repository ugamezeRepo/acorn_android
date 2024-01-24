package com.example.hellokotlin

class MyUtil {
    // 같은 메서드명으로 메서드 다중정의(overload) - 매개변수의 형태가 달아야 한다.
    fun send() {}
    fun send(num: Int) {}
    fun send(num: Int, msg: String) {}

}

class YourUtil {
    fun send(num: Int = 0, msg: String = "") {}
}

class OurUtil {
    @JvmOverloads fun send(num: Int = 0, msg: String = "") {}
}

fun main() {
    val util = MyUtil()
    // 메서드 다중정의(오버로드)
    util.send()
    util.send(10)
    util.send(10, "hi")

    // 디폴트값을 가진 메서드 다중정의(인 척)
    val util2 = YourUtil()
    util2.send()
    util2.send(20)
    util2.send(20, "bye")
}