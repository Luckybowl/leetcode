package Sort.CheckInclusion;

import java.util.Arrays;

/**
 *
 *  全排序
 */
public class Permutation {
    public static void Permutation(char[] str)
    {
        if (str == null)
        {
            return;
        }

        Permutation(str, str, 0);
    }

    public static void Permutation(char[] str, char[] begin, int startIndex)
    {
        if (startIndex == str.length)
        {
            //此处str或begin都行，两者是一个引用。
            System.out.println(Arrays.toString(str));
        }
        else
        {
            for (int i = startIndex; i < str.length; i++)
            {
                char temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;

                Permutation(str, begin, startIndex + 1);

                temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;
            }
        }
    }


    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "altruistic";
//        System.out.print(checkInclusion(s1, s2));
        char[] c1 = s1.toCharArray();
        Permutation(c1);
    }
}
