package com.soup.memo.designpattern.chainofresponsibility;

import lombok.Data;

/**
 * 需要处理的对象
 *
 * @author zhaoyi
 */
@Data
public class Trouble {

    private int number;

    public Trouble(int number) {
        this.number = number;
    }
}
