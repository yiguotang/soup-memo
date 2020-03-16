package com.soup.memo.kotlin

/**
 * <p>
 *  抽象类示例
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-13 21:57
 * @since   1.0
 */

open class BaseClass {
    open fun method() {

    }
}

abstract class ChildClass : BaseClass() {
    override fun method() {

    }
}