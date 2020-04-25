/**
 * Author: lisiyu
 * Created: 2020/4/25
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串的排列
 * 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class ArrangementOfStrings {

    ArrayList<String> list = new ArrayList<>();
    char[] arr;

    public ArrayList<String> Permutation(String str) {
        arr = str.toCharArray();
        recursion(0);
        return list;
    }

    private void recursion(int cur) {
        if (cur == arr.length - 1) {
            list.add(String.valueOf(arr)); // 将字符数组换为字符串
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = cur; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            swap(i, cur);
            recursion(cur + 1);
            swap(i, cur);
        }
    }

    private void swap(int i, int cur) {
        char tmp = arr[i];
        arr[i] = arr[cur];
        arr[cur] = tmp;
    }
}
