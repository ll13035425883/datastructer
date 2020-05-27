package tree;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.util.*;

public class InorderTraversal {

    // 非递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i = 0;i < count;i++) {
                TreeNode tree = queue.poll();
                levelNodes.add(tree.val);
                if(tree.left != null)
                    queue.offer(tree.left);
                if(tree.right != null)
                    queue.offer(tree.right);
            }
            if(!flag)
                // 右 -> 左
                Collections.reverse(levelNodes);
            list.add(levelNodes);
            flag = !flag;
        }
        return list;
    }

    public static int[] findMode(TreeNode root) {
        int  max = 0;
        int currentNode = -9999, currentNodeNums = 0;
        if(root == null)
            return new int[0];
        List<Integer> nums = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tree = stack.pop();
            if(currentNodeNums == 0) {
                currentNodeNums++;
                currentNode = tree.val;
            } else if(tree.val == currentNode)
                currentNodeNums++;
            else {
                currentNodeNums = 1;
                currentNode = tree.val;
            }
            if(currentNodeNums > max) {
                max = currentNodeNums;
                nums.clear();
                nums.add(currentNode);
            } else if(currentNodeNums == max) {
                nums.add(currentNode);
            }
            if(tree.right != null)
                root = tree.right;
        }
        int a[] = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            a[i] = nums.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(2);
//        int[] mode = findMode(treeNode);
//        for (int i = 0; i < mode.length; i++) {
//            System.out.println(mode[i]);
//        }
        List<List<Integer>> lists = zigzagLevelOrder(treeNode);
        System.out.println(1111);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
