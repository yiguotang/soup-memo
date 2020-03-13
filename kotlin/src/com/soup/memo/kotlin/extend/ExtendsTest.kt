package com.soup.memo.kotlin.extend

/**
 * <p>
 *  如何继承
 * </p>
 *
 * @author  zhaoyi
 * @date    2020-03-08 16:25
 * @since   1.0
 */
open class Parent(name: String, age: Int) {}

class Child(name: String, age: Int): Parent(name, age) {}