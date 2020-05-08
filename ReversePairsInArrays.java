/**
 * Author: lisiyu
 * Created: 2020/5/8
 */

// 时间复杂度：同归并排序 O(nlogn)。
// 空间复杂度：同归并排序 O(n)，因为归并排序需要用到一个临时数组。
public class ReversePairsInArrays {
    public int InversePairs(int [] array) {
        int len = array.length;
        if (len == 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = array[i];
        }
        int[]temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    // nums[left...right] 计算逆序对个数并且排序
    private int reversePairs(int[] array, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(array, left, mid, temp);
        int rightPairs = reversePairs(array, mid + 1, right, temp);

        if (array[mid] <= array[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(array, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;

    }

    // nums[left..mid] 有序，nums[mid + 1..right] 有序
    private int mergeAndCount(int[] array, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                array[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                array[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
