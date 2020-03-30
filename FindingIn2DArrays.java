/**
 * Author: lisiyu
 * Created: 2020/3/30
 */

/**
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindingIn2DArrays {

    /**
     * 1. 暴力法：
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public boolean Find1(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j =0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 2. 右上方查找
     * 时间复杂度：O(rows + cols)
     * 空间复杂度：O(1)
     */
    public boolean Find2(int target, int [][] array) {
        // 空数组情况
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        // 非空数组情况
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 3. 左下方查找
     * 时间复杂度：O(rows + cols)
     * 空间复杂度：O(1)
     */
    public boolean Find3(int target, int [][] array) {
        // 空数组情况
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        // 非空数组情况
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[0].length) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

}
