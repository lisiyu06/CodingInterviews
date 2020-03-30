import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: lisiyu
 * Created: 2020/3/30
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class PrintLinkedListFromTail2Head {
    /**
     * 1. 借助 list.add(index, value) , 非递归
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    /**
     * 2. 递归
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 3. 使用栈(后进先出)
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

}
