package com.example.hellokotlin

// 클래스 정의
class Mycar

class YourCar {
    // 멤버 함수
    fun drive(): Unit {
        println("달려요!")
    }
}

// 대표(primary) 생성자는 클래스명 우측에 선언
class Ship constructor() {
    // init 블럭은 대표 생성자의 일부
    init {
        // 객체를 생성하는 시점에 초기화 하고싶은 작업이 있으면 이 곳에서 한다.
        println("Ship 생성자가 호출되었습니다.")
    }
}

// constructor 예약어 생략 가능
class Ship2() {
    init {
        println("Ship2 생성자가 호출되었습니다.")
    }
}

// 생성자의 인자로 전달 받을 게 없으면 () 생략 가능
class Ship3 {
    init {
        println("Ship3 생성자가 호출되었습니다.")
    }
}

fun main() {
    val c1: Mycar = Mycar()
    val c2: YourCar = YourCar()
    c2.drive()
    val s1 = Ship()
    val s2 = Ship2()
    val s3 = Ship3()

}