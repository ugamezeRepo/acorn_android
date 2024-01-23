package com.example.hellokotlin

class Member(var num: Int, var name: String, var addr: String)

/*
    위의 표현은 아래의 줄인 표현이다
    class Member(num: Int, name: String, addr: String) {
        var num: Int
        var name: String
        var addr: String

        init {
            this.num = num
            this.name = name
            this.addr = addr
        }
    }
*/

// data 예약어를 붙이면 toString() 메서드가 자동 재정의되고 copy() 메서드가 생긴다.
// 콘솔창에 출력했을 때 필드에 저장된 내용을 알 수 있다.
data class Member2(var num: Int, var name: String, var addr: String)

fun main() {
    val m1 = Member(1, "김구라", "노량진"); println(m1)
    val m2 = Member2(2, "해골", "행신동"); println(m2)
    val m3 = m2.copy(); println(m3)
    if (m2 == m3) println("m2 == m3") else println("m2 != m3")
}