package zijie.tree;

import util.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1038/
 * @author ll
 */
public class Main2 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode p = head, q = head.next;
        while(p != null) {
            p.next = newHead.next;
            newHead.next = p;
            p = q;
            if(q != null) {
                q = q.next;
            }
        }
        return newHead.next;
    }
}
