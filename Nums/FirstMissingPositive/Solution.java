package Nums.FirstMissingPositive;

/**
 * 果然没想象中简单，我之前的方法空间复杂度是O（n），没有达到要求。
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        //第i位存放i+1的数值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//nums[i]为正数，放在i+1位置
                //假设交换的数据还是大于0且<i+1，则放在合适的位置,且数据不相等，避免死循环
                //这个while是关键，其它都是没有难度的
                while (nums[i] > 0 && nums[i] < i + 1 && nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[nums[i] - 1];//交换数据
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        //循环寻找不符合要求的数据，返回
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //假设都符合要求，则返回长度+1的值
        return nums.length + 1;
    }

    public static void main(String[] args){
        Solution sl = new Solution();
        int[] nums = {7,8,1,3,9,11,12};
        System.out.print(sl.firstMissingPositive(nums));
    }
}
