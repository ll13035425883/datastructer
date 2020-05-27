package jzoffer.first;

import util.ConstructTree;
import util.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author ll
 */
public class Main39 {
    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(isBalancedSolution(root));
    }

    public static boolean isBalancedSolution(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        if(Math.abs(Main38.treeDepth(root.left) - Main38.treeDepth(root.right)) > 1) {
            return false;
        }
        return isBalancedSolution(root.left) && isBalancedSolution(root.right);
    }
}
