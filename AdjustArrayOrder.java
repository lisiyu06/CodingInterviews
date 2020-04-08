/**
 * Author: lisiyu
 * Created: 2020/4/8
 */

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class AdjustArrayOrder {
    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;
        for (int i = 1; i < n; i++) {
            // 当前元素是奇数，就移动到奇数序列
            if (array[i] % 2 != 0) {
                int value = array[i];
                int cur = i;
                while (cur > 0 && (array[cur - 1] % 2 == 0)) {
                    array[cur] = array[cur - 1];
                    cur--;
                }
                array[cur] = value;
            }
            // 当前元素是偶数，无须移动
        }
    }
}
