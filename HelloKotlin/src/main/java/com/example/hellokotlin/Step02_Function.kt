package com.example.hellokotlin

fun main() {
    /*
        in java => public void a() {}
        in kotlin => fun a(): Unit {} or fun a() {}
        코틀린에서 Unit은 원시 type이라고 지칭하고 java의 void와 비슷한 역할을 한다.
     */

    // 함수명(): 리턴type { }
    fun a(): Unit {
        println("a 함수 호출됨!")
    }

    // 이름이 없는 함수를 만들어서 그 참조값을 변수에 담기
    var b: () -> Unit = fun() {}
    /*
        [ 함수의 type 정의 방식 ]
       (parameter(type)) -> return type
     */
    var c: () -> Unit = fun(): Unit {}

    // String type을 전달받아 해당 문자열의 길이를 return하는 fun를 var에 대입
    var f: (String) -> Int = fun(str: String): Int {
        return str.length
    }
    // f에 (String) -> Int type의 fun만 대입 가능
//     f = 10 // Int type 대입 불가
//     f = "kim" // String type 대입 불가
//     f = fun() {} // () -> Unit type 대입 불가
    f = fun(a: String): Int { return 999 } // (String) -> Int type 대입 가능!!

    var test: (Int, String) -> Int
    // test에 값 대입
    test = fun(a: Int, b: String): Int { return 10 }
}