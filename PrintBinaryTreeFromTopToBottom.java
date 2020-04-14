import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: lisiyu
 * Created: 2020/4/14
 */

/**
 * 从上到下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTreeFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        // 创建一个队列辅助进行遍历
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        // 1. 先把 root 插入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 2. 循环取队首元素.
            TreeNode node = queue.poll();
            // 3. 将当前队首元素放入队列尾部
            list.add(node.val);
            // 3. 把当前这个队首元素左子树和右子树都插入队列中.
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }
}
