package LargeGroupPositions;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * <p>
 * 最终结果按照字典顺序输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 * <p>
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 * <p>
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 */
public class LargeGroup {
        /**一开始使用动态规划，错误******************************************/
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> resultList = new ArrayList<>();
        char[] s = S.toCharArray();
        int j;
        int len = s.length;
        for (int i = 0; i < len; i++) {
            char temp = s[i];
            j = i + 1;
            while (j < len && s[j] == temp) {
                j++;
            }
            if (j - i > 2) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j - 1);
                resultList.add(list);
                i = j - 1;
            }

        }
        return resultList;
    }


    public static void main(String[] args) {
        LargeGroup lg = new LargeGroup();
        String s = "abcdddeeeeaabbbcd";
        System.out.println(lg.largeGroupPositions(s));
    }
}