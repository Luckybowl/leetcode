package DynamicProgramming.ZeroOneBag;

/**
 * 修改为动态规划：
 */
public class Solution02 {
    private static int N = 5;
    private static int W = 8;
    private static int[] w={1, 2, 3, 4, 5};
    private static int[] v={1, 4, 2, 8, 9};
    private static int[] result;
    public static int solve(int index, int S){
        //空间复杂度N*W，时间复杂度N*W
        if (index >= N){  //选到最后一个，再往下面选就是0
            return 0;
        }

        if(S + w[index] > W){  //重量超过，就不取了
            return 0;
        }

        if (result[index] >= 0){
            return result[index];
        }

        result[index] = Math.max(solve(index + 1, S + w[index]) + v[index], solve( index + 1, S));
        return result[index];
    }

    public static int search(int index, int S){
        result = new int[N];

        for (int i = 0; i < N; i++){
            result[i] = -1;

        }

        return solve(index, S);
    }

    public static  void main(String[] agrs){
        System.out.println(search( 0, 0));
    }
}