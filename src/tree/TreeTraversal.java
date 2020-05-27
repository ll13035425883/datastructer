package tree;

import util.TreeNode;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的遍历
 * @author ll
 */
public class TreeTraversal {

    public static void main(String[] args) {

    }

    /**
     * 层次遍历
     * @param root
     */
    public static void levelTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + ",");
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
}
