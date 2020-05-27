package zijie.tree;

import util.ListNode;
import util.MyLinkedListUtil;

/**
 *  排序链表
 *  在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *  https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1040/
 * @author ll
 */
public class Main4 {
    public static void main(String[] args) {
        ListNode l1 = MyLinkedListUtil.createLinkedList_Tail(new int[]{4,3,1,2});
        ListNode rs = sortList(l1);
        MyLinkedListUtil.linkedListTravel(rs);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next, pre = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        pre = slow;
        slow = slow.next;
        pre.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        return merge(l, r);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
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
