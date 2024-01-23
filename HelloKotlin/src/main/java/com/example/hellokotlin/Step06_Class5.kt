package com.example.hellokotlin

class User {
    // null이 가능한 필드 선언
    var num: Int? = null
    var userName: String? = null

    // 인자로 어떤 값도 받지 않는 생성자
    constructor() {
        println("빈 생성자 호출됨")
    }

    // 인자로 Int type과 String type을 전달받는 생성자
    constructor(num: Int, userName: String) {
        this.num = num
        this.userName = userName
    }

    fun showInfo() {
        println("num: ${this.num}, userName: ${this.userName}")
    }
}

class User2 constructor() { // 클래스 옆에 선언한 생성자는 primary 생성자
    // null이 가능한 필드 선언
    var num: Int? = null
    var userName: String? = null

    // primary 생성자의 일부
    init {
        println("primary 생성자 호출됨")
    }

    // primary 생성자가 클래스에 존재할 경우 primary 생성자를 반드시 호출
    constructor(num: Int, userName: String) : this() {
        // :this()는 인자로 아무 것도 전달하지 않아도 되는 primary 생성자를 호출하는 표현식
        this.num = num
        this.userName = userName
    }

    fun showInfo() {
        println("num: ${this.num}, userName: ${this.userName}")
    }
}

fun main() {
    val u1 = User()
    val u2 = User(1, "김구라")
    val u3 = User2()
    val u4 = User2(2, "해골")

    u1.showInfo()
    u2.showInfo()
    u3.showInfo()
    u4.showInfo()
}
