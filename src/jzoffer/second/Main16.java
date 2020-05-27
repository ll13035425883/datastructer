package jzoffer.second;

import util.ListNode;

/**
 * @Author ll
 * @Date 2020/4/29 16:02
 */
public class Main16 {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode p = null;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                if(head == null) {
                    head = list1;
                    p = head;
                } else {
                    p.next = list1;
                    p = p.next;
                }
                list1 = list1.next;
            } else {
                if(head == null) {
                    head = list2;
                    p = head;
                } else {
                    p.next = list2;
                    p = p.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 != null) {
            p.next = list1;
        }
        if(list2 != null) {
            p.next = list2;
        }
        return head;
    }

}
