/**
 * Author: lisiyu
 * Created: 2020/4/5
 */

/**
 * 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1InBinary {

    // 两种方法的时间复杂度和空间复杂度均为 O(1)

    // 法 1
    public int NumberOf11(int n) {
        int sum = 0;
        int a = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & a) == 1) {
                sum++;
            }
            a <<= 1;
        }
        return sum;
    }

    // 法 2
    public int NumberOf12(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
