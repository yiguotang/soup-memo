package com.soup.memo.jvm8.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化，这与类的父类和子类的初始化不同（需要进行父类的初始化），final关键字
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量），才会初始化
 *
 * @author zhaoyi
 * @date 2019-01-27 14:28
 * @since 1.0
 */
public class InitiativePassive5 {
    public static void main(String[] args) {
        //System.out.println(Child2.b);
        System.out.println(Childe3.b);
    }
}

interface Parent5 {

    public static int a = 5;

}

interface Child2 extends Parent5 {
    // public static int b = 6;
    // 运行期才能知道的值，需要初始化Child2
    public static int b = new Random().nextInt(2);
}

class Childe3 implements Parent5 {
    public static int b = 5;
}
