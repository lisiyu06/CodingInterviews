/**
 * Author: lisiyu
 * Created: 2020/4/23
 */

/**
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class ReplicationOfComplexLinkedList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 1. 拷贝链表
        // 复制每个结点，使复制后的结点都在当前节点的下一个结点
        copy(pHead);
        // 2. 指定随机指针
        // 原生链表的节点的指向任意节点，使复制的节点也都指向某一任意节点
        randomDirect(pHead);
        // 3. 拆分
        // 重新连接节点，把原生节点重新连接起来，把克隆后的节点连接起来
        return reList(pHead);
    }
    // 1. 拷贝链表
    private void copy(RandomListNode pHead) {
        while (pHead != null) {
            RandomListNode cloneNode = new RandomListNode(pHead.label);
            RandomListNode nextNode = pHead.next;
            pHead.next = cloneNode;
            cloneNode.next = nextNode;
            pHead = nextNode;
        }
    }
    // 2. 指定随机指针
    private void randomDirect(RandomListNode pHead) {
        while (pHead != null) {
            RandomListNode cloneNode = pHead.next;
            if (pHead.random != null) {
                RandomListNode direct = pHead.random;
                cloneNode.random = direct.next;
            }
            pHead = cloneNode.next;
        }
    }
    // 3. 拆分
    private RandomListNode reList(RandomListNode pHead) {
        RandomListNode cloneNode = pHead.next;
        RandomListNode cloneHead = cloneNode;
        pHead.next = cloneNode.next;
        pHead = pHead.next;
        while (pHead != null) {
            cloneNode.next = pHead.next;
            pHead.next = pHead.next.next;
            pHead = pHead.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }
}
