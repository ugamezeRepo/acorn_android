package com.example.hellokotlin

fun main() {
    // 1 ~ 10까지 출력
    for (num in 1..10) {
        println(num)
    }
    println("--------------------")

    // 10 ~ 1까지 출력
    for (num in 10 downTo 1) {
        println(num)
    }
    println("--------------------")

    // 1, 3, 5, 7, 9 ... 2씩 증가하면서 출력
    for (num in 1..10 step 2) {
        println(num)
    }
    println("--------------------")

    for (num in 10 downTo 1 step 2) {
        println(num)
    }
    println("--------------------")

    // 반복문 돌면서 역순으로 출력
    val names = listOf("김구라", "해골", "원숭이", "주뎅이", "덩어리")
    for (i in names.size - 1 downTo 0) {
        println(names[i])
    }
    println("--------------------")
}