package Trap;

/***
 * 木桶原理，盛的水取决于最短板。。。我们设置两个指针从左右两端开始向中间靠拢。。。
 *
 * 我们根据短的那一端向高的那一端靠拢。
 */
public class Trap1 {
    public int trap(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int res = 0;
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > height[left]) {
                    res += (leftHeight - height[left]);
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if (rightHeight > height[right]) {
                    res += (rightHeight - height[right]);
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Trap1 trap = new Trap1();
        int nums[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap(nums));
    }
}
