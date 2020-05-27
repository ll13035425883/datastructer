package util;

/**
 * 创建链表
 * @author ll
 */
public class MyLinkedListUtil {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode linkedList_tail = createLinkedList_Tail(arr);
        while(linkedList_tail != null) {
            System.out.print(linkedList_tail.val + "\t");
            linkedList_tail = linkedList_tail.next;
        }
        System.out.println();
        ListNode linkedList_top = createLinkedList_Top(arr);
        while(linkedList_top != null) {
            System.out.print(linkedList_top.val + "\t");
            linkedList_top = linkedList_top.next;
        }
    }

    /**
     * 尾插法
     * @param arr
     * @return
     */
    public static ListNode createLinkedList_Tail(int[] arr) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head.next;
    }

    /**
     * 头插法
     * @param arr
     * @return
     */
    public static ListNode createLinkedList_Top(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            node.next = p.next;
            p.next = node;
        }
        return head.next;
    }

    /**
     * 遍历链表
     * @param head
     */
    public static void linkedListTravel(ListNode head) {
        while(head != null) {
            if(head.next == null) {
                System.out.println(head.val);
            } else {
                System.out.print(head.val + "->");
            }
            head = head.next;
        }
    }

}
