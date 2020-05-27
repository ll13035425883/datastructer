package jzoffer.second;

import util.TreeNode;

/**
 * @Author ll
 * @Date 2020/4/29 16:34
 */
public class Main18 {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static void mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

}
