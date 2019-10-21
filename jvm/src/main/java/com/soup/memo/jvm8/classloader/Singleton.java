package com.soup.memo.jvm8.classloader;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Singleton {

    private Singleton() {
    }

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }

    public static Object getInstance(boolean flag) {
        if (flag) {
            // 这里的新建数组，并不会执行LazyHolder的static的代码块，不属于主动使用类的7种情况
            return new LazyHolder[2];
        }

        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        getInstance(true);

        System.out.println("-------");

        getInstance(false);
    }
}
