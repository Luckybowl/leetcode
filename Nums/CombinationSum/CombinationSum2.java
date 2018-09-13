package Nums.CombinationSum;

import java.util.*;

/**
 * 40. 组合总和 II(medium)
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return list;
        }
        List<Integer> tempList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        backtrack(candidates, target, list, set, tempList, 0);
        return list;
    }

    private void backtrack(int[] nums, int remain, List<List<Integer>> list, Set<List<Integer>> set, List<Integer> tempList, int index) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            ArrayList list1 = new ArrayList(tempList);
            if (set.add(list1)) {
                list.add(list1);
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(nums, remain - nums[i], list, set, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 cs2 = new CombinationSum2();
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        cs2.combinationSum2(nums, target);
    }
}
