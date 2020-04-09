/**
 * Author: lisiyu
 * Created: 2020/4/9
 */

// 链表中的第 K 结点

public class TheLastKNodeInTheList {
    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null) {
            return null;
        }

        int len = size(head);
        if (k > len || k < 0) {
            return null;
        }

        int offset = len - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private int size(ListNode head) {
        int size = 0;
        for (ListNode cur = head;
                cur != null;
                cur = cur.next) {
            size++;
        }
        return size;
    }
}
