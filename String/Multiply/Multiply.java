package String.Multiply;

/**
 * 43. 字符串相乘(medium)
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int l1 = c1.length, l2 = c2.length, i, j, k;
        //一般来说两个数相乘，其最大位数也不会大于啷个位数之和
        int[] result = new int[l1 + l2];
        //转换成数字
        for (i = 0; i < l1; i++)
            c1[i] -= '0';
        for (i = 0; i < l2; i++)
            c2[i] -= '0';

        for (i = 0; i < l2; i++) {
            int carry = 0;
            for (j = 0; j < l1; j++) {
                result[i + j] += c2[l2 - 1 - i] * c1[l1 - 1 - j] + carry;
                carry = result[i + j] / 10;
                result[i + j] %= 10;
            }
            k = i + j;
            /**处理进位**********/
            while (carry != 0) {
                result[k] += carry;
                carry = result[k] / 10;
                result[k] %= 10;
                k++;
            }
        }
        StringBuilder tmp = new StringBuilder(l1 + l2);
        i = l1 + l2 - 1;
        while (i > 0 && result[i] == 0)
            i--;
        while (i >= 0)
            tmp.append(result[i--]);
        return tmp.toString();
    }

    public static void main(String[] args){
        Multiply m = new Multiply();
        String s1 = "11";
        String s2 = "11";
        System.out.println(m.multiply(s1,s2));
    }
}
