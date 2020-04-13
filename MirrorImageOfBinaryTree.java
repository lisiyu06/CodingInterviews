/**
 * Author: lisiyu
 * Created: 2020/4/13
 */

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorImageOfBinaryTree {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root.right;
        root.right = root.left;
        root.left = cur;
        Mirror(root.left);
        Mirror(root.right);
    }
}
