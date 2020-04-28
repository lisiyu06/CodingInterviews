/**
 * Author: lisiyu
 * Created: 2020/4/28
 */

import java.util.ArrayList;

/**
 * 最小的 K 个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class MinimumNumberOfK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k<= 0 || k > input.length) {
            return list;
        }
        // 先对前 K 个元素排序
        for (int i = 1; i < k; i++) {
            int j = i - 1;
            int cur = input[i];
            while (j >= 0 && input[j] > cur) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = cur;
        }
        // 再对后面的元素进行排序
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[k - 1]) {
                int newK = input[i];
                int j = k - 1;
                while (j >= 0 && input[j] > newK) {
                    input[j + 1] = input[j];
                    j--;
                }
                input[j + 1] = newK;
            }
        }
        // 返回前 K 个元素
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}
