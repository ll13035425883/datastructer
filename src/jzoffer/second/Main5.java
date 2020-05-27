package jzoffer.second;

import java.util.Stack;

/**
 * @Author ll
 * @Date 2020/4/28 22:31
 */
public class Main5 {

    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    public static void main(String[] args) {

    }

    public static void push(int node) {
        s1.push(node);
    }

    public static int pop() {
        if(!s2.isEmpty()) {
            return s2.pop();
        } else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

}
