package LengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串(中等)
 * <p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        char[] c = s.toCharArray();
        int max = 0;
        boolean flag = false;
        for (int i = 0; i < c.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < c.length; j++) {
                flag = set.add(c[j]);
                if (set.size() > max) {
                    max = set.size();
                }
                if (!flag) {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
        String s = "pwwkew";
        System.out.println(ls.lengthOfLongestSubstring(s));
    }
}
