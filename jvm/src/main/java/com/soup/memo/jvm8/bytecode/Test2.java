package com.soup.memo.jvm8.bytecode;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-11 10:39
 * @since 1.0
 */
public class Test2 {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public Test2() {
    }

    public Test2(String str) {
        this.str = str;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public void test() {
        synchronized (str) {
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.setX(8);
        in = 20;
    }
}
