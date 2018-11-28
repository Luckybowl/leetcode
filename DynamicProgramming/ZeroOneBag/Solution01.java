package DynamicProgramming.ZeroOneBag;

/**
 * 0-1背包问题是一个很经典的问题，使用动态规划算法来求解也是很经典的。下面我用一个例子来讲解用动态规划算法求解0-1背包问题。
 * 假设商店中有5件东西，重量用w表示，价格用v表示
 * w={1,2,3,4,5},v={1,4,2,8,9}w={1,2,3,4,5},v={1,4,2,8,9}
 * 现有小偷来到店中，他带了一个袋子能装W = 8斤的东西，应怎样装才使得总价格最高呢？
 * <p>
 * 可能的情况有以下几种：
 * 1. 当装了第k件商品的时候，袋子容量超过最大容量，第k件商品装不了，只能装前k - 1件。
 * 2. 当装了第k件商品后的容量小于袋子的最大容量，要看装划算还是不装划算：
 * a. 当装第k件商品时，袋子现在容量加上第k件商品的容量，价值加上第k件商品的价值
 * b. 当不装第k件商品时，袋子容量不变，价值不变。
 */
public class Solution01 {

    private static int N = 5;
    private static int W = 8;
    private static int[] w = {1, 2, 3, 4, 5};
    private static int[] v = {1, 4, 2, 8, 9};

    public static int search(int index, int S) {
        //时间复杂度O(2^n)
        if (index >= N) {  //选到最后一个不往下面选
            return 0;
        }

        if (S + w[index] > W) {  //重量超过，就不取了
            return 0;
        }

        //选与不选都会跳过index;
        //一个search中有两个search，要解决第一个search的时间复杂度，一定是后一个时间复杂度的两倍
        //S代表当前袋子里东西的重量,一开始以为是价值。。
        return Math.max(search(index + 1, S + w[index]) + v[index], search(index + 1, S));
    }

    public static void main(String[] agrs) {
        System.out.println(search(0, 0));
    }
}
