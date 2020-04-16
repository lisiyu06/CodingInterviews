/**
 * Author: lisiyu
 * Created: 2020/4/16
 */

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

// 时间复杂度：O(N), N 为二叉树的节点数，先序遍历需要遍历所有节点。
// 空间复杂度：O(N), 最差情况下，即树退化为链表时，path 存储所有树节点，使用 O(N)O(N) 额外空间。
public class PathWithACertainValueInBT {

    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();  // 放置返回的符合条件的路径
    private ArrayList<Integer> path = new ArrayList<>();  // 当前判断路径

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        // 先序遍历，将root先放入 path 中
        path.add(root.val);
        // 目标数减去root值，再进行左结点遍历
        target -= root.val;
        // target 减至 0，root再无左右节点，则将此路径保存至 lists 中
        if (target == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(path));
        }
        // 递归
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 本次递归结束后，已经得到了正确的 path 路径，
        // 再返回上一层时，需要将本层结点去除，下次遍历得到的才会是正确的 path 路径
        path.remove(path.size() - 1);
        return lists;
    }
}
