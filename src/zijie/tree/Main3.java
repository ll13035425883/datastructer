package zijie.tree;

import util.ListNode;
import util.MyLinkedListUtil;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1022/
 * @author ll
 */
public class Main3 {
    public static void main(String[] args) {
        ListNode l1 = MyLinkedListUtil.createLinkedList_Tail(new int[]{1,8});
        ListNode l2 = MyLinkedListUtil.createLinkedList_Tail(new int[]{0});
        ListNode rs = addTwoNumbers(l1, l2);
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
        int m, t = 0;
        ListNode rs = new ListNode(-1);
        ListNode p = rs;
        while(l1 != null && l2 != null) {
            m = (l1.val + l2.val + t) % 10;
            t = (l1.val + l2.val + t) / 10;
            p.next = new ListNode(m);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            m = (l1.val + t) % 10;
            t = (l1.val + t) / 10;
            p.next = new ListNode(m);
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            m = (l2.val + t) % 10;
            t = (l2.val + t) / 10;
            p.next = new ListNode(m);
            p = p.next;
            l2 = l2.next;
        }
        if(t > 0) {
            p.next = new ListNode(t);
        }
        return rs.next;
    }
}
