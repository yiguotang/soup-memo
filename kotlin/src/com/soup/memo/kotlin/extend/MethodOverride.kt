package com.soup.memo.kotlin.extend

/**
 * <p>
 *  方法的重写
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-11 22:29
 * @since   1.0
 */

fun main(args: Array<String>) {
    var apple = Apple()
    // 调用的是重写的
    apple.name()
    // 调用的是父类中的方法
    apple.expirationDate()
}

open class Fruit {

    open fun name() {
        println("fruit")
    }

    // 没有修饰，表示是final
    fun expirationDate() {
        println("1 month")
    }
}

class Apple : Fruit() {

    // 必须是显示指定重写的关键字，并且重写的方法必须是open修饰的
    override fun name() {
        println("apple")
    }
}

open class Orange : Fruit() {

    // 重写父类的方法，此时如果不想再被子类重写，显示使用final修饰即可
    final override fun name() {
        println("orange")
    }
}

class OrangeJuice : Orange() {

    /*override fun name() {
        super.name()
    }*/
}