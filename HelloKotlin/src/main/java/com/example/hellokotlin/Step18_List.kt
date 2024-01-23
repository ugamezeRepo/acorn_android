package com.example.hellokotlin

fun main() {
    // Read Only 문자열 List
    val names = listOf<String>("김구라", "해골", "원숭이")
    // Read Only 숫자 List
    val num = listOf<Int>(10, 20, 30)
    // names List의 0 번 index 참조 방법1
    val a = names.get(0)
    // names List의 0 번 index 참조 방법2
    val b = names[0]
    // names의 item 개수 참조
    val c = names.size
    // names의 마지막 값 참조
    val d = names.lastIndex
    // List의 모든 item을 순회하면서 참조
    names.forEach {
        println(it) // it 키워드로 각각의 아이템 참조
    }
    // 인덱스가 필요한 경우
    for (i in names.indices) {
        val tmp = names.get(i)
        println("$i 번째 인덱스: $tmp")
    }
    // 역순으로 순회
    for (i in names.lastIndex downTo 0) {
        val tmp = names.get(i)
        println("$i 번째 인덱스: $tmp")
    }

}