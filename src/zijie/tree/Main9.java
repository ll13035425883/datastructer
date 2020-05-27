package zijie.tree;

import util.TreeNode;

import java.util.*;

/**
 *  二叉树的锯齿形层次遍历
 *  https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1027/
 * @author ll
 */
public class Main9 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) {
            return lists;
        }
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
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
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }
}
