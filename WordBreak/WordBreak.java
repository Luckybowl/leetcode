package WordBreak;

import java.util.*;

/**
 * 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {
    public boolean check(String s, List<String> wordDict) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(i, wordDict.get(i));
        }
        String s1 = null;
        String s2 = null;
        s = divide(s, map, s1, s2);
        return "".equals(s);

//        if(s.length() == 0){
////            return true;
////        }else {
////            return false;
////        }
    }

    public String divide(String s, Map<Integer, String> map, String s1, String s2) {
        /* 找出指定的2个字符在 该字符串里面的 位置 */
        String first;
        final String sf = s;
        int flag = 0;
        for (int i = 0; i < map.size(); i++) {
            if (!"".equals(s)) {
                flag++;
                if (flag <= map.size()) {
                    first = map.get(0 + flag - 1);
                    map.put(map.size() + flag - 1, first);
                    map.remove(0 + flag - 1);
                    s = divide1(sf, map, s1, s2, flag);
                }else{
                    return s;
                }

            } else {
                break;
            }
        }

        return s;

    }

    public String divide1(String s, Map<Integer, String> map, String s1, String s2, int flag) {
        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex;
        final String sf = s;
        for (int i = 0; i < map.size(); i++) {
            strStartIndex = s.indexOf(map.get(i + flag));
            if (strStartIndex > -1) {
                /**截取指定字符串，将剩余字符串分为左右两个继续递归*************************************/
                s = sf.replaceAll(map.get(i + flag), "");
                if ("".equals(s)) {
                    return s;
                }
                s1 = s.substring(0, strStartIndex);
                if (s1.length() > 0) {
                    divide1(s1, map, null, null, flag);
                }
                s2 = s.substring(strStartIndex, s.length());
                if (s2.length() > 0) {
                    divide1(s2, map, null, null, flag);
                }
            }
        }
        return s;
    }



    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
//        System.out.println(wordBreak.check("catsandog",wordDict));
        wordDict.add("bc");
        wordDict.add("ca");
        System.out.println(wordBreak.check("cbca",wordDict));
//        wordDict.add("abc");
//        wordDict.add("ab");
//        wordDict.add("abcd");
//        System.out.println(wordBreak.check("ababcababcabcd", wordDict));
    }


}



