package com.example.hellokotlin

fun main() {
    class Member {
        var num: Int? = null
        var name: String? = null
        var isMan: Boolean? = null

        fun showInfo() {
            println("${this.num}, ${this.name}, ${this.isMan}")
        }
    }

    // apply는 this를 리턴한다.(Member())
    var m1 = Member().apply { num = 1; name = "김구라"; isMan = true; showInfo() }
    val m2 = with(Member()) { num = 2; name = "해골"; isMan = false; showInfo(); this }
}