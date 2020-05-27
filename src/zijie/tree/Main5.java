package zijie.tree;

import util.ListNode;

import java.util.HashSet;

/**
 * 环形链表 II
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1023/
 * @author ll
 */
public class Main5 {
    public static void main(String[] args) {

    }

    /**
     * 空间复杂度： O(n)
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        while(head != null) {
            if(!nodes.contains(head)) {
                nodes.add(head);
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

    /**
     * 快慢指针，空间复杂度 O(1)
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while(true) {
            if(fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            // 第一次相遇
            if(fast == slow) {
                break;
            }
        }
        // 快指针重回起点
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
