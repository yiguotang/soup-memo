package com.soup.memo.kotlin.practice

/**
 * <p>
 *
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-07 18:33
 * @since   1.0
 */
fun main(args: Array<String>) {
    var age = 18
    var name = "zhangsan"

    println("我叫$name, 我今年$age 岁")

    Utils.sayHi(null)
}

object Utils {
    @JvmStatic
    fun sayHi(msg: String?) {
        println("$msg")
    }
}