package com.example.hellokotlin

/*
    Array => 아이템 수정 가능, 추가 불가
    List => 아이템 수정 불가, 추가 불가
    MutableList => 아이템 수정 가능, 추가 가능
*/

fun main() {
    // 정수 배열(array) 객체 생성
    val nums: Array<Int> = arrayOf<Int>(10, 20, 30)
    val nums2: List<Int> = listOf<Int>(10, 20, 30)
    // 문자 배열
    val names = arrayOf("김구라", "해골", "원숭이")
    val names2 = listOf("김구라", "해골", "원숭이")

    // nums에 아이템을 추가 가능? 불가
    // 아이템 수정 가능
    nums[0] = 100 // 대입 연산자로 수정하거나
    nums.set(1, 200) // 메서드를 통해 수정 가능

    // array도 map, filter 함수 사용 가능
    val result:List<Int> = nums.map {
        it * 2
    }
    // forEach 함수 사용 가능
    nums.forEach {
        println(it)
    }
}