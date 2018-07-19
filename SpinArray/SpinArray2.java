package SpinArray;

/**
 * 81. 搜索旋转排序数组 II
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class SpinArray2 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (target >= nums[0]) {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (target == nums[i]) {
                    return true;
                }
            }
            return false;
        }
    }
}
