package jzoffer.second;


/**
 * @Author ll
 * @Date 2020/5/5 21:19
 */
public class Main25 {

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针
     * random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
     *  （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param args
     */
    public static void main(String[] args) {

    }

    public static RandomListNode clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode p = newHead;
        RandomListNode q = pHead;
        while(q != null) {
            p.next = new RandomListNode(q.label);
            p = p.next;
            q = q.next;
        }
        p = newHead.next;
        q = pHead;
        RandomListNode temp = pHead;
        RandomListNode temp2 = newHead;
        while(q != null) {
            if(q.random == null) {
                q = q.next;
                p = p.next;
                continue;
            }
            temp = pHead;
            temp2 = newHead.next;
            while(q.random != temp) {
                temp = temp.next;
                temp2 = temp2.next;
            }
            p.random = temp2;
            p = p.next;
            q = q.next;
        }
        return newHead.next;
    }

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}
