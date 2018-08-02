package String.LongestPalindrome;

/**
 * 5. 最长回文子串(中等)
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * PS:“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * <p>
 * <p>
 * 此方法，超时。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
//        String temp;
        int max = 0;
        int[] index = new int[2];
//        int len;
        char[] c = s.toCharArray();
        int n = c.length;
        if (null == s || n <= 1) {
            return s;
        }
        /*****StringBuilder自带reverse方法*******/
//        StringBuilder b = new StringBuilder(s);
//        b = b.reverse();
//        String reverse = b.toString();
//        String reverse = toReverse(c);
        for (int i = 0; i < n; i++) {
            /*for (int j = i + 1; j < n + 1; j++) {
                temp = s.substring(i, j);
                *//**用于判断截取的子串与原来的索引是否一致*********************************//*
                if (reverse.contains(temp) && temp.equals(reverse.substring(n - j, n - i))) {
                    len = j - i;
                    if (len > max) {
                        max = len;
                        index[0] = i;
                        index[1] = j;
                    }
                }else{
                    break;
                }
            }*/
            /**尝试中心扩展法*********************/
            int len1 = expandAroundCenter(s, i, i);
            /**len2用于abba 这类中间偶数的回文************************/
            int len2 = expandAroundCenter(s, i, i + 1);
            int len3 = Math.max(len1, len2);
            if (len3 > max) {
                max = len3;
                index[0] = i - (len3 - 1) / 2;
                index[1] = i + len3 / 2;
            }
        }
        return s.substring(index[0], index[1] + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        /**e.g: aba L = -1, R = 3  return 3 - -1 - 1 = 3 **********/
        return R - L - 1;
    }

    public String toReverse(char[] c) {
        char[] reverse = new char[c.length];
        System.arraycopy(c, 0, reverse, 0, c.length);
        char temp;
        for (int i = 0; i < reverse.length / 2; i++) {
            temp = reverse[i];
            reverse[i] = reverse[reverse.length - i - 1];
            reverse[reverse.length - i - 1] = temp;
        }
        return String.valueOf(reverse);
    }

    public static void main(String[] args) {
        String s = "xrcrx";
        LongestPalindrome lp = new LongestPalindrome();
        System.out.print(lp.longestPalindrome(s));
    }
}
