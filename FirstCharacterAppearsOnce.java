/**
 * Author: lisiyu
 * Created: 2020/5/6
 */

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */

public class FirstCharacterAppearsOnce {
    // 时间复杂度: O(N), N 为字符串 s 的长度；需遍历 s 两轮; HashMap 查找的操作复杂度为 O(1)
    //空间复杂度: O(N), HashMap 需存储 N 个字符的键值对
    public int FirstNotRepeatingChar1(String str) {
        /**
         * 哈希表
         * key: 字符串；
         * value: boolean值，存在一次置为true，存在多次置为 false
         */
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] sc = str.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            map.put(sc[i], !map.containsKey(sc[i]));
        }
//        for(char c : sc)
//            map.put(c, !map.containsKey(c));
        for (int i = 0; i < sc.length; i++) {
            if (map.get(sc[i])) {  // map.get(key) 方法返回 value 值
                return i;
            }
        }
        return -1;
    }
}
