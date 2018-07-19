package WordBreak;

import java.util.List;

/**
 * 单词拆分问题，典型的动态规划
 * <p>
 * 设dp[i]为前i个字符是否可以切割。
 * <p>
 * 一个字符串S，它的长度为len，如果S能够被“字典集合”（dict）中的单词拼接而成，那么所要满足的条件为：
 * dp[j] && dict.contains(s.substring(j, i))
 * 如果我们想知道某个子串是否可由dict中的几个单词拼接而成就可以用这样的方式得到结果（满足条件为True, 不满足条件为False）存入到一个boolean数组的对应位置上
 * <p>
 * DP（动态规划）
 */
public class FinalAnswer {

    public boolean wordBreak(String s, List<String> dict) {
        int len = s.length();
        //len+1
        //dp[i]表示前i个字符能不能被dict完美划分
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++)
            for (int j = 0; j < i; j++) {
                // 注意substring是前闭后开
                String tmp = s.substring(j, i);
                //能否组合出f[i]表示的子串，k表示组合中前半段的
                if (dp[j] && dict.contains(tmp)) {
                    dp[i] = true;
                    break;
                }
            }
        return dp[len];


    }


}
