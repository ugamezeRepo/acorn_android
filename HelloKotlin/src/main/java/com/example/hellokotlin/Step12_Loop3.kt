package com.example.hellokotlin

fun main() {
    val nums = mutableListOf(10, -5, -6, 1, 4, -7, -8, 20, 30, -15, -13)

    /*
        // for문을 활용해서 nums List에서 음수를 모두 제거
        for (i in nums.size -1 downTo 0) {
            if (nums[i] < 0) {
                nums.removeAt(i)
            }
        }
     */
    for (i in nums.indices.reversed()) {
        if (nums[i] < 0) {
            nums.removeAt(i)
        }
    }

    println("--------------------")
    // 삭제 후 실제로 음수가 모두 삭제 됐는 지 순서대로 출력
    for (item in nums) {
        println(item)
    }
    println("--------------------")

    // 삭제된 새로운 배열을 얻어내고 싶다면 .filter() 함수를 사용하면 된다.
    val nums2 = mutableListOf(10, -5, -6, 1, 4, -7, -8, 20, 30, -15, -13)
    // result는 음수가 제거된 새로운 배열이다.
    val result = nums2.filter(fun(item): Boolean {
        return item >= 0
    })
    val result2 = nums2.filter({ item ->
        item >= 0
    })
    val result3 = nums2.filter { item -> item >= 0 }
    // 람다식의 매개변수가 1개인 경우 매개변수를 선언하지 않고 it으로 암시적 매개변수를 받는다.
    val result4 = nums2.filter { it >= 0 }
    for (item in result) {
        println(item)
    }
    println("--------------------")
}