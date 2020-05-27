package tree;

import util.ConstructTree;
import util.TreeNode;

import java.util.*;

public class DiameterOfBinaryTree {

    public static int diameterOfBinaryTree(TreeNode root) {
        Set<Character> s = new HashSet<>();
        if(root == null)
            return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            while(count-- > 0) {
                TreeNode tree = queue.poll();
                max = Math.max(levelTree(tree.left) + levelTree(tree.right), max);
                if(tree.left != null)
                    queue.offer(tree.left);
                if(tree.right != null)
                    queue.offer(tree.right);
            }
        }
        return max;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty())  {
            while(root != null) {
                list.add(root.val);
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        return list;
    }

    public static int levelTree(TreeNode root) {
        if(root ==  null)
            return 0;
        int lh = levelTree(root.left) + 1;
        int rh = levelTree(root.right) + 1;
        return lh > rh ? lh : rh;
    }

    public static void main(String[] args) {
//        Integer[] nums = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
//        TreeNode root = ConstructTree.constructTree(nums);
//        System.out.println(diameterOfBinaryTree(root));

        Integer[] nums = {1,2,3};
        TreeNode root = ConstructTree.constructTree(nums);
        preorderTraversal(root);
    }

}
