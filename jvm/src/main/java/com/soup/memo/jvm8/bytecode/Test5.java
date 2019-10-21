package com.soup.memo.jvm8.bytecode;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-03-02 19:03
 * @since 1.0
 */
public class Test5 {
    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        Test5 test5 = new Test5();
        test5.test(g1);
        test5.test(g2);
        /**
         * 输出都是“grandpa”
         */
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
