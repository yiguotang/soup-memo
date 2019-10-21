package com.soup.memo.jvm8.classloader;

/**
 * <p>
 * Description: 准备阶段 与 初始化阶段 的例子
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-27 15:19
 * @since 1.0
 */
public class InitiativePassive6 {

    public static void main(String[] args) {
        /**
         * 类被主动使用
         * 准备阶段，给类的静态成员变量赋初值（counter1和counter2为0，sigleto为null），
         * 构造方法在准备阶段还未执行
         * 初始化阶段，开始赋值，构造方法中进行了自增（counter1和counter2为1），38行会重新将counter2赋值为0
         * 初始化的值与代码的顺序有关
         */
        Sigleton sigleton = Sigleton.getInstance();
        System.out.println("counter1: " + Sigleton.counter1);
        System.out.println("counter2: " + Sigleton.counter2);
    }
}

class Sigleton {

    // public static int counter1;
    // public static int counter1 = 1;

    // public static int counter2;

    private static Sigleton sigleto = new Sigleton();

    public static int counter1 = 1;

    private Sigleton() {
        counter1++;
        counter2++;
    }

    // 将值重新赋值成0
    public static int counter2 = 0;

    public static Sigleton getInstance() {
        return sigleto;
    }
}
