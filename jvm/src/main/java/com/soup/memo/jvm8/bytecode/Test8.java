package com.soup.memo.jvm8.bytecode;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-03-02 23:35
 * @since 1.0
 */
public class Test8 {
    public int calc() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        int result = (a + b -c) * d;
        return result;
    }
}
