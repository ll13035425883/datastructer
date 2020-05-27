package lc;

import java.util.Stack;

/**
 *  有效括号的嵌套深度
 *
 *  https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * @author ll
 */
public class Main1111 {

    public static void main(String[] args) {
        int[] depthAfterSplit = maxDepthAfterSplit2("()(())()");
        for (int i : depthAfterSplit) {
            System.out.print(i + ",");
        }
    }

    public static int[] maxDepthAfterSplit(String seq) {
        if(seq == null || "".equals(seq)) {
            return null;
        }
        int[] targetSeq = new int[seq.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < seq.length(); i++) {
            if(seq.charAt(i) == ')') {
                stack.pop();
                if(stack.size() % 2 == 0) {
                    targetSeq[i] = 0;
                } else {
                    targetSeq[i] = 1;
                }
            } else {
                stack.push(i);
                if(stack.size() % 2 == 0) {
                    targetSeq[i] = 1;
                } else {
                    targetSeq[i] = 0;
                }
            }
        }
        return targetSeq;
    }

    public static int[] maxDepthAfterSplit2(String seq) {
        int[] targetSeq = new int[seq.length()];
        int d = 0;
        int i = 0;
        for (char c : seq.toCharArray()) {
            if(c == '(') {
                d++;
                targetSeq[i++] = d % 2;
            } else {
                targetSeq[i++] = d % 2;
                d--;
            }
        }
        return targetSeq;
    }

}
