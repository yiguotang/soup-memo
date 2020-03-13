package com.soup.memo.kotlin

/**
 * <p>
 * 构造方法和初始化
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-08 15:42
 * @since   1.0
 */
class MyClass constructor(username: String) {
    private val username: String = username.toUpperCase()

    init {
        println(username)
    }
}

fun main(args: Array<String>) {
    var myClass = MyClass("zhangsan")
}