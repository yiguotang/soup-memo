package com.soup.memo.kotlin

import java.io.File

/**
 * <p>
 *  函数扩展的调用
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-07 18:59
 * @since   1.0
 */
fun main(args: Array<String>) {
    var file = File("kotlin.iml")

    // readText是kotlin扩展方法
    println(file.readText())
}