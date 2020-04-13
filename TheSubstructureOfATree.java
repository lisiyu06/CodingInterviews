/**
 * Author: lisiyu
 * Created: 2020/4/13
 */

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class TheSubstructureOfATree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 两树任一为空，则返回 false
        if (root1 ==null || root2 == null) {
            return false;
        }
        // root2 是 root1 的子结构，有三种情况：
        // (1) root2 是 root1 的一个子结构
        // (2) root2 是 root1 的左子树的一个子结构
        // (3) root2 是 root1 的右子树的一个子结构
        return curTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    // 具体判断 树B 是否是 树A 的子结构
    public boolean curTree(TreeNode A, TreeNode B) {
        // 如果 树B 的结点为 null，则表明已经 树B 已经遍历完成，则 树B 一定是 树A 的子结构，返回 true
        if (B == null) {
            return true;
        }
        // (1) 如果 树A 的结点为 null，则表明已经 树A 已经遍历完成，意味着并未找到与 树B 相同的结点，则返回 false
        // (2) 如果两树的根结点不同，则 树B 一定不是是 树A 的子结构，返回 false
        if (A == null || A.val != B.val) {
            return false;
        }
        // 此时，两树的根结点相同，则循环查找两树的左右子树的根结点是否都相同，若相同，则返回 true
        return curTree(A.left, B.left) && curTree(A.right, B.right);
    }

}
