package com.example.hellokotlin

/*
    [ Java에서 배열 생성 방법 2가지 ]
    정수를 담을 방 5개의 배열 생성
    int[] nums1 = {0, 0, 0, 0, 0};
    int[] nums2 = new int[5];
    문자열을 담을 방 5개의 배열 생성
    String[] names1 = {null, null, null, null, null}
    String[] names2 = new String[5];
 */
fun main() {
    // 0으로 초기화된 방 5개의 Array 객체 생성
    val nums = arrayOf(0, 0, 0, 0, 0)
    val nums2 = Array<Int>(5, { 0 });

    // 문자열을 담는 null로 초기화된 방 3개의 배열
    val names = arrayOf<String?>(null, null, null)
    val names2 = Array<String?>(3, { null })
    val names3 = Array<String?>(3) { null }

    val msgs = Array(100) {
        "메세지 $it"
    }

    msgs.forEach {
        println(it)
    }
}