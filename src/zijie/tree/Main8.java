package zijie.tree;

import util.ListNode;
import util.TreeNode;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1026/
 * @author ll
 */
public class Main8 {

    private static TreeNode ans;

    public static void main(String[] args) {

    }

    public static boolean reverseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if(currentNode == null) {
            return false;
        }

        // 如果left等于1则代表左子树有所找结点
        int left = reverseTree(currentNode.left, p, q) ? 1 : 0;

        // 如果right等于1则代表右子树有所找结点
        int right = reverseTree(currentNode.right, p, q) ? 1 :0;

        // 查看当前结点是不是要找结点
        int mid = (currentNode == p) || (currentNode == q) ? 1 : 0;

        // 左子树和当前结点和右子树中有两个为true,则代表当前结点就是最近公共祖先
        if(mid + left + right >= 2) {
            ans = currentNode;
        }

        return (mid + left + right > 0);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        reverseTree(root, p, q);
        return ans;
    }
}
