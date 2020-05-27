package jzoffer.second;

import util.ListNode;
import util.MyLinkedListUtil;

/**
 * @Author ll
 * @Date 2020/4/29 11:27
 */
public class Main14 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param args
     */
    public static void main(String[] args) {
        ListNode linkedList_tail = MyLinkedListUtil.createLinkedList_Tail(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(findKthToTail(linkedList_tail, 0));
    }

    public static ListNode findKthToTail(ListNode head, int k) {
        if(k <= 0 || head == null) {
            return null;
        }
        ListNode p = head, q = head;
        while(k-- > 0) {
            p = p.next;
            // 判断k大于链表长度的情况
            if(p == null && k != 0) {
                return null;
            }
        }
        while(p != null) {
            q = q.next;
            p = p.next;
        }
        return q;
    }

}
