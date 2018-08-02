package String.LongestPalindrome;

/**
 * 分析：
 * 动态规划来做，每个回文字符串的子字符串也是回文字符串，
 * 即string是回文字符串那么它的
 * string.substring(1,lenth-1),string.substring(2,lenth-2),string.substring(3,lenth-3)……都是回文字符串。
 * <p>
 * flag布尔数组是记录i到j是否是回文字符串的标记，flag[2][5]即s.substring(2,6)是回文字符串。
 * <p>
 * 两个for循环嵌套，第一个for循环中的i控制每个要找的字符串的第1个字母位置，
 * 第二个for中的j控制每个要找的字符串的最后1个字母的位置。判断每次遍历到的两个字母是否相同，
 * 相同则将对应的flag[i][j]赋值为true。每次判断的时候还需要判断当前两个数字i和j的大小，
 * j-i的值是否<=2（也就是这个字符串的长度是否<=2）以及如果这两个字母相同，它的子字符串是否是回文字符串。
 */
class Solution1 {
    /**通过的测试用例数目不如原方法，仍然超时************************/
    @Deprecated
    public String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        boolean[][] flag = new boolean[s.length()][s.length()];
        int begin = 0;
        int end = 0;
        int maxlen = 0;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || flag[i + 1][j - 1])) {
                    flag[i][j] = true;
                    if (maxlen < j - i + 1) {
                        maxlen = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }


        return s.substring(begin, end + 1);

    }

    public static void main(String[] args) {
        String s = "abacd";
        Solution1 lp = new Solution1();
        System.out.print(lp.longestPalindrome(s));
    }
}
