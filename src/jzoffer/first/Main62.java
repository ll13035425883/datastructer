package jzoffer.first;

import util.ConstructTree;
import util.TreeNode;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 * @author ll
 */
public class Main62 {

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{5, 3, 7, 2, 4, 6, 8});
        System.out.println(kthNode(root, 3).val);
    }

    public static TreeNode kthNode(TreeNode pRoot, int k) {
        if(k <= 0 || pRoot == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(pRoot != null || !stack.isEmpty()) {
            while(pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            TreeNode node = stack.pop();
            k--;
            if(k == 0) {
                return node;
            }
            pRoot = node.right;
        }
        return null;
    }

}
