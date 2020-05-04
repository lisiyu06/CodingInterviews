/**
 * Author: lisiyu
 * Created: 2020/5/4
 */

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ArrangeArrayIntoSmallestNumber {
    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
    private void quickSort(String[] strs, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        String temp = strs[i];   // 基准
        while (i < j) {
            while ((strs[j] + strs[low]).compareTo(strs[low] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[low]).compareTo(strs[low] + strs[i]) <= 0 && i < j) {
                i++;
            }
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[i] = strs[low];
        strs[low] = temp;
        quickSort(strs, low, i - 1);
        quickSort(strs, i + 1, high);
    }
}
