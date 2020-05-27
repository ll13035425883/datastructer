package jzoffer.first;

import util.MyLinkedListUtil;
import util.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author ll
 */
public class Main56 {
    public static void main(String[] args) {
        ListNode linkedList_tail = MyLinkedListUtil.createLinkedList_Tail(new int[]{1,1,1,1,1,2});
        System.out.println("删除前：");
        MyLinkedListUtil.linkedListTravel(linkedList_tail);
        ListNode listNode = deleteDuplication(linkedList_tail);
        System.out.println("删除后：");
        MyLinkedListUtil.linkedListTravel(listNode);
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode q = pre;
        ListNode p = q.next;
        while(p != null) {
            if(q.val != p.val) {
                p = p.next;
                pre = q;
                q = pre.next;
            } else {
                while(p != null && p.val == q.val) {
                    p = p.next;
                }
                pre.next = p;
                q = pre.next;
                if(q != null) {
                    p = q.next;
                }
            }
        }
        return newHead.next;
    }
}
