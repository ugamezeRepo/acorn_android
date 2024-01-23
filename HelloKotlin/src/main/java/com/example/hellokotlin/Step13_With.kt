package com.example.hellokotlin

fun main() {
    class Member {
        var num: Int? = null
        var name: String? = null
        var isMan: Boolean? = null

        fun showInfo() {
            println("${this.num}, ${this.name}, ${this.isMan}")
        }
    }

    val m1 = Member()
    m1.num = 1
    m1.name = "김구라"
    m1.isMan = true
    m1.showInfo()

    val m2 = Member()
    with(m2) {
        num = 2
        name = "해골"
        isMan = false
        showInfo()
    }

    val m3 = Member()
    val result = with(m3) {
        num = 3
        name = "원숭이"
        isMan = true

        // 가장 마지막 번 째 line이 리턴 값이다.
        "${this.num} $name $isMan 입니다."
    }
    println(result)
}