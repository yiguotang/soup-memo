package com.soup.memo.kotlin

/**
 * <p>
 *
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-08 15:09
 * @since   1.0
 */
fun main(args: Array<String>) {

    // 定义一个int array，转换后的java代码是int[]数组
    var array: IntArray = intArrayOf(1, 2, 3, 4, 5)

    println("--遍历方式1--")
    for (item: Int in array) {
        println(item)
    }

    println("--遍历方式2--")
    for (i in array.indices) {
        println("array[$i] = ${array[i]}")
    }

    println("--遍历方式3--")
    for ((index, value) in array.withIndex()) {
        println("array[$index] = $value}")
    }

}