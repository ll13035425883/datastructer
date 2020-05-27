package jzoffer.first;

import util.ConstructTree;
import util.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @author ll
 */
public class Main24 {

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = ConstructTree.constructTree(nums);
        ArrayList<ArrayList<Integer>> path = findPath(root, 22);
        for (ArrayList<Integer> arrayList : path) {
            for (int i = 0; i < arrayList.size(); i++) {
                if(i != arrayList.size() - 1) {
                    System.out.print(arrayList.get(i) + ",");
                } else {
                    System.out.println(arrayList.get(i));
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return list;
        }
        ArrayList<TreeNode> s = new ArrayList<>();
        TreeNode r = null;
        while(root != null || s.size() != 0) {
            if(root != null) {
                target -= root.val;
                s.add(root);
                root = root.left;
            } else {
                TreeNode t = s.get(s.size() - 1);
                if(t.right != null && t.right != r) {
                    root = t.right;
                } else {
                    if(target == 0) {
                        ArrayList<Integer> al = new ArrayList<>();
                        for (TreeNode treeNode : s) {
                            al.add(treeNode.val);
                        }
                        list.add(al);
                    }
                    s.remove(s.size() - 1);
                    target += t.val;
                    root = null;
                    r = t;
                }
            }
        }
        return list;
    }

}
