/**
 * Author: lisiyu
 * Created: 2020/4/17
 */

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicateNodesInLinkedList {
    public ListNode deleteDuplication(ListNode pHead) {
        //先创建一个新的链表，用来放置不重的元素
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null
                    && cur.val == cur.next.val) {
                // 删除重复结点
                while(cur.next != null
                        && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else  {
                //当前这个结点不是重复结点
                //就把这个结点插入新链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        } //end while
        return newHead.next;
    }
}
