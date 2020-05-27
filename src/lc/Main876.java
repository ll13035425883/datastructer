package lc;

import util.MyLinkedListUtil;
import util.ListNode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author ll
 */
public class Main876 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = MyLinkedListUtil.createLinkedList_Tail(arr);
        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int len = 0;
        while(p != null) {
            p = p.next;
            len++;
        }
        len = len / 2;
        p = head;
        while(len-- > 0) {
            p = p.next;
        }
        return p;
    }

    /**
     * 快指针q每次走2步，慢指针p每次走1步，当q走到末尾时p正好走到中间。
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        return p;
    }
}
