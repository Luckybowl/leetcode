package CoinChange;

/**
 *
 * 这个问题个0-1背包问题类似，区别在于每种硬币可以重复使用；做法是从最小的硬币开始，去构成目标解，
 *
 * 直到得到的解大于目标解，就使用下一个硬币组合构成。
 *
 *
 */
public class Solution2 {
    private static int maxValue = 100000000;

    public int coinChange(int[] coins, int amount) {

        int val = search(0, amount, coins);
        if (val < maxValue) {
            return val;
        } else {
            return -1;
        }
    }

    public int search(int index, int amount, int[] coins){
        if(index >= coins.length){
            return maxValue;
        }

        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return maxValue;
        }

        return Math.min(search(index,amount - coins[index],coins) + 1,search(index + 1, amount, coins));
    }

}
