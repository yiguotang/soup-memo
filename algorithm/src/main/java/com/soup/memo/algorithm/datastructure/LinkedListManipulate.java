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

    // 头指针节点
    private Node head;

    // 尾指针节点
    private Node tail;

    // 链表长度
    private int size;

    /**
     * 链表插入
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        // 构造链表节点对象
        Node insertNode = new Node(data);

        if (size == 0) {
            // 链表长度为0，链表头则为插入节点，尾节点也是插入节点
            head = insertNode;
            tail = insertNode;
        } else if (index == 0) {
            // 链表非空，向链表头插入数据，将新插入的节点的next指向链表头，再将头赋值为当前节点
            insertNode.next = head;
            head = insertNode;
        } else if (size == index) {
            // 链表非空，向链表尾部插入数据，将链表最后一个节点指向新节点，再把尾节点赋值为新节点
            tail.next = insertNode;
            tail = insertNode;
        } else {
            // 链表非空，向链表中部插入数据，获取待插入位置的前一个数据节点pre，将pre节点的next设为新节点，新节点的next设为pre的next
            Node preNode = getNode(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }

        // 链表长度增加
        size++;
    }

    /**
     * 删除链表元素
     */
    public Node remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node removeNode;

        // 判断删除位置
        if (0 == index) {
            // 删除头
            removeNode = head;
            head = head.next;
        } else if (index == index - 1) {
            // 删除尾
            Node preNode = getNode(index - 1);
            removeNode = preNode.next;

            // 赋值null进行gc回收
            preNode.next = null;

            // 将尾节点赋值
            tail = preNode;
        } else {
            // 删除中间元素, 先找到删除元素的上一个元素
            Node preNode = getNode(index - 1);

            // 将删除的节点赋值给删除元素
            removeNode = preNode.next;

            // 删除：将删除元素的上一个元素，直接指向下下一个元素
            preNode.next = preNode.next.next;
        }

        size--;
        return removeNode;
    }

    /**
     * 查询链表元素
     *
     * @param index 链表位置
     * @return 链表中的节点
     */
    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    /**
     * 打印链表所有数据
     */
    public void outPut() {
        Node tmp = head;
        while (null != tmp) {
            log.info("{}", tmp.data);
            tmp = tmp.next;
        }
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

        public Node(int data) {
            this.data = data;
        }
    }
}
