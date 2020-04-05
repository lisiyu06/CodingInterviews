/**
 * Author: lisiyu
 * Created: 2020/4/5
 */

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class RectangleCovering {
    public int RectCover(int target) {
        /**
         * f(1) = 1
         * f(2) = 2
         * f(3) = 3
         * f(4) = 5
         * 思路与斐波那契数列相同
         */
        if (target <= 0) {
            return 0;
        }
        if (target >= 1 && target <= 3) {
            return target;
        }
        int last1 = 2;
        int cur = 3;
        for (int i = 4; i <= target; i++) {
            cur = cur + last1;
            last1 = cur - last1;
        }
        return cur;
    }
}
