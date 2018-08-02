package LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 *
 *方法三：优化的滑动窗口
 * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。
 * 我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。
 * 当我们找到重复的字符时，我们可以立即跳过该窗口。
 *
 * 也就是说，如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与 j'j
 * ​′
 * ​​  重复的字符，我们不需要逐渐增加 ii 。 我们可以直接跳过 [i，j′] 范围内的所有元素，并将 ii 变为 j' + 1j
 * ​′
 * ​​ +1。
 *
 * Java（使用 HashMap）
 *
 *
 * 复杂度分析
 *
 * 时间复杂度：O(n)O(n)，索引 jj 将会迭代 nn 次。
 *
 * 空间复杂度（HashMap）：O(min(m, n))O(min(m,n))，与之前的方法相同。
 *
 * 空间复杂度（Table）：O(m)O(m)，mm 是字符集的大小。
 *
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}