package com.example.hellokotlin

// kotlin에서 인터페이스 생성
interface Remocon {
    fun up()
    fun down()
}

// 인터페이스 구현 클래스 생성
class MyRemocon : Remocon {
    override fun up() {
        println("무언가를 올려요")
    }

    override fun down() {
        println("무언가를 올려요")
    }

    fun move() {
        println("움직여요")
    }
}

fun main() {
    val r1: MyRemocon = MyRemocon()
    val r2: Remocon = MyRemocon()

    // r1은 MyRemocon type이므로 모든 메서드 사용 가능 (move() 포함)
    r1.up()
    r1.down()
    r1.move()

    // r2는 Remocon type이므로 up(), down() 메서드만 사용 가능
    r2.up()
    r2.down()

    // in Java - (MyRemocon)r2
    // in Kotlin - r2 as MyRemocon
    val r3: MyRemocon = r2 as MyRemocon // kotlin에서 type casting
    r3.move()

    // in Java - r2 instanceof MyRemocon
    // in Kotlin - r2 is MyRemocon
    if (r2 is MyRemocon) {
        // smart casting. 형변환 없이 바로 MyRemocon의 기능을 사용할 수 있다.
        r2.move()
    }
}