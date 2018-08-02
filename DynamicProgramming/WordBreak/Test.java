package DynamicProgramming.WordBreak;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public boolean check(String s, List<String> wordDict) {
            s = divide(s,wordDict);
            if(s.length() == 0){
                return true;
            }
            return false;
    }

    public String divide(String s, List<String> wordDict) {
        int strStartIndex;
        for (int i = 0; i < wordDict.size(); i++) {
            strStartIndex = s.indexOf(wordDict.get(i));
            if (strStartIndex > -1) {
                s = s.replaceAll(wordDict.get(i),"");
            }
        }
        return s;
    }

    public static void main(String[] args){
        Test t = new Test();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("ab");
        wordDict.add("cd");
        String s = "abcdef";
        s = t.divide(s,wordDict);
        System.out.println(s);
    }
}
