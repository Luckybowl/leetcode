package Jump;

/**
 * 45. 跳跃游戏 II(hard)
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * ps.看了网上答案才知道是用贪心算法，但是还是没有理解为什么用贪心就一定对了。
 */
public class Jump {
    public int jump(int[] nums) {
        /**
         * 本题用贪心法求解，
         * 贪心策略是在每一步可走步长内，走最大前进的步数
         */
        if (nums.length <= 1) {
            return 0;
        }
        int index, max = 0;
        int step = 0, i = 0;
        while (i < nums.length) {
            //如果能直接一步走到最后，直接步数+1结束
            if (i + nums[i] >= nums.length - 1) {
                step++;
                break;
            }
            max = 0;  //初始化
            index = i + 1;  //每次至少前进1步
            for (int j = i + 1; j - i <= nums[i]; j++) {
                if (max < nums[j] + j - i) {
                    max = nums[j] + j - i;  //记录最大值
                    index = j; //记录最大值索引
                }
            }
            i = index;  //直接走到能走到的最远那步
            step++;
        }
        return step;
    }
}
