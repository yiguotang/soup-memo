package com.soup.memo.kotlin.variable

import kotlin.reflect.KClass

/**
 * <p>
 *  变量赋值与使用
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-07 11:14
 * @since   1.0
 */

var age: Int = 18
var name: String = "zhangsan"
var name2: String? = null

fun main(args: Array<String>) {
    // String? 与 String 是2个不同类型
    // 如果强行复制，需要加上!!进行强转
    // name = name2!!
    // name2 = name

    // 指定类型
    var a: Int = 1
    // 类型推断
    var b = 3

    printLn(name)

    // kotlin与java类的class使用的不同
    testClass(JavaMain::class.java)
    testClass(KotlinMain::class)

    // 用反引号进行关键字冲突处理
    // 在kotlin中in是关键字，而JavaMain类中的静态变量名是in，使用反引号进行关键字处理
    println(JavaMain.`in`)
}

// 定义方法
fun printLn(str: String): String {
    println("这个字符串是：$str")
    return str
}

// 使用Java class
fun testClass(clazz: Class<JavaMain>) {
    println(clazz.name)
}

// 使用kotlin class
fun testClass(clazz: KClass<KotlinMain>) {
    println(clazz.qualifiedName)
}