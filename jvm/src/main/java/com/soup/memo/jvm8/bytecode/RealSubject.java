package com.soup.memo.jvm8.bytecode;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-03-03 0:06
 * @since 1.0
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("from real subject");
    }
}
