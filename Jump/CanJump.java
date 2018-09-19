package Jump;

/**
 * 55. 跳跃游戏(medium)
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * thought:我觉得是判断数组中是不是有0，且这个0是不是必然会跳到，若如此，则为false。
 * Update:继续用贪心做
 * Update:果然如此，理解了贪心的妙处，每次算出这次选择中能到达的最远的地方，如果这个地方是0，则代表，无法越过这个0。
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int index, max = 0;
        int step = 0, i = 0;
        while (nums[i] != 0) {
            //如果能直接一步走到最后，直接结束
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
            max = 0;  //初始化
            index = i + 1;  //每次至少前进1步
            for (int j = i + 1; j - i <= nums[i]; j++) {
                if (max < nums[j] + j - i) {
                    max = nums[j] + j - i;
                    index = j;
                }
            }
            if (index >= nums.length - 1) {
                return true;
            }
            i = index;
        }
        return false;
    }
}
