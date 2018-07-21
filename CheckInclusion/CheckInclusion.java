package CheckInclusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckInclusion {
    static boolean checkInclusion(String s1, String s2) {
        List<char[]> list = new ArrayList<>();

        if (s2.contains(s1)) {
            return true;
        } else {
            char[] c1 = s1.toCharArray();
            list = allSort( c1,0, list);
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
        }
        else {
            //把子数组的第一个元素依次和第二个、第三个元素交换位置
            for (int i = startIndex; i < begin.length; i++) {
                begin = swap(begin, i, startIndex);
                allSort( begin, startIndex + 1, list);
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
        String s1 = "abc";
        String s2 = "altruistic";
        System.out.print(checkInclusion(s1, s2));
    }
}
