package Nums.SortPhoneNums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合(中等)
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * PS.这道题一开始思考得太多了，老是从4,5个数字开始思考，导致思绪混乱；
 * 后来从一个数字，两个数字开始思考，编写程序，很快就有了头绪，解答很顺利。
 */
public class SortPhoneNums {


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character, String[]> letterMap = new HashMap<>();
        letterMap.put('2', new String[]{"a", "b", "c"});
        letterMap.put('3', new String[]{"d", "e", "f"});
        letterMap.put('4', new String[]{"g", "h", "i"});
        letterMap.put('5', new String[]{"j", "k", "l"});
        letterMap.put('6', new String[]{"m", "n", "o"});
        letterMap.put('7', new String[]{"p", "q", "r", "s"});
        letterMap.put('8', new String[]{"t", "u", "v"});
        letterMap.put('9', new String[]{"w", "x", "y", "z"});
        char[] c = digits.toCharArray();
        if (c.length < 1) {
            return list;
        }
        /**先思考一个，两个的组合***************/
//        List<String> list1 = new ArrayList<>();
//        String[] s1 = letterMap.get(c[0]);
//        for (int j = 0; j < s1.length; j++) {
//            StringBuffer sb = new StringBuffer();
//            sb.append(s1[j]);
//            list1.add(sb.toString());     //一个的时候
//        }
        /**两个**************************/
//        List<String> list2 = new ArrayList<>();
//        String[] s2 = letterMap.get(c[1]);
//        for(String s : list){
//            for(int j = 0; j < s2.length; j ++){
//                StringBuffer sb = new StringBuffer(s);
//                sb.append(s2[j]);
//                list2.add(sb.toString());
//            }
//        }
        for (int i = 0; i < c.length; i++) {
            list = addElement(letterMap.get(c[i]), list);
        }
        return list;
    }

    public List<String> addElement(String[] s, List<String> list) {
        List<String> newList = new ArrayList<>();
        if (list.size() == 0) {
            for (int j = 0; j < s.length; j++) {
                StringBuffer sb = new StringBuffer();
                sb.append(s[j]);
                newList.add(sb.toString());     //一个的时候
            }
            return newList;
        }
        for (String l : list) {
            for (int j = 0; j < s.length; j++) {
                StringBuffer sb = new StringBuffer(l);
                sb.append(s[j]);
                newList.add(sb.toString());
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        SortPhoneNums spn = new SortPhoneNums();
        System.out.println(spn.letterCombinations(""));
    }
}
