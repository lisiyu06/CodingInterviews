/**
 * Author: lisiyu
 * Created: 2020/4/9
 */

/**
 * 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

public class ReverseLinkedList {
    public ListNode ReverseList(ListNode head) {
        // 1. 链表为空的情况
        if (head == null) {
            return null;
        }
        // 2. 链表只有一个结点的情况
        if (head.next == null) {
            return head;
        }
        // 3. 一般情况
        ListNode pre = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // cur 已经指向最后一个结点
                newHead = cur;
            }
            // 反转
            cur.next = pre;
            // 更新 pre 和 cur
            pre = cur;
            cur = next;
        }
        return newHead;
    }
}
