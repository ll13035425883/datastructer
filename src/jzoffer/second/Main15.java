package jzoffer.second;

import util.ListNode;

/**
 * @Author ll
 * @Date 2020/4/29 15:58
 */
public class Main15 {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode p = head, q;
        while(p != null) {
            q = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = q;
        }
        return newHead.next;
    }
}
