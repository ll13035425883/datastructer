package jzoffer.second;

import java.util.TimerTask;

/**
 * @Author ll
 * @Date 2020/5/5 16:27
 */
public class Main23 {
    /**
     * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(verifySequenceOfBST(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

    public static boolean verifySequenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 1) {
            return true;
        }
        return verifySequenceOfBSTHelper(sequence, 0, sequence.length);
    }

    private static boolean verifySequenceOfBSTHelper(int[] sequence, int left, int right) {
        if(left >= right) {
            return true;
        }
        int rootVal = sequence[right - 1];
        int i = 0;
        // 找到第一个比根节点大的结点，其之前都划为左子树，之后（包括其）划为右子树
        for(;i < right - 1;i++) {
            if(sequence[i] > rootVal) {
                break;
            }
        }
        // 判断右子树是否都大于根节点
        for(int j = i;j < right - 1;j++) {
            if(sequence[j] < rootVal) {
                return false;
            }
        }
        return verifySequenceOfBSTHelper(sequence, left, i)
                && verifySequenceOfBSTHelper(sequence, i, right - 1);
    }

}
