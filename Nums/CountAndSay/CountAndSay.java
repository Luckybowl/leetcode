package Nums.CountAndSay;

/**
 *38. 报数(easy)
 * 报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * ps.理解题目花了很久，看别人答案也看了很久，最后调试了两遍才算理解，还是得多动手啊。
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String output = countAndSay(n - 1), result = "";
            int index = 0;  /**用于记录当前数字的位置**/
            while (index < output.length()) {  /**遍历上一个String***/
                char current = output.charAt(index);/**current记录当前数字**/
                int cursor = index, count = 0;   /**cursor即光标，count记录current的数量**/
                while (cursor < output.length() && output.charAt(cursor) == current) {
                    cursor++;
                    count++;
                }
                char number = (char) (count + '0');
                result += number;
                result += current;
                index += count;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(3));
    }
}


