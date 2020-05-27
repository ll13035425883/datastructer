package zijie.tree;

import util.ListNode;
import util.MyLinkedListUtil;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1048/
 * @author ll
 */
public class Main1 {
    public static void main(String[] args) {
        ListNode l1 = MyLinkedListUtil.createLinkedList_Tail(new int[]{1, 2, 4});
        ListNode l2 = MyLinkedListUtil.createLinkedList_Tail(new int[]{1, 3, 4});
        ListNode mergeTwoLists = mergeTwoLists(l1, l2);
        MyLinkedListUtil.linkedListTravel(mergeTwoLists);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode p = null;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                if(head == null) {
                    head = l1;
                    p = head;
                } else {
                    p.next = l1;
                    p = p.next;
                }
                l1 = l1.next;
            } else {
                if(head == null) {
                    head = l2;
                    p = head;
                } else {
                    p.next = l2;
                    p = p.next;
                }
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            p.next = l1;
        }
        if(l2 != null) {
            p.next = l2;
        }
        return head;
    }
}
