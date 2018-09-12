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
        int max = 0;
        Map<Character, Character> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        map.put('(', ')');
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(0);
            } else if (stack.isEmpty()) {
                continue;
            } else {
                if (stack.size() == 1) {
                    if (stack.pop() == 0) {
                        stack.push(2);
                        max = Math.max(max, 2);
                    }
                } else {
                    if (stack.peek() == 0) {
                        stack.pop();
                        int num = 2;
                        if (stack.peek() != 0) {
                            num += stack.pop();
                        }
                        stack.push(num);
                        max = Math.max(num, max);
                    } else {
                        /**如果是数字，由于当前的栈大小大于等于2，
                         * 则下一个栈的元素一定是“（”，弹出后压入合并后的序列长度，
                         * 压之前再检查，如果栈顶元素还是为数字，则再合并，再压入。***************/
                        int temp = stack.pop();
                        stack.pop();
                        temp += 2;
                        if(!stack.isEmpty() && stack.peek() != 0){
                            temp += stack.pop();
                        }
                        max = Math.max(temp,max);
                        stack.push(temp);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "(())))()()()";
        LongestValidParentheses lp = new LongestValidParentheses();
        System.out.println(lp.longestValidParentheses(s));
    }
}
