package Nums.FirstMissingPositive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 41. 缺失的第一个正数(hard)
 * <p>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * <p>
 * hint:remember that O(2n) = O(n),这应该是提示用双指针? update:并不是，只是方便将数组由map存储罢了。
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int min = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            map.put(nums[i], i);
        }
        for (int i = 1; ; i++) {
            if (map.get(i) == null) {
                return i;
            }
        }
    }

    public static void main(String[] args){
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] nums = {1,2,3,7,8,9,11,12};
        System.out.print(fmp.firstMissingPositive(nums));
    }
}
