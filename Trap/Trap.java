package Trap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 42. 接雨水(hard)
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * ps.错误的答案
 */
public class Trap {
    public int trap(int[] height) {
        int sum = 0;
        int start = 0;
        int end = 0;
        int startIndex = 0;
        int endIndex;
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < height.length; i++) {
            /**除去第一个0****/
            if (map.size() == 0 && height[i] == 0) {
                continue;
            }
            map.put(i, height[i]);
        }
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int index = it.next();
            temp = map.get(index);
            if (temp != 0) {
                if (start == 0) {
                    start = temp;
                    startIndex = index;
                    continue;
                } else if (end == 0) {
                    end = temp;
                    endIndex = index;
                    sum =calc(start,startIndex,end,endIndex,sum,map);
                    start = end;
                    startIndex = endIndex;
                    end = 0;
                }
            }
        }
        return sum;
    }

    private int calc(int start,int startIndex,int end,int endIndex,int sum,Map<Integer, Integer> map){
        int len = Math.min(start, end);
        sum += len * (endIndex - startIndex + 1) - 2 * len;
        for (int i = startIndex + 1; i < endIndex; i++) {
            sum -= map.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int nums[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap(nums));
    }
}
