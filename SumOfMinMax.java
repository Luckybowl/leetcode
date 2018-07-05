/**
 * 三数之和
 * *给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 **/
public class SumOfMinMax {
    public int arrayPairSum(int[] nums) {

        int temp = 0;
        int sum = 0;
        if (nums.length % 2 != 0) {
            throw new IllegalArgumentException("Illegal nums!");
        }
        nums = QuickSort.quickSort(nums);
//        nums = SumOfTwoNum.BubbleSort(nums);
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
