package com.example.hellokotlin

/*
    [ Kotlin 기본 data type ]
    - import 없이 바로 사용할 수 있는 data type
    - Byte, Short, Int, Long
      Float, Double
      Boolean, Char
      String
 */
/*
class Web  extends RTC{
    static final  String  brand="Google";

    void run( ){
        System.out.println("실행");
    }
}
 */


fun main() {
    val list: List<Any> = listOf(10, "kim", true)
    val list2: Any = listOf(10, "kim", true)
}


/*


fun main() {
    println("Hello, World!")

    // 정수를 담을 수 있는 num 이름의 변수를 만들어 10 대입
    var num: Int = 10; // var num = 10;
    // 실수를 담을 수 있는 num2 이름의 변수를 만들어 10.1 대입
    var num2: Double = 10.1 // var num2 = 10.1;
    // 문자열을 담을 수 있는 myName 이름의 변수를 만들어 "김구라" 대입
    var myName: String = "김구라" // var myName = "김구라"

    // num은 변수(var)라서 값 변경 가능
    num = 11

    // val은 상수를 만들 때 사용하는 예약어이다.
    val num3: Int = 20 // 값이 결정되면 변경 불가
//    num3 = 21 // Error

    // type 추론이 가능한 경우 type은 생략 가능
    var num4 = 10
    var num5 = 10.1
    var yourName = "해골"

    // 변수를 미리 선언하고
    var num6: Int
    // 값을 나중에 넣을 수도 있다.
    num6 = 10

    // 상수도 미리 선언하고
    val PI: Float
    // 값을 나중에 대입할 수 있다.
    PI = 3.14f

    println("num6 : " + num6 + "PI: " + PI);
}

 */