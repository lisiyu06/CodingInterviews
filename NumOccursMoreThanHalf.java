/**
 * Author: lisiyu
 * Created: 2020/4/27
 */

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class NumOccursMoreThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        int preValue = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == preValue) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    preValue = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (preValue == array[i]) {
                num++;
            }
        }
        if (num > (array.length / 2)) {
            return preValue;
        } else {
            return 0;
        }
    }
}
