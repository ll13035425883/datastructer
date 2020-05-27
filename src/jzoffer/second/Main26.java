package jzoffer.second;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author ll
 * @Date 2020/5/21 21:52
 */
public class Main26 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
     * 只能调整树中结点指针的指向。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        TreeNode head = null;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(pRootOfTree != null || !stack.isEmpty()) {
            while(pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            TreeNode node = stack.pop();
            if(head == null) {
                head = node;
            } else {
                pre.right = node;
                node.left = pre;
            }
            pre = node;
            pRootOfTree = node.right;
        }
        return head;
    }
}
