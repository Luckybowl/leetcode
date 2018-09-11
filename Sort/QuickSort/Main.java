package Sort.QuickSort;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        int[] b = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] c = new int[]{10,2,3,2,1,2,3,7,3,3};
        int[] d = new int[]{1,10,2,9,3,2,4,7,5,6};

        QuickSort.sort(d, 0, d.length-1);
        QuickSort.quickSort(c, 0, c.length-1);
        System.out.println("排序后的结果：");
        for(int x : c){
            System.out.print(x+" ");
        }
        System.out.println();
        for(int x : d){
            System.out.print(x+" ");
        }
    }

}
