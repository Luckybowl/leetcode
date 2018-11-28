package Nums.BinaryPractice;

public class BinaryPractice {
    public int NumberOf1(int n) {
        int result = 0;
        char[] c = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ('1' == c[i]) {
                result++;
            }
        }
        return result;
    }

    public static int method2(int n){
        return Integer.toBinaryString(n).replaceAll("0","").trim().length();
    }

    /* 利用&运算的特性,把一个整数减去1，再和原整数做与运算，
    会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作 */
    public static int method3(int n){
        int result = 0;
        while(n != 0){
            n = n & (n - 1);
            result ++;
        }
        return result;
    }

}
