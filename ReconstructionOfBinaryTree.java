/**
 * Author: lisiyu
 * Created: 2020/3/31
 */

import java.util.Arrays;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 递归
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class ReconstructionOfBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // 空树的情况
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        // 非空的情况
        // 树的根是前序遍历的第一个元素
        TreeNode root = new TreeNode(pre[0]);
        // 在中序遍历中找到二叉树的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i+1),
                        Arrays.copyOfRange(in, 0, i));
                // 右子树
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i+1, pre.length),
                        Arrays.copyOfRange(in, i+1, in.length));
                break;
            }
        }
        return root;
    }
}
