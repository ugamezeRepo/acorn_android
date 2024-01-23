package com.example.hellokotlin

// 클래스 상속
/*
    클래스 선언 시 기본값은 상속 X
    마치 Java의 final class Phone { ... } 처럼...
    상속이 가능하려면 open 예약어로 선언
 */

open class Phone {
    fun call() {
        println("전화 걸기")
    }
}

open class HandPhone : Phone() {
    fun mobileCall() {
        println("이동 중 전화 걸기")
    }

    // 재정의 가능한 메서드로 생성하려면 open 예약어 사용
    open fun takePicture() {
        println("100만 화소의 사진 찍기")
    }
}

class SmartPhone : HandPhone() {
    fun doInternet() {
        println("인터넷 사용")
    }

    // override 예약어를 이용해 open된 메서드 오버라이드
    override fun takePicture() {
        // 필요 시 부모의 메서드 호출 가능 (Java와 동일)
        super.takePicture()
        println("1000만 화소의 사진 찍기")
    }
}

fun main() {
    val p1 = Phone()
    val p2 = HandPhone()
    // Phone 클래스를 상속받은 클래스로 생성한 객체이므로 3개의 메서드 모두 사용 가능
    p2.call()
    p2.mobileCall()
    p2.takePicture() // 100만 화소의 사진

    val p3 = SmartPhone()
    p3.doInternet()
    p3.takePicture() // 1000만 화소의 사진 (메서드 오버라이드)
}