package Parenthesis.IsParenthesis;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 换思路，先将字符串的所有空格去除，然后判断是不是镜像。
 * 错误，不适用 "()[]{}"
 */
public class Solution1 {
    @Deprecated
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        s = s.replace(" ", "");
        if(s.length() % 2 != 0){
            return false;
        }
        char[] c = s.toCharArray();
        int mid = c.length / 2 - 1;
        int i = mid,j = mid + 1;
        while(i >= 0 && j < c.length){
            if(map.get(c[i]) != c[j]){
                return false;
            }
            i --;
            j ++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        Solution1 s1 = new Solution1();
        System.out.print(s1.isValid(s));
    }
}
