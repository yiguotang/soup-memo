package com.soup.memo.leetcode.list;

/**
 * <p>
 *  链表node
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-24 22:45
 * @since 1.0
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) { val = x; }

    String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val).append(",");

        ListNode head = this.next;
        while (null != head) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        return sb.toString();
    }
}
