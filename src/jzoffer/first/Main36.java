package jzoffer.first;

import util.ListNode;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * @author ll
 */
public class Main36 {

    public static void main(String[] args) {

    }

    /**
     * 利用栈
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode solution1(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode targetNode = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.peek() != stack2.peek()) {
                break;
            } else {
                targetNode = stack1.pop();
                stack2.pop();
            }
        }
        return targetNode;
    }

    /**
     * a + c + b = b + c + a
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode solution2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode h1 = pHead1, h2 = pHead2;
        while (h1 != h2) {
            h1 = h1 == null ? pHead2 : h1.next;
            h2 = h2 == null ? pHead1 : h2.next;
        }
        return h1;
    }

    /**
     * 先遍历较长的数组，当剩余长度与另一个数组一样时再共同遍历比较
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode solution3(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0, len2 = 0, d;
        ListNode h1 = pHead1, h2 = pHead2;
        while(h1 != null) {
            len1++;
            h1 = h1.next;
        }
        while(h2 != null) {
            len2++;
            h2 = h2.next;
        }
        h1 = pHead1;
        h2 = pHead2;
        if(len1 > len2) {
            d = len1 - len2;
            while(d-- > 0) {
                h1 = h1.next;
            }
        } else {
            d = len2 - len1;
            while(d-- > 0) {
                h2 = h2.next;
            }
        }
        while(h1 != null) {
            if(h1 == h2) {
                break;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }

}
