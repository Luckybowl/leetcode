package Sort.CheckInclusion.CheckInclusion;

public class Test {
    public static void main(String[] args){
        String s1 ="abcde";
        String s2 = "fghij";
        int[] arr = new int[26];
        int len_a = s1.length(), len_b = s2.length();
        for (int i = 0; i < len_a; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }    }
}
