package com.soup.memo.leetcode.list;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaoyi
 * @date 2020-02-24 22:46
 * @since 1.0
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(1);
        head.next = next;
        ListNode next2 = new ListNode(2);
        next.next = next2;

        ListNode result = solution(head);
        if (null == result) {

        } else {
            System.out.println(result.print());
        }

    }

    private static ListNode solution(ListNode head) {
        ListNode current = head;
        while (null != current && null != current.next) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
