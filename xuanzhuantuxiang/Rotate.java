package xuanzhuantuxiang;

/**
 * 48. 旋转图像(medium)
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int rowNums = matrix.length;
        int columnNums = matrix[0].length;
        int[] temp;
        int x;
        if (matrix == null || rowNums == 0 || columnNums == 0) {
            return;
        }
        //先把数组的每一行上下交换
        for (int i = 0; i < rowNums / 2; i++) {
            temp = matrix[i];
            matrix[i] = matrix[rowNums - 1 - i];
            matrix[rowNums - 1 - i] = temp;
        }

        //再将沿着对角线的数据互相交换
        for (int i = 1; i < rowNums; i ++ ) {
            for (int j = 0; j < i ; j++) {
                x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }
    }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        r.rotate(matrix);
    }
}