package jzoffer.first;

import util.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author ll
 */
public class Main58 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }

    public static boolean isSymmetricalHelper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isSymmetricalHelper(left.left, right.right) && isSymmetricalHelper(left.right, right.left);
    }

}
