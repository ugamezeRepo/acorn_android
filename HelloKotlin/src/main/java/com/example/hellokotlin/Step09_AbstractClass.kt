package com.example.hellokotlin

abstract class Weapon {

    fun move() {
        println("이동합니다.")
    }

    // 추상 메서드 역시 abstract 예약어를 이용해 생성
    abstract fun attack()
}

class MyWeapon : Weapon() {
    // 추상 메서드 오버라이드가 강제된다
    override fun attack() {
        println("무언가를 공격합니다.")
    }
}

fun main() {
    val w1: Weapon = MyWeapon()
    w1.move()
    w1.attack()
    
    val w2: Weapon = object : Weapon() {
        // 따로 클래스를 정의하지 않고 object 키워드를 이용해 Weapon type 참조값 얻어내기
        override fun attack() {
            println("냥냥어택")
        }
    }
    w2.move()
    w2.attack()

    // 다형성 확인
    val w3: MyWeapon = MyWeapon()
    val w4: Weapon = w3
    val w5: Any = w3 // Any type은 Java의 Object type에 해당하는 type
}