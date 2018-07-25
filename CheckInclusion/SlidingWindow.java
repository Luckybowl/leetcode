package CheckInclusion;

/**
 * 判断一个字符串A的permutation是否在另一个字符串B中，即判断字符串A中的所有字符是否在字符B中被连续使用完。
 * 即利用一个宽度为len_a的滑动窗口，在字符串B中滑动，当新字符从右边进来时，将数组位上的值++，从左边出去时，将值--，并判断每一时刻，对于一个数组，每一个字符都被使用了。
 */
public class SlidingWindow {
    public boolean checkInclusion(String s1, String s2) {
        int len_a = s1.length(), len_b = s2.length();
        if (len_a > len_b)
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < len_a; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        if (check(arr))
            return true;
        //System.out.println(Arrays.toString(arr));
        for (int i = len_a; i < len_b; i++) {
            arr[s2.charAt(i) - 'a']--;
            arr[s2.charAt(i - len_a) - 'a']++;
            //System.out.println(Arrays.toString(arr));
            if (check(arr))
                return true;
        }
        return false;

    }

    private static boolean check(int[] arr) {
        // TODO Auto-generated method stub
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

}
