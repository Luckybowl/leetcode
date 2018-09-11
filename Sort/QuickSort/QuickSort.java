package Sort.QuickSort;

public class QuickSort {
    @Deprecated
    public static int [] quickSort(int[] a){
        if(a.length>0){
        return quickSort(a,0,a.length-1);
        }else{
            throw new IllegalArgumentException("Illegal array !");
        }
    }
    @Deprecated
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

    public static int divide(int[] a, int start, int end){
        //每次都以最右边的元素作为基准值
        int base = a[end];
        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
        while(start < end){
            while(start < end && a[start] <= base)
                //从左边开始遍历，如果比基准值小，就继续向右走
                start++;
            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                end--;
            }
            while(start < end && a[end] >= base)
                //从右边开始遍历，如果比基准值大，就继续向左走
                end--;
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }

        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }

    /**
     * 排序
     * @param a
     * @param start
     * @param end
     */
    public static int[] sort(int[] a, int start, int end){
        if(start > end){
            //如果只有一个元素，就不用再排下去了
            return null;
        }
        else{
            //如果不止一个元素，继续划分两边递归排序下去
            //先找到基准点
            int partition = divide(a, start, end);
            sort(a, start, partition-1);
            sort(a, partition+1, end);
        }
        return a;

    }
}
