/**
 * Author: lisiyu
 * Created: 2020/4/15
 */

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

/**
 * 二叉搜索树: (1) 左子树中所有节点的值 < 根节点的值
 *           (2) 右子树中所有节点的值 > 根节点的值
 *           (3) 其左、右子树也分别为二叉搜索树
 * 后序遍历：最后一个结点为根节点
 */
public class PostorderTraversalOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return recursion(sequence, 0, sequence.length - 1);
    }
    private boolean recursion(int[] array, int i, int j) {
        // 二叉树只有一个结点的情况，不用处理，返回 ture
        if (i == j) {
            return true;
        }
        // 从前往后遍历数组，知道找到大于根节点的结点，即大于最后一个结点的结点，停下来
        int p = i;
        while (array[p] < array[j]) {
            p++;
        }
        // 此时可划分左子树区间[i, m-1] 和 右子树区间[m, j-1]
        int m = p;
        while (array[p] > array[j]) {
            p++;
        }
        // 若 p == j, 遍历结束，此树正确；
        // 递归判断左右子树，若均正确，则原数组为 true
        return p == j && recursion(array, i, m - 1) && recursion(array, m, j - 1);
    }
}
