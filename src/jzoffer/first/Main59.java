package jzoffer.first;

import util.ConstructTree;
import util.TreeNode;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * @author ll
 */
public class Main59 {

    public static void main(String[] args) {
        TreeNode node = ConstructTree.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        ArrayList<ArrayList<Integer>> print = print(node);
        for (ArrayList<Integer> list : print) {
            for (Integer l : list) {
                System.out.print(l + ",");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot == null) {
            return lists;
        }
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while(!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(!flag) {
                Collections.reverse(list);
            }
            lists.add(list);
            flag = !flag;
        }
        return lists;
    }
}
