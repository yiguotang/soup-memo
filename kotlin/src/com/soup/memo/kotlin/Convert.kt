package com.soup.memo.kotlin

/**
 * <p>
 *
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-08 11:34
 * @since   1.0
 */
fun main(args: Array<String>) {
    println(convert2Uppercase("abc"))
    println(convert2Uppercase(1))
}

fun convert2Uppercase(str: Any): String? {
    if (str is String) {
        // 相比java，这里不需要再进行强制转换，这里体现了kotlin的
        return str.toUpperCase()
    }
    return null
}