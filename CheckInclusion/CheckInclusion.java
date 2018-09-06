package CheckInclusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 567. 字符串的排列
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {
    static boolean checkInclusion(String s1, String s2) {
        List<char[]> list = new ArrayList<>();

        if (s2.contains(s1)) {
            return true;
        } else {
            char[] c1 = s1.toCharArray();
            list = allSort(c1, 0, list);
            for (char[] s : list) {
                System.out.println(Arrays.toString(s));
                if (s2.contains(new String(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<char[]> allSort(char[] begin, int startIndex, List<char[]> list) {
        //打印数组的内容
        if (startIndex == begin.length) {
//            System.out.println(Arrays.toString(array));
            list.add(begin);
//            System.out.println(Arrays.asList(array));
//            return list;
        } else {
            //把子数组的第一个元素依次和第二个、第三个元素交换位置
            for (int i = startIndex; i < begin.length; i++) {
                begin = swap(begin, i, startIndex);
                allSort(begin, startIndex + 1, list);
                //交换回来
                begin = swap(begin, i, startIndex);
            }
        }

        return list;
    }


    static char[] swap(char[] array, int a, int b) {
        char[] n = new char[array.length];
        System.arraycopy(array, 0, n, 0, array.length);
        char tem = n[a];
        n[a] = n[b];
        n[b] = tem;
        return n;
    }


    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "altruistic";
        System.out.print(checkInclusion(s1, s2));
    }
}
