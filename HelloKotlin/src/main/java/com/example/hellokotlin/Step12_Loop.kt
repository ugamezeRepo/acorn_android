package com.example.hellokotlin

fun main() {
    // 수정 가능한 String 목록
    val names: MutableList<String> = mutableListOf<String>("김구라", "해골", "원숭이", "주뎅이", "덩어리")
    // 수정 불가능한 String 목록
    val names2: List<String> = listOf<String>("김구라", "해골", "원숭이", "주뎅이", "덩어리")

    // 모든 아이템을 순서대로 참조
    for (item in names) {
        println(item)
    }
    println("--------------------")
    // index도 필요하다면
    for (i in names.indices) {
        println("$i 번째 인덱스: ${names[i]}")       // 배열 문법 참조
        println("$i 번째 인덱스: ${names.get(i)}")   // 메서드 참조
    }
    println("--------------------")

    // names에 모두 "님"을 붙이기 (수정)
    for (i in names.indices) {
        names[i] = names[i] + "님"
        // names[i] = names.get(i) + "님"
        // names.set(i, names.get(i) + "님")
    }
    println(names)
}