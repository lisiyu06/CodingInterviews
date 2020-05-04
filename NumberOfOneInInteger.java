/**
 * Author: lisiyu
 * Created: 2020/4/30
 */

/**
 * 整数中 1 出现的次数
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOfOneInInteger {
    // 按位计算
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1;  // 位因子
        int high = n / 10;  // 高位数字
        int cur = n % 10;  // 当前位数字
        int low = 0;  // 地位数字
        int res = 0;  // 累计计算的次数
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += (high * digit);
            } else if (cur == 1) {
                res += (high * digit + low + 1);
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }
}
