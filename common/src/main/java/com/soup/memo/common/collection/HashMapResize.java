package com.soup.memo.common.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * 关于hashmap扩容的场景，调用带初始大小的构造方法
 * 传入1w和传入1k的初始大小，是不同的
 *
 * @author zhaoyi
 */
@Slf4j
public class HashMapResize {

    public static void main(String[] args) {
        log.info("{}", tableSizeFor(10000));
        log.info("{}", tableSizeFor(1000));
        log.info("{}", tableSizeFor(2));

        HashMap<String, String> map = new HashMap<>();
        map.put("string", "test");
        map.put(null, null);
        log.info("{}", map);
    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
