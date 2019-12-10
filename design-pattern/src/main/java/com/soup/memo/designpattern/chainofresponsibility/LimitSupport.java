package com.soup.memo.designpattern.chainofresponsibility;

/**
 * 具体的处理者，解决问题访问的实现类
 *
 * @author zhaoyi
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit;
    }
}
