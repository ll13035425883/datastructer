package jzoffer.first;

import util.ConstructTree;
import util.TreeNode;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 * 只能调整树中结点指针的指向。
 * @author ll
 */
public class Main26 {
    public static void main(String[] args) {
        Integer[] nums = {10,6,14,4,8,12,16};
        TreeNode root = ConstructTree.constructTree(nums);
        convert(root);
    }

    public static TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        TreeNode head = null;
        while(pRootOfTree != null || !s.isEmpty()) {
            while(pRootOfTree != null) {
                s.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            TreeNode node = s.pop();
            if(pre == null) {
                pre = node;
                head = node;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            pRootOfTree = node.right;
        }
        return head;
    }
}
