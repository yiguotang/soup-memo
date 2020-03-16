package com.soup.memo.kotlin.interfaces

/**
 * <p>
 *
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-13 21:46
 * @since   1.0
 */
interface AService {
    fun method() {
        println("A")
    }
}

interface BService {
    open fun method() {
        println("B")
    }
}

// 实现了2个接口，2个接口中都有method方法，需要进行override
class CService : AService, BService {
    override fun method() {
        println("C")
    }
}


fun main(args: Array<String>) {
    var c = CService()
    c.method()
}