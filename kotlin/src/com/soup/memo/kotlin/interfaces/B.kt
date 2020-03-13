package com.soup.memo.kotlin.interfaces

/**
 * <p>
 *  kotlin只会继承基本类型的接口方法，而且也不会报错
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-07 18:13
 * @since   1.0
 */
class B : AInterface {

    companion object {
        val b = B()
    }

    override fun putNumber(num: Int) {
        println("int")
    }

}