/**
 * Author: lisiyu
 * Created: 2020/3/30
 */

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlankSpace {

    /**
     * 1. 直接替换
     */
    public String replaceSpace1(StringBuffer str) {
        String ret = str.toString();
        return ret.replaceAll(" ", "%20");
    }

    /**
     * 2. 用新的数组替换
     */
    public String replaceSpace2(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
