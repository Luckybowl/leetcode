package SpinArray;


/**
 * 33. 搜索旋转排序数组
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SpinArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (target >= nums[0]) {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}
