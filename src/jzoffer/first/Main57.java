package jzoffer.first;

import util.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author ll
 */
public class Main57 {
    public static void main(String[] args) {

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e
     * 来源：牛客网
     *
     * 1.二叉树为空，则返回空；
     * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
     * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
     * @param pNode
     * @return
     */
    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null) {
            return null;
        }
        // 右子树不为空，那么其下一个结点就在其右子树
        if(pNode.right != null) {
            pNode = pNode.right;
            while(pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            // 右子树为空则向其父节点方向查找
            TreeLinkNode fatherNode = pNode.next;
            while(fatherNode != null) {
                if(fatherNode.left == pNode) {
                    // 是其父结点的左孩子
                    return fatherNode;
                }
                // 是其父结点的右孩子
                pNode = fatherNode;
                fatherNode = fatherNode.next;
            }
        }
        return null;
    }
}
