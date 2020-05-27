package jzoffer.second;

import java.util.Stack;

/**
 * @Author ll
 * @Date 2020/5/5 16:16
 */
public class Main21 {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压
     * 栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序
     * 列的长度是相等的）
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    public static boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (k < popA.length && stack.peek() == popA[k]) {
                stack.pop();
                k++;
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
