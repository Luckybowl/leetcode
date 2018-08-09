package GenerateParenthesis.IsParenthesis;

/**
 * 20. 有效的括号(简单)
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * PS.很遗憾，没有想到用stack来做，似乎没有其他的方法。
 */
public class IsParenthesis {
    @Deprecated
    public boolean isValid(String s) {
        int x = 0, y = 0, z = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (x < 0 || y < 0 || z < 0) {
                return false;
            }
            switch (c[i]) {
                case '(':
                    x++;
                    break;
                case ')':
                    x--;
                    if (x < 0 || ('[' == (c[i - 1]) || '{' == (c[i - 1]))) {
                        return false;
                    }
                    break;
                case '{':
                    y++;
                    break;
                case '}':
                    y--;
                    if (y < 0 || ('[' == (c[i - 1]) || '(' == (c[i - 1]))) {
                        return false;
                    }
                    break;
                case '[':
                    z++;
                    break;
                case ']':
                    z--;
                    if (z < 0 || ('(' == (c[i - 1]) || '{' == (c[i - 1]))) {
                        return false;
                    }
                    break;
                case ' ':
                    break;
            }
        }
        if (x == 0 && y == 0 && z == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "[([]])";
        IsParenthesis ip = new IsParenthesis();
        System.out.print(ip.isValid(s));
    }
}
