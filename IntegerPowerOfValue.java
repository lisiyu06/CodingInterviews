/**
 * Author: lisiyu
 * Created: 2020/4/7
 */

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class IntegerPowerOfValue {

    // 快速幂
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        long a = exponent;
        double cur = 1.0;
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                cur *= base;
            }
            base *= base;
            exponent /= 2;
        }
        return cur;
    }
}
