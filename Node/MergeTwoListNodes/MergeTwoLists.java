package Node.MergeTwoListNodes;

import Node.AddTwoNums.ListNode;

import java.util.*;

/**
 * 21. 合并两个有序链表(简单)
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while(l1 != null){
            list.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            list.add(l2.val);
            l2 = l2.next;
        }
        /********下面的写法是不对的，此数组无法强制转化**********************/
//        Integer[] array = (Integer[]) list.toArray();
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        Arrays.sort(array);
        ListNode dummy = new ListNode(0);
        add(dummy,0,array);
        return dummy.next;
    }

    public void add(ListNode l, int i,Integer[] array){
        if(i < array.length) {
            /**此处必须给l.next赋值,若给l赋值，则没有任何变化*****************/
            l.next = new ListNode(array[i]);
            i++;
            add(l.next, i, array);
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next= new ListNode(4);
        MergeTwoLists mt = new MergeTwoLists();
        System.out.println(mt.mergeTwoLists(l1,l2));
    }

}
