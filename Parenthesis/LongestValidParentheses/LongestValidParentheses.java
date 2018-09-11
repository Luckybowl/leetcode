package Parenthesis.LongestValidParentheses;

import java.util.*;

/**
 * 32. 最长有效括号(hard)
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int sum = 0;
        Map<Character, Character> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        map.put('(', ')');
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(i);
            } else if (stack.isEmpty()) {
                sum = 0;
                continue;
            } else {
                if (s.charAt(i) == map.get('(')) {
                    sum += 2;
                    int j = stack.peek();
                    if (map1.get(j - 2) == null) {
                        sum = 2;
                    }
                    map1.put(stack.pop(), sum);
                    sum = Math.max(sum,)
                } else {
                    sum = 0;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = ")()())";
        LongestValidParentheses lp = new LongestValidParentheses();
        System.out.println(lp.longestValidParentheses(s));
    }
}
