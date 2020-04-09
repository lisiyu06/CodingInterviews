/**
 * Author: lisiyu
 * Created: 2020/4/9
 */

/**
 * 合并两个有序链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoOrderedLists {

    public ListNode Merge1(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

    // 递归
    public ListNode Merge3(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge3(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge3(list1, list2.next);
            return list2;
        }
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                //把cur1指向的结点插入到新链表的尾部
                if (newHead == null) {
                    //新链表为空
                    newHead = cur1;
                    newTail = cur1;
                    cur1 = cur1.next;
                } else {
                    //新链表不为空
                    newTail.next = cur1;
                    //更新尾部指向
                    newTail = newTail.next;
                    cur1 = cur1.next;
                }
            } else {
                //把cur2指向的结点插入到新链表的尾部
                if (newHead == null) {
                    newHead = cur2;
                    newTail = cur2;
                    cur2 = cur2.next;
                } else {
                    newTail.next = cur2;
                    newTail = newTail.next;
                    cur2 = cur2.next;
                }
            }
        }
        //判断哪个链表到达尾部，哪个链表还有剩余
        if (cur1.next == null) {
            //cur2还有剩余
            newTail.next = cur2;
        } else {
            //cur1还有剩余
            newTail.next = cur1;
        }
        return newHead;
    }
}
