package jzoffer.second;

import util.TreeNode;

/**
 * @Author ll
 * @Date 2020/4/28 22:06
 */
public class Main4 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果
     * 中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return constructTree(pre, 0, pre.length, in, 0, pre.length);
    }

    public static TreeNode constructTree(int[] pre, int pre_left, int pre_right, int[] in, int in_left,
                                         int in_right) {
        if(pre_left >= pre_right) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pre_left]);
        int count = 1;
        int i = in_left;
        for (; i < in_right; i++) {
            if(in[i] == pre[pre_left]) {
                break;
            }
            count++;
        }
        root.left = constructTree(pre, pre_left + 1, pre_left + count, in, in_left, i);
        root.right = constructTree(pre, pre_left + count, pre_right, in, i + 1, in_right);
        return root;
    }
}
