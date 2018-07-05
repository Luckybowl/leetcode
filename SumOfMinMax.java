public class SumOfMinMax {
    public int arrayPairSum(int[] nums) {

        int temp = 0;
        int sum = 0;
        if(nums.length % 2 != 0){
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

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            i++;

        }
        return sum;
        
    }

    public static void main(String[] args){
        SumOfMinMax minMax = new SumOfMinMax();
//        int nums[] = {1,4,3,2};
        
        int result = minMax.arrayPairSum(new int[]{4,2,5,5,6,0});
        System.out.println(result);

    }
}