package com.soup.memo.thread;

/**
 * <p>
 *  cpu指令乱排示例
 *  如果出现输出为（0，0），表示发生了指令重排
 * </p>
 *
 * @author zhaoyi
 * @date 2020-03-05 22:31
 * @since 1.0
 */
public class Disorder {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws Exception{
        int i = 0;
        for (; ; ) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;

            Thread one = new Thread(() -> {
                // 由于线程one先启动，可以先wait下线程two，可以适当调整等待时间

                a = 1;
                x = b;
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start(); two.start();
            one.join(); two.join();

            String result = "第" + i + "次（" + x + "，" + y + "）";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                // System.out.println(result);
            }
        }

    }
}
