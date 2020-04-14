/**
 * Author: lisiyu
 * Created: 2020/4/14
 */

import java.util.Stack;

/**
 * 栈的压入，弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class StackPushPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        // 创建一个新的栈，将 pushA 的元素依次入栈
        Stack<Integer> B = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            // 将 pushA 的元素依次入栈
            B.push(pushA[i]);
            // 判断新栈的栈顶元素是否与 popA 相等
            // (1) 相等，B 出栈，继续判断新的栈顶元素与下一个数组元素
            // (2) 不相等，B 中继续入栈
            while (!B.isEmpty() && B.peek() == popA[j]) {
                B.pop();
                j++;
            }
        }
        // 若 B 所有元素都出栈，即 B 为空，返回 true，证明是弹出序列
        // 若 B 中仍有元素为出栈，返回 false，证明不是弹出序列
        return B.isEmpty();
    }
}
