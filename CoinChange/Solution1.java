package CoinChange;

/**
 * 动态规划：将计算结果保存在特定结构里，这种结构可能是（一维数组、二维数组、三维数组或者Map），
 * 将原始问题分解成子问题，先求子问题，从这些子问题的解得到原始问题的解。
 */
public class Solution1 {
    private static int[][] result;

    private static int maxValue = 100000000;

    public int search(int index, int amount, int[] coins) {
        if (index >= coins.length) {
            return maxValue;
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return maxValue;
        }

        if (result[index][amount] >= 0) {
            return result[index][amount];
        }

        result[index][amount] = Math.min(search(index, amount - coins[index], coins) + 1,
                search(index + 1, amount, coins));
        return result[index][amount];
    }

    public int coinChange(int[] coins, int amount) {
        result = new int[20][10000];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10000; j++) {
                result[i][j] = -1;
            }
        }

        int val = search(0, amount, coins);
        if (val < maxValue) {
            return val;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Solution1 s = new Solution1();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.print(s.coinChange(coins, amount));
    }
}