package com.example.hellokotlin

/* Sample Data */
// read only List<Int>
val nums2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

fun main() {
    // nums2에서 5보다 큰 item만 담은 새로운 List 얻기
    val result = nums2.filter {
        it > 5
    }
    println(result)
    println("--------------------")

    // nums2의 모든 item에 2를 곱한 후 5보다 큰 item만 담은 새로운 List 얻기
    val result2 = nums2.map { it * 2 }.filter { it > 5 }
    println(result2)
    println("--------------------")
}