package String.FindSubstring;

import java.util.*;

/**
 * 30. 与所有单词相关联的字串(hard)
 * 给定一个字符串 s 和一些//TODO 长度相同//
 * 的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出: [0,9]
 * 解释: 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2:
 * <p>
 * 输入:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * 输出: []
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length == 0 || words == null){
            return result;
        }
        for (int i = 0; i < words.length; i++) {
            if (!s.contains(words[i])) {
                return result;
            }
        }
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        list = allSort(words, 0, list);
        for (String s1 : list) {
            System.out.println(s1);
            Integer num = s.indexOf(s1);
//            if (num != -1 && set.add(num)) {
//                result.add(num);
            if (num != -1) {
                for (int i = num; i < s.length(); i ++) {
                    Integer temp = s.indexOf(s1, i);
                    if (temp == -1) {
                        break;
                    } else if (temp != -1 && set.add(temp)) {
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }


    static List<String> allSort(String[] begin, int startIndex, List<String> list) {
        //打印数组的内容
        if (startIndex == begin.length) {
            String s = "";
            for (int i = 0; i < begin.length; i++) {
                s += begin[i];
            }
            list.add(s);
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


    static String[] swap(String[] array, int a, int b) {
        String[] n = new String[array.length];
        System.arraycopy(array, 0, n, 0, array.length);
        String tem = n[a];
        n[a] = n[b];
        n[b] = tem;
        return n;
    }


    public static void main(String[] args) {
        FindSubstring fs = new FindSubstring();
        /**败在这个测试用例上了啊，效率太低下，可恶。**********************************/
        String s1 = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] s2 = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        Date start = new Date();
        System.out.println(start);
        System.out.println(fs.findSubstring(s1, s2));
        Date end = new Date();
        System.out.println(end);
    }
}
