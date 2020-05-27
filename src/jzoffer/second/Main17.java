package jzoffer.second;

import util.ConstructTree;
import util.TreeNode;

/**
 * @Author ll
 * @Date 2020/4/29 16:10
 */
public class Main17 {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root1 = ConstructTree.constructTree(new Integer[]{1, 2, 3});
        TreeNode root2 = ConstructTree.constructTree(new Integer[]{2, 6});
        System.out.println(hasSubtree(root1, root2));
    }

    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        if(hasSubtreeHelper(root1, root2)) {
            return true;
        }
        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public static boolean hasSubtreeHelper(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return hasSubtreeHelper(root1.left, root2.left) && hasSubtreeHelper(root1.right, root2.right);
    }

}
