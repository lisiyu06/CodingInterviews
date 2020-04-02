/**
 * Author: lisiyu
 * Created: 2020/4/2
 */

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class FlogOn {

    // 法1
    public int JumpFloor1(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor1(target - 1) + JumpFloor1(target - 2);
    }

    // 法2
    public int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int cur = 1;
        int last1 = 1;
        for (int i = 0; i < target; i++) {
            cur = cur + last1;
            last1 = cur - last1;
        }
        return cur;
    }

}
