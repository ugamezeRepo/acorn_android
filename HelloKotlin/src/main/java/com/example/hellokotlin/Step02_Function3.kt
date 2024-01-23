package com.example.hellokotlin

/* Sample Data */
// read only List<Int>
val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

fun main() {
    // List에 저장된 모든 아이템을 순서대로 참조해서
    nums.forEach(fun(item) {
        // 원하는 작업 실행
        println(item)
    })
    println("--------------------")
    // 위 코드 간략화
    nums.forEach {
        println(it)
    }
    println("--------------------")

    // nums 배열을 이용해 모든 item에 2를 곱한 새로운 배열 얻기
    val result = nums.map(fun(item):Int {
        return item*2
    })
    println(result)
    println("--------------------")
    // 위 코드 간략화
    var result2 = nums.map{
        it*2
    }
    println(result2)
    println("--------------------")

}