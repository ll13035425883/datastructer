package zijie.tree;

import util.ListNode;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1024/
 * @author ll
 */
public class Main6 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
