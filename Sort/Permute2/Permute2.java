package Sort.Permute2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II(medium)
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Permute2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        permute(list,set, 0, nums);
        return list;
    }

    private static void permute(List<List<Integer>> list,Set<List<Integer>> set, int startIndex, int[] begin) {
        //打印数组的内容
        if (startIndex == begin.length) {
//            System.out.println(Arrays.toString(array));
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < begin.length; i++) {
                tempList.add(begin[i]);
            }
            if(set.add(tempList)) {
                list.add(tempList);
            }
//            System.out.println(Arrays.asList(array));
//            return list;
        } else {
            for (int i = startIndex; i < begin.length; i++) {
                begin = swap(begin, i, startIndex);
                permute(list,set, startIndex + 1, begin);
                //交换回来
                begin = swap(begin, i, startIndex);
            }
        }
    }

    private static int[] swap(int[] n, int a, int b) {
//        int[] n = new int[array.length];
//        System.arraycopy(array, 0, n, 0, array.length);
        int tem = n[a];
        n[a] = n[b];
        n[b] = tem;
        return n;
    }

    public static void main(String[] args){
        Permute2 pm = new Permute2();
        int[] nums = {1,2,3};
        pm.permute(nums);
    }
}

