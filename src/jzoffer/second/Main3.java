package jzoffer.second;

import util.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author ll
 * @Date 2020/4/28 22:03
 */
public class Main3 {

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
     * @param args
     */
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode == null) {
            return arrayList;
        }
        ListNode p = listNode;
        while(p != null) {
            arrayList.add(p.val);
            p = p.next;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

}
