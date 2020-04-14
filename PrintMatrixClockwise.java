/**
 * Author: lisiyu
 * Created: 2020/4/14
 */

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

// 从四个方向开始遍历，定义四个边界，不断收缩边界。
public class PrintMatrixClockwise {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        // 定义四个边界
        int left = 0;  // 左边界
        int right = matrix[0].length - 1;  // 右边界
        int top = 0;  // 上边界
        int bottom = matrix.length - 1;  // 下边界
        while (true) {
            // (1) 上面的行遍历：从左向右遍历
            for (int col = left; col <= right; col++) {
                list.add(matrix[top][col]);
            }
            // 本行遍历结束，上边界 +1
            top++;
            // 上下两边界相遇，跳出循环
            if (top > bottom) {
                break;
            }
            // (2) 右面的列遍历：从上向下遍历
            for (int row = top; row <= bottom; row++) {
                list.add(matrix[row][right]);
            }
            // 本列遍历结束，右边界 -1
            right--;
            // 上下两边界相遇，跳出循环
            if (left > right) {
                break;
            }
            // (3) 下面的行遍历：从右向左遍历
            for (int col = right; col >= left; col--) {
                list.add(matrix[bottom][col]);
            }
            // 本行遍历结束，下边界 -1
            bottom--;
            // 上下两边界相遇，跳出循环
            if (top > bottom) {
                break;
            }
            // (4) 左面的列遍历：从下向上遍历
            for (int row = bottom; row >= top; row--) {
                list.add(matrix[row][left]);
            }
            // 本列遍历结束，左边界 +1
            left++;
            // 左右两边界相遇，跳出循环
            if (left > right) {
                break;
            }
        }
        return list;
    }
}
