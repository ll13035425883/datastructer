package zijie.tree;

import util.ListNode;

/**
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1025/
 * @author ll
 */
public class Main7 {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            node = merge(node, lists[i]);
        }
        return node;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
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
                    p = l1;
                } else {
                    p.next = l1;
                    p = p.next;
                }
                l1 = l1.next;
            } else {
                if(head == null) {
                    head = l2;
                    p = l2;
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
