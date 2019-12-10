package com.soup.memo.designpattern.chainofresponsibility;

/**
 * 责任链测试类
 *
 * @author zhaoyi
 */
public class Main {

    public static void main(String[] args) {
        // 先构建一些处理类
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("bob", 100);
        Support charlie = new SpecialSupport("Charlie", 439);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        // 将这些处理类“链接”在一起
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        // 构建一些问题，让责任链去处理
        for (int i = 0; i < 500; i++) {
            alice.support(new Trouble(i));
        }
    }

}
