/**
 * Author: lisiyu
 * Created: 2020/4/24
 */

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BinarySearchTreeAndDoubleLinkedlist {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        middleOrder(pRootOfTree, list);
        return pointer(list);
    }
    // 1. 中序遍历，遍历结果放入 list 中
    private void middleOrder(TreeNode pRootOfTree, ArrayList<TreeNode> list) {
        if (pRootOfTree != null) {
            middleOrder(pRootOfTree.left, list);
            list.add(pRootOfTree);
            middleOrder(pRootOfTree.right, list);
        }
    }
    // 2. 指定指针
    private TreeNode pointer(ArrayList<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }
}
