package leetcode100;

import util.ListNode;
import util.MyLinkedListUtil;

/**
 * @Author ll
 * @Date 2020/5/27 23:18
 */
public class TwoNumsAdd {
    /**
     * 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param args
     */
    public static void main(String[] args) {
        ListNode num1 = MyLinkedListUtil.createLinkedList_Tail(new int[]{2, 4, 3});
        ListNode num2 = MyLinkedListUtil.createLinkedList_Tail(new int[]{5, 6, 4});
        ListNode rs = addTwoNumbers(num1, num2);
        MyLinkedListUtil.linkedListTravel(rs);
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int t = 0;
        int m;
        ListNode head = new ListNode(-1);
        ListNode rs = head;
        while (l1 != null && l2 != null) {
            m = (l1.val + l2.val + t) % 10;
            t = (l1.val + l2.val + t) / 10;
            l1 = l1.next;
            l2 = l2.next;
            rs.next = new ListNode(m);
            rs = rs.next;
        }
        while (l1 != null) {
            m = (l1.val + t) % 10;
            t = (l1.val + t) / 10;
            l1 = l1.next;
            rs.next = new ListNode(m);
            rs = rs.next;
        }
        while (l2 != null) {
            m = (l2.val + t) % 10;
            t = (l2.val + t) / 10;
            l2 = l2.next;
            rs.next = new ListNode(m);
            rs = rs.next;
        }
        if(t > 0) {
            rs.next = new ListNode(t);
        }
        return head.next;
    }
}
