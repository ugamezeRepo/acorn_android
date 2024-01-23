package com.example.hellokotlin

fun main() {
    var str: String = "abcd1234"
    var str2: String? = "abcde12345"

    // 문자열의 길이를 참조해 변수에 담기
    var length:Int = str.length
    // null일 가능성이 있으므로 length2는 Int? type ( nullable Int type )
    var length2:Int? = str2?.length
    // Elvis 연산자 "?:"는 null일 경우에 기본 값을 남기는 연산자
    // str2.length가 만일 null이면 0을 남기므로 대입 연사자의 우측이 null일 가능성이 없다.
    // 따라서, length3는 Int? type이 아닌 Int type으로 선언할 수 있다.
    var length3:Int = str2?.length ?: 0

}