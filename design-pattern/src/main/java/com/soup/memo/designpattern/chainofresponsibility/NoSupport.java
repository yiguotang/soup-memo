package com.soup.memo.designpattern.chainofresponsibility;

/**
 * 具体的处理者，责任链的一个实现：永不解决问题的Support实现类
 *
 * @author zhaoyi
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
