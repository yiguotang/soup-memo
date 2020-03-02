package com.soup.memo.leetcode.list;

/**
 * <p>
 *  请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * </p>
 *
 * @author zhaoyi
 * @date 2020-03-02 22:16
 * @since 1.0
 */
public class Palindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(new Palindrome().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        String temp = "";
        ListNode current = head;
        while (null != current) {
            temp += current.val;
            current = head.next;
        }

        String tempReverse = "";
        char[] chars = temp.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            tempReverse += chars[i];
        }

        return temp.equals(tempReverse);
    }
}
