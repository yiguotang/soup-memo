package com.soup.memo.algorithm.datastructure;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  链表结构相关操作 <br/>
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-17 21:21
 * @since 1.0
 */
@Data
@Slf4j
public class LinkedListManipulate {

}

@Data
class Node {
    /**
     * 当前节点中存储的value
     */
    private int data;

    /**
     * 下一个节点对象
     */
    private Node next;
}
