package com.soup.memo.kotlin

/**
 * <p>
 *  object declaration，对象声明，kotlin中特有的
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-13 22:04
 * @since   1.0
 */
object MyObject {
    fun method() {
        println("object declaration metho")
    }
}

fun main(args: Array<String>) {
    MyObject.method()

    println("---------------")

    // MyTest.MyObject.method()

    println("--------类似静态方法的调用，通过伴生对象，实现静态方法和静态属性的调用-------")
    MyTest.method()
    println(MyTest.a)

    println("--伴生对象的类信息--")
    var v = MyTest.MyObject
    println(v.javaClass)
}

// 伴生对象，companion object
// 在kotlin中，与Java不同的是，类是没有static方法的
// 在大多数情况下，kotlin推荐的做法是使用包级别的函数来作为静态方法
// kotlin会将包级别的函数当作静态方法来看待

class MyTest {

    // 伴生对象，在一个类中只允许有1个，而且伴生对象的名称也可以省略
    // 如果不提供名称，编译器会提供一个默认的名字：Companion
    // 虽然伴生对象的成员看起来像是Java中的静态成员，但在运行期，依旧是真实对象的实例成员
    // 在jvm上，可以将伴生对象的成员生成为类的静态方法与静态属性，即通过注解：@JvmStatic
    // 伴生对象在编译后生成一个静态内部类
    companion object MyObject {
        var a: Int = 10
        fun method() {
            println("method invoked!")
        }
    }
}
