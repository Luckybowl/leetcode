package ArrayPairSum;

import java.util.Arrays;

/**
 * 数组拆分
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * <p>
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 */
public class SumOfMinMax {
    public int arrayPairSum(int[] nums) {

        int temp = 0;
        int sum = 0;
        if (nums.length % 2 != 0) {
            throw new IllegalArgumentException("Illegal nums!");
        }
        //用容器自带的方法，速度提升很大
        Arrays.sort(nums);
//        nums = QuickSort.QuickSort.quickSort(nums);
//        nums = SumOfTwoNum.SumOfTwoNum.BubbleSort(nums);
        /*for(int i = 0 ; i < nums.length ; i ++){
            for(int j = i+1 ; j < nums.length; j++ ){
                if(nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }*/

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            i++;

        }
        return sum;

    }

    public static void main(String[] args) {
        SumOfMinMax minMax = new SumOfMinMax();
//        int nums[] = {1,4,3,2};

        int result = minMax.arrayPairSum(new int[]{4, 2, 5, 5, 6, 0});
        System.out.println(result);

    }
}
