package com.example.hellokotlin

fun main() {
    // Read Only Map type 객체 생성
    val mem: Map<String, Any> = mapOf<String, Any>("num" to 1, "name" to "김구라", "isMan" to true)

//    val num: Any? = mem.get("num")
//    val name: Any? = mem.get("name")
//    val isMan: Any? = mem.get("isMan")
    // 아래와 같이 참조 가능
//    val num: Any? = mem["num"]
//    val name: Any? = mem["name"]
//    val isMan: Any? = mem["isMan"]

    // casting도 동시에 시행
    val num = mem.get("num") as Int // as 캐스팅할 type
    val name = mem.get("name") as String
    val isMan = mem.get("isMan") as Boolean
}