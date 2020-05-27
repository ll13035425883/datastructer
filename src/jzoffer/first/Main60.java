package jzoffer.first;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层次遍历
 * @author ll
 */
public class Main60 {

    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot == null) {
            return lists;
        }
        int count, i;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list;
        queue.offer(pRoot);
        while(!queue.isEmpty()) {
            count = queue.size();
            list = new ArrayList<>();
            for (i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
