package com.soup.memo.kotlin

import java.util.function.Consumer

/**
 * <p>
 * 第一个示例
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-01-12 16:24
 * @since   1.0
 */
fun main(args: Array<String>) {
    print("Hello World")

    println()
    println("---------------------")

    val list: List<String> = listOf("hello", "world", "hello world")
    for (str in list) {
        print(str)
    }

    println()
    println("---------------------")

    list.forEach(Consumer { print(it) })

    println()
    println("---------------------")

    list.forEach(System.out::println)
}