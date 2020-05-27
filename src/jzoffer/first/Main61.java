package jzoffer.first;

import tree.TreeTraversal;
import util.ConstructTree;
import util.TreeNode;

import java.util.Stack;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来
 * 的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是
 * 一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * @author ll
 */
public class Main61 {

    private static String serializeTarget = "";
    private static int i = 0;

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeTraversal.levelTraversal(root);
        String serializeTarget = serialize(root);
        System.out.println(serializeTarget);
        TreeTraversal.levelTraversal(deserialize(serializeTarget));
    }

    /**
     * 先序 序列化
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if(root == null) {
            serializeTarget += "#!";
            return "#";
        }
        serializeTarget += root.val + "!";
        serialize(root.left);
        serialize(root.right);
        return serializeTarget;
    }

    /**
     * 反序列化
     * @param str
     * @return
     */
    public static TreeNode deserialize(String str) {
        if(str == null || "#".equals(str)) {
            return null;
        }
        String[] strings = str.split("!");
        return createTree(strings);
    }

    /**
     * 先序构建树
     * @param val
     * @return
     */
    public static TreeNode createTree(String[] val) {
        TreeNode root;
        if("#".equals(val[i])) {
            i++;
            root = null;
        } else {
            root = new TreeNode(Integer.valueOf(val[i++]));
            root.left = createTree(val);
            root.right = createTree(val);
        }
        return root;
    }

}
