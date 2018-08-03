package String.LongestCommonPrefix;

/**
 * 14. 最长公共前缀(简单)
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (j > strs[i].length() - 1 || strs[0].charAt(j) != (strs[i].charAt(j))) {
                    return sb.toString();
                }
                /**若此时是最后一个判断的字符串，则将首字母添加进来。**************************/
                if( i == strs.length - 1){
                    sb.append(strs[0].charAt(j));
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args){
        LongestCommonPrefix lc = new LongestCommonPrefix();
//        String[] strs = {"faower","fliow","flight"};
        String[] s1 = {"aa","a"};
//        System.out.println(lc.longestCommonPrefix(strs));
        System.out.println(lc.longestCommonPrefix(s1));
    }
}
