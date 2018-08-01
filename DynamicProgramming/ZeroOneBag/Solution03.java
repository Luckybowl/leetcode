package DynamicProgramming.ZeroOneBag;

/**
 * 修改为递推
 */
public class Solution03 {
    //递归有从上到下的拆解过程，递推没有
    private static int N = 5;
    private static int W = 8;
    private static int[] w = {1, 2, 3, 4, 5};
    private static int[] v = {1, 4, 2, 8, 9};

    public static int search(int index, int S) {
        //设置边界
        int[][] result = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            result[i][0] = 0;
        }

        for (int j = 0; j <= W; j++) {
            result[0][j] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < w[i - 1]) {
                    result[i][j] = result[i - 1][j];
                } else {
                    result[i][j] = Math.max(result[i - 1][j - w[i - 1]] + v[i - 1], result[i - 1][j]);
                }
            }
        }
        return result[N][W];
    }

    public static void main(String[] agrs) {
        System.out.println(search(0, 0));
    }
}