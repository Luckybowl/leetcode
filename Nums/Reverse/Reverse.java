package Nums.Reverse;

import java.util.ArrayList;

/**
 * 7. 反转整数(简单)
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，
 * 其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Reverse {
    public int reverse(int x) {
        boolean flag = false;
        if(x < 0) {
            flag = true;
            x = 0 - x ;
        }
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        s = sb.toString();
        try {
            x = Integer.parseInt(s);
        }catch(Exception e){
            return 0;
        }
        if(flag){
            return 0 - x;
        }
        return x;
    }
    public static void main(String[] args){
        Reverse reverse = new Reverse();
        int x = 1534236469;
        System.out.print(reverse.reverse(x));
    }
}
