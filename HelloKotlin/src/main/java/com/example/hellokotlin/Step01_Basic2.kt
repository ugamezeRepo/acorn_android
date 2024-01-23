package com.example.hellokotlin

fun main() {
    // 수정 불가능한 List ( read only )
    val names = listOf<String>("kim", "lee", "park")
    
    // type 추론이 가능하기 떄문에 상수의 type 생략 가능
    val animals = listOf<String>("dog", "cat", "elephant")
    // listOf() 안에 있는 데이터가 추론 가능하기 때문에 listOf의 Generic도 생략 가능
    val nums = listOf(10, 20, 30)

    // 배열 참조
    println(names[0])
    println(names[1])
    println(names[2])
    println("----------------")
    println(names.get(0))
    println(names.get(1))
    println(names.get(2))
    println("----------------")

    // read only이기 때문에 수정 불가
    // names[0] = "김구라"

    val result = names.indices

    // 반복문
    for (i in  names.indices) {
        println("$i : ${names[i]}")
    }
    println("---------- for in ----------")
    for (item in names) {
        println(item)
    }
    println("---------- forEach ----------")
    names.forEach(fun (item) {
        println(item)
    })
    println("---------- forEach 문법 생략 ----------")
    names.forEach{ println(it) }
}