package IsRectangleOverlap;

public class IsRectangleOverlap {

    /**
     *矩形重叠
     *
     * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
     * <p>
     * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
     * <p>
     * 给出两个矩形，判断它们是否重叠并返回结果。
     * <p>
     * 示例 1：
     * <p>
     * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
     * 输出：false
     * 说明：
     * <p>
     * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
     * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
     *
     * @param rec1
     * @param rec2
     * @return
     */
    @Deprecated
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1.length != 4 && rec2.length != 4) {
            throw new IllegalArgumentException("Illegal rec!");
        }
        if (rec1[0] == rec2[0] && rec1[1] == rec2[1] && rec1[2] == rec2[2] && rec1[3] == rec2[3]) {
            return true;
        }
        int dside1 = calc(rec1)[0];
        int hside1 = calc(rec1)[1];
        int dside2 = calc(rec2)[0];
        int hside2 = calc(rec2)[1];

        //1.0 考虑rec2在rec1右边重叠
        if ((rec1[0] < rec2[0] && rec1[0] + dside1 > rec2[0]) || (rec2[0] < rec1[0] && (rec2[0] + dside2) > rec1[0])) {
            //1.1在右上重叠
            if (rec1[1] <= rec2[1] && rec1[1] + hside1 > rec2[1]) {
                return true;
            }
            //1.2在右下重叠
            if (rec2[1] <= rec1[1] && rec2[1] + hside2 > rec1[1]) {
                return true;
            }

        }
        //1.3考虑边重合情况 TODO 只考虑了一个点，还剩三个点要做，不想做了..
        if (rec1[0] == rec2[0]) {
            //矩形1包含矩形2
            if (rec1[0] + dside1 > rec2[0] + dside2) {
                if (rec1[1] > rec2[1] && rec1[1] < rec2[1] + hside2) {
                    return true;
                }
                if (rec1[3] > rec2[1] && rec1[3] < rec2[1] + hside2) {
                    return true;
                }
                //矩形2包含矩形1
            } else if (rec1[0] + dside1 < rec2[0] + dside2) {
                if (rec2[1] > rec1[1] && rec2[1] < rec1[1] + hside1) {
                    return true;
                }
                if (rec2[3] > rec1[1] && rec2[3] < rec1[1] + hside1) {
                    return true;
                }
            }
        }

        if (dside1 < dside2 && hside1 < hside2 && rec1[0] > rec2[0] && (rec1[0] + dside1) < (rec2[0] + dside2)
                && rec1[1] > rec2[1] && (rec1[1] + hside1) < (rec2[1] + hside2)) {
            if (rec1[1] >= rec2[1] && (rec1[3] + hside1) <= (rec2[3] + hside2)) {
                return true;
            }
        }
        if (dside2 < dside1 && hside2 < hside1 && rec2[0] > rec1[0] && (rec2[0] + dside2) < (rec1[0] + dside1)
                && rec2[1] > rec1[1] && (rec2[1] + hside2) < (rec1[1] + hside1)) {
            if (rec2[1] > rec1[1] && (rec2[3] + hside2) < (rec1[3] + hside1)) {
                return true;
            }
        }

//        //2.0 考虑rec2在rec1左边边重叠
//        if(rec2[0] < rec1[0] && rec2[0] + side2 > rec1[0]){
//            //2.1在左上重叠
//            if(rec1[1] < rec2[1] && rec1[1] + side1 > rec2[1]){
//                return true;
//            }
//            //2.2在左下重叠
//            if(rec2[1] < rec1[1] && rec2[1] + side2 > rec1[1]){
//                return true;
//            }
//        }

        return false;

    }

    public int[] calc(int[] rec) {
        int dside = rec[2] - rec[0];
        int hside = rec[3] - rec[1];
        return new int[]{dside, hside};
    }

    /*******
     * 大佬的解法
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapX(int[] rec1, int[] rec2) {
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }

    public static void main(String[] args) {
        IsRectangleOverlap isRectangleOverlap = new IsRectangleOverlap();
        int[] rec1 = {-6, -10, 9, 2};
        int[] rec2 = {0, 5, 4, 8};
        System.out.println(isRectangleOverlap.isRectangleOverlapX(rec1, rec2));
    }

}
