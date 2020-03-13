package com.soup.memo.kotlin

/**
 * <p>
 *  primary 和 secondary 构造方法
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-08 15:53
 * @since   1.0
 */

class Person constructor(username: String) {

    // 成员变量需要进行初始化
    private var username: String
    private var age: Int
    private var address: String

    init {
        println("primary构造方法调用：$username")

        this.username = username
        this.age = 20
        this.address = "nanjing"
    }

    // secondary构造方法: 必须要直接或间接调用primary构造方法，下面是直接调用
    constructor(username: String, age: Int): this(username) {
        println("第二个secondary构造方法调用：$username, $age")

        this.username = username
        this.age = age
        this.address = "nanjing"
    }

    // 间接调用primary构造方法
    constructor(username: String, age: Int, address: String): this(username, age) {

        println("第二个secondary构造方法调用：$username, $age, $address")

        this.address = "nanjing"
    }

    fun printInfo() {
        println("username: ${this.username}, age: ${this.age}, address: ${this.address}")
    }
}

fun main(args: Array<String>) {
    var person = Person("zhangsan")
    var person2 = Person("lisi", 23)
    var person3 = Person("wangwu", 15, "beijing")

    person.printInfo()
    person2.printInfo()
    person3.printInfo()
}
