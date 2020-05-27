package jzoffer.first;

import util.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 比较正确的思想： 设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，
 * 一定相遇于环中某点(结论1)。接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口(结论2)。
 * @author ll
 */
public class Main55 {
    public static void main(String[] args) {

    }

    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(pHead);
        ListNode p = pHead.next;
        while(p != null) {
            for (ListNode listNode : listNodes) {
                if(p.next == listNode) {
                    return listNode;
                }
            }
            listNodes.add(p);
            p = p.next;
        }
        return null;
    }

    public static ListNode entryNodeOfLoop2(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        HashSet<ListNode> listNodes = new HashSet<>();
        while(pHead != null) {
            if(!listNodes.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }
}
