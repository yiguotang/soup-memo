package com.soup.memo.kotlin

/**
 * <p>
 *
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-07 18:26
 * @since   1.0
 */
object StaticMethod {

    // 通过添加这个注解，将方法变成静态方法
    @JvmStatic
    fun sayMsg(msg: String) {
        println(msg)
    }
}