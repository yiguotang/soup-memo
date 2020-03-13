package com.soup.memo.kotlin.extend

/**
 * <p>
 *  属性重写与方法重写类似，需要显示使用 override 修饰，同时父类中的属性需要使用 open 关键字修饰属性
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-11 22:39
 * @since   1.0
 */

fun main(args: Array<String>) {
    var myChile = MyChild()
    println(myChile.name)

    var myChild2 = MyChild2("myChild2")
    println(myChild2.name)
}

open class MyParent {
    open val name: String = "parent"
}

class MyChild : MyParent() {

    // 属性重写
    override val name: String = "child"
}

// 第二种方式重写属性
class MyChild2(override val name: String) : MyParent()

