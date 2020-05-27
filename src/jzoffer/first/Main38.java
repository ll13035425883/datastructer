package jzoffer.first;

import util.ConstructTree;
import util.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * @author ll
 */
public class Main38 {
    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(treeDepth(root));
    }

    public static int treeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
