package com.example.hellokotlin

fun main() {
    // 수정 가능한 Map
    val mem: MutableMap<String, Any> = mutableMapOf<String, Any>()
    // 필요한 만큼 데이터 저장 가능
    mem.put("num", 1)
    mem.put("name", "김구라")
    mem.put("isMan", true)
    
//    // 동일한 key 값으로 기존 value를 덮어쓰기하여 수정 가능
//    mem.put("name", "이정호")
    
    mem["num"] = 1
    mem["name"] = "김구라"
    mem["isMan"] = true

    val num = mem["num"] as Int
    val name = mem["name"] as String
    val isMan = mem["isMan"] as Boolean

}