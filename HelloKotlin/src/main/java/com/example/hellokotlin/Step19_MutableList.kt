package com.example.hellokotlin

fun main() {
    val foods: MutableList<String> = mutableListOf<String>("라면", "김밥")

    // mutable이므로 아이템 추가 가능
    foods.add("쫄면")
    foods.add("떡볶이")
    foods.add("오뎅")

    // 아이템 수정 가능
    foods.set(0, "신라면")
    foods[1] = "참치김밥"

    // 아이템 삭제 가능
    foods.removeAt(2) // 2번 인덱스의 아이템 삭제
    foods.removeLast() // 마지막 인덱스의 아이템 삭제
}