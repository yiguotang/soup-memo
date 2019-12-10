package com.soup.memo.designpattern.chainofresponsibility;

/**
 * 具体的处理者，解决奇数问题
 *
 * @author zhaoyi
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }
}
