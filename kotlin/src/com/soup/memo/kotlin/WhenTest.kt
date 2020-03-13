package com.soup.memo.kotlin

/**
 * <p>
 *  关键字when的使用
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-08 15:31
 * @since   1.0
 */

fun main(args: Array<String>) {
    println(myPrint("hello"))
    println(myPrint("world"))

    println("--简易调用--")
    println(myPrintV2("hello"))
    println(myPrintV2("world"))

    println("--应用--")
    var a = 9;
    var result = when (a) {
        // 单个匹配
        1 -> {
            println("a = 1")
            10
        }
        // 多个匹配
        3, 4, 5 -> {
            println("a = 3 or 4 or 5")
            30
        }
        // 范围匹配
        in 6..10 -> {
            println("a is between 6 and 10")
            40
        }
        else -> {
            println("a is other value")
            50
        }
    }
    println(result)

}

fun myPrint(str: String): String {
    return when (str) {
        "hello" -> "HELLO"
        "world" -> "WORLD"
        else -> "other input"
    }
}

// 上面函数的简易方式
fun myPrintV2(str: String) =
    when (str) {
        "hello" -> "HELLO"
        "world" -> "WORLD"
        else -> "other input"
    }