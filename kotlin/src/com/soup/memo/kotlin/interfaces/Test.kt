package com.soup.memo.kotlin.interfaces

/**
 * <p>
 *  kotlin中没有封装类
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-07 18:08
 * @since   1.0
 */

fun main(args: Array<String>) {

    // 只会调用基本类型的接口方法，不会调用封装类的接口方法
    A.a.putNumber(123)

    B.b.putNumber(456)

    println("-----")

    function("")
}

fun function(str: String) {
    var fmt1 = A.format(str)

    // 接受类型是一个可以接受空的类型（带?）
    var fmt3: String? = A.format(str)
    // kotlin的非空保证，下面的代码输出的是null
    println(fmt3?.length)

    // 接受类型是一个不能为空的，保证了非空，后续代码再使用fmt2就不会发生空指针
    var fmt2: String = A.format(str)
}