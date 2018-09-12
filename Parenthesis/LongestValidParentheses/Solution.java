package Parenthesis.LongestValidParentheses;

import java.util.Stack;

/**
 * 思路：可以算得穷举法的时间复杂度为O(n^3)。虽然这题求的是最长的长度，
 * 但是用不了动态规划，因为无法找到一个合适的状态。考虑能不能在O(n)内实现，
 * 即遍历一次字符串。发现可以通过栈来做。具体方法如下：
 * <p>
 * 对于当前字符，如果是"(",直接压入栈中。如果是")"，要分以下几种情况讨论：
 * <p>
 * （1）如果当前栈为空，说明不存在与当前右括号配对的左括号，直接continue.
 * <p>
 * （2）如果当前栈大小为1：
 * <p>
 * a.如果栈顶元素是"("，则找到一个有效的括号序列，弹出栈顶元素，并压入这个序列的长度2；
 * <p>
 * b.如果栈顶元素是数字，说明不存在与当前右括号配对的左括号，
 * 且由于插入了一个右括号，之前得到的括号序列无法更长，需要弹出栈顶元素。
 * <p>
 * （3）如果当前栈的大小大于等于2：
 * <p>
 * 弹出栈顶元素
 * <p>
 * a.如果是"(",则找到一个为2的有效序列，再检查栈顶元素，如果是数字，
 * 说明可以与前面找到的括号序列合并为一个更大的序列，与其相加后压入栈，否则直接将2压入栈；
 * <p>
 * b.如果是数字，由于当前的栈大小大于等于2，则下一个栈的元素一定是“（”，
 * 弹出后压入合并后的序列长度，压之前再检查，如果栈顶元素还是为数字，则再合并，再压入。
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                if (stack.size() == 0) {
                    continue;
                } else if (stack.size() == 1) {
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
                        max = Math.max(max, num);
                    } else {
                        int temp = stack.pop();
                        stack.pop();
                        temp += 2;
                        if (!stack.isEmpty() && stack.peek() != 0) {
                            temp += stack.pop();
                        }
                        max = Math.max(max, temp);
                        stack.push(temp);
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = ")()(()))";
        Solution sl = new Solution();
        System.out.println(sl.longestValidParentheses(s));
    }
}
