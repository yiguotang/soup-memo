package com.soup.memo.designpattern.chainofresponsibility;

/**
 * 具体的处理者，是否相等处理类
 *
 * @author zhaoyi
 */
public class SpecialSupport extends Support {

    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
