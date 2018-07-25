package CoinChange;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
//    public int coinChange(int[] coins, int amount) {
//        int result = 0 ;
//        Arrays.sort(coins);
//
//
//    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int sum = 0;
        int total = 0;
        for(int k = 0; k < coins.length -1; k ++) {
            for (int i = coins.length - 1; i >= 0; i--) {
                while (sum <= amount) {
                    sum += coins[i];
                    total++;
                }
                sum -= coins[i];
                total--;
                if (sum == amount) {
                    return total;
                }
                int x = i - 1;
                if (x < 0) {
                    return -1;
                }
                for (int j = x; j >= 0; j--) {
                    if (amount - sum >= coins[j]) {
                        i = j;
                        break;
                    }
                    if (j == 0) {
                        total--;
                        sum -= coins[i];

                    }
                }

            }
            if(coins.length - 1 > 0) {
                coins = Arrays.copyOf(coins, coins.length - 1);
            }else{
                return -1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        CoinChange coinChange = new CoinChange();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.print(coinChange.coinChange(coins, amount));
    }
}
