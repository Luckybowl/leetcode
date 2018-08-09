package GenerateParenthesis.IsParenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 用堆栈来做
 */
public class Solution2 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        s = s.replace(" ", "");
        //从字符串s的首元素即i=0开始，若s的第i个元素为左半个括号则将其压栈；
        // 否则将s的第i个元素与栈顶元素相比较，若不相等则不匹配，否则i++；
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.empty() || map.get(stack.pop()) != s.charAt(i)) {
                return false;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[]{}  ";
        Solution2 s2 = new Solution2();
        System.out.print(s2.isValid(s));
    }
}
