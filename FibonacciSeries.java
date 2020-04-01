/**
 * Author: lisiyu
 * Created: 2020/4/1
 */

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class FibonacciSeries {

    /**
     * 1. 递归
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)
     */
    public int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    /**
     * 2. 用数组保存
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int Fibonacci2(int n) {
        int[] fib = new int[40];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    /**
     * 3. 循环，存储数据
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int Fibonacci3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int last2 = 1;
        int last1 = 0;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = last2 + last1;
            last1 = last2;
            last2 = cur;
        }
        return cur;
    }

    /**
     * 4. 循环，保存差值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int Fibonacci4(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int cur = 1;
        int last1 = 0;
        for (int i = 2; i <= n; i++) {
            cur += last1;
            last1 = cur - last1;
        }
        return cur;
    }

}
