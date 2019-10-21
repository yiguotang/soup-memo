package com.soup.memo.jvm8.bytecode;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 19041060
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Fool {
    public static void main(String[] args) {
        boolean flag = true;

        if (flag) {
            System.out.println("hello");
        }

        if (flag == true) {
            System.out.println("hello jvm");
        }
    }
}
