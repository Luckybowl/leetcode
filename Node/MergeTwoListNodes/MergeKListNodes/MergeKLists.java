package Node.MergeTwoListNodes.MergeKListNodes;

import Node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 23. 合并K个排序链表(困难)
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode ln : lists){
            while(ln != null){
                list.add(ln.val);
                ln = ln.next;
            }
        }
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
}
