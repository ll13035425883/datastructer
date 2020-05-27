package jzoffer.second;

import util.TreeNode;

import java.util.ArrayList;

/**
 * @Author ll
 * @Date 2020/5/5 20:44
 */
public class Main24 {

    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root == null) {
            return lists;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        TreeNode r = null;
        while(root != null || nodeList.size() > 0) {
            while(root != null) {
                nodeList.add(root);
                target -= root.val;
                root = root.left;
            }
            TreeNode node = nodeList.get(nodeList.size() - 1);
            if(node.right != null && r != node.right) {
                root = node.right;
            } else {
                if(node.left == null && node.right == null) {
                    if(target == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        for (TreeNode treeNode : nodeList) {
                            list.add(treeNode.val);
                        }
                        lists.add(list);
                    }
                }
                nodeList.remove(nodeList.size() - 1);
                r = node;
                target += node.val;
                root = null;
            }
        }
        return lists;
    }

}
