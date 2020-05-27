package jzoffer.second;

import java.util.Stack;

/**
 * @Author ll
 * @Date 2020/4/29 17:19
 */
public class Main20 {

    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static void push(int node) {
        s1.push(node);
        if(!s2.isEmpty()) {
            if(node < s2.peek()) {
                s2.push(node);
            }
        } else {
            s2.push(node);
        }
    }

    public static void pop() {
        int val = s1.pop();
        if(val == s2.peek()) {
            s2.pop();
        }
    }

    public static int top() {
        return s1.peek();
    }

    public static int min() {
        return s2.peek();
    }
}
