package Sort.Permute;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列(medium)
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, 0, nums);
        return list;
    }

    private static void permute(List<List<Integer>> list, int startIndex, int[] begin) {
        //打印数组的内容
        if (startIndex == begin.length) {
//            System.out.println(Arrays.toString(array));
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < begin.length; i++) {
                tempList.add(begin[i]);
            }
            list.add(tempList);
//            System.out.println(Arrays.asList(array));
//            return list;
        } else {
            for (int i = startIndex; i < begin.length; i++) {
                begin = swap(begin, i, startIndex);
                permute(list, startIndex + 1, begin);
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
        Permute pm = new Permute();
        int[] nums = {1,2,3};
        pm.permute(nums);
    }
}
