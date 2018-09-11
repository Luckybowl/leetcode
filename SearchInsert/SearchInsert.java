package SearchInsert;

/**
 * 35. 搜索插入位置(easy)
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums == null || target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int temp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (target > temp && target <= nums[i]) {
                return i;
            }
            temp = nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        SearchInsert si = new SearchInsert();
        int[] nums = {5, 7, 8, 10};
        int target = 6;
        System.out.print(si.searchInsert(nums,target));
    }
}
