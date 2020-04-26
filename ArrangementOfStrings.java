/**
 * Author: lisiyu
 * Created: 2020/4/25
 */


import java.util.*;
/**
 * 字符串的排列
 * 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class ArrangementOfStrings {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str.length() == 0) return res;
        char [] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        res.add(str);
        while(true) {
            s = nextString(s);
            if(!s.equals("finish")) {
                res.add(s);
            } else {
                break;
            }
        }
        return res;
    }

    public String nextString(String str) {
        char [] array = str.toCharArray();
        int length = str.length();
        int i = length-2;
        for(; i>=0 && array[i] >= array[i+1]; i--);
        if(i == -1) {
            return "finish";
        }
        int j = length-1;
        for(; j>=0 && array[j] <= array[i]; j--);
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for(int a=i+1, b=length-1; a<b;a++,b--) {
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }

}
