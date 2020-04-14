/**
 * Author: lisiyu
 * Created: 2020/4/14
 */

import java.util.Stack;

/**
 * 包含 min 函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class StackContainingMinFunction {

    // A 用来表示正常的栈中的数据
    // B 用来储存每一层 A 栈帧中对应的最小值
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    // 1. 将元素 x 推入栈中
    public void push(int node) {
        // 先把 node 插入到 栈A 中
        A.push(node);
        // 如果 栈B 为空，则将 node 插入到 栈B 中，即定义 node 为 最小值
        if (B.isEmpty()) {
            B.push(node);
            return;
        }
        // 如果 栈B 不为空，将 栈B 的栈顶元素与 node 比较，选择最小值入栈
        int min = B.peek();
        if (node < min) {
            min = node;
        }
        B.push(min);
    }

    // 2. 删除栈顶元素
    public void pop() {
        if (A.isEmpty()) {
            return;
        }
        A.pop();
        B.pop();
    }

    // 3. 获取栈顶元素
    public int top() {
        return A.peek();
    }

    // 4. 检索栈中最小元素
    public int min() {
        return B.peek();
    }

}
