public class QuickSort {
    public static int [] quickSort(int[] a){
        if(a.length>0){
        return quickSort(a,0,a.length-1);
        }else{
            throw new IllegalArgumentException("Illegal array !");
        }
    }

    public static int[] quickSort(int[] a, int low, int high){
        int temp;
        //1,找到递归算法的出口
        if( low > high) {
            return null;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[low];
        //4，完成一趟排序
        while(i < j){
            //4.1 ，从右往左找到第一个小于key的数
            while(i < j && a[j] >= key){
                j--;
            }
            //交换
            if(a[j] <= key){
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(a[i] >= key) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，
            // 右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
            //5, 对key左边的数快排
            if(i > low) quickSort(a, low, i-1 );
            //6, 对key右边的数快排
            if(j < high) quickSort(a, i+1, high);
        }
        return a;
    }
}
