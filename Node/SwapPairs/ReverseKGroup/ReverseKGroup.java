package Node.SwapPairs.ReverseKGroup;

import Node.ListNode;
import Node.SwapPairs.SwapPairs;

import java.util.Arrays;

/**
 * 25. k个一组翻转链表(困难)
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * p.s:此题的测试用例很坑，明明说“k 是一个正整数，它的值小于或等于链表的长度”。但仍然有反例，差评。
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        if (k == 1 || head == null || head.next == null) {
            return dummy.next;
        }
//        /**先写写3个的情况***************************/
//        while (head.next != null && head.next.next != null && head.next.next.next != null) {
//            ListNode n1 = head.next, n2 = head.next.next, n3 = head.next.next.next;
//            // head->n1->n2->n3...
//            // => head->n3->n2->n1->...
//            head.next = n3;
//            n1.next = n3.next;
//            n2.next = n1;
//            n3.next = n2;
//            // move to next pair
//            head = n1;
//        }
//
//        /**先写写4个的情况***************************/
//        while (head.next != null && head.next.next != null && head.next.next.next != null && head.next.next.next.next != null) {
//            ListNode n1 = head.next, n2 = head.next.next, n3 = head.next.next.next, n4 = head.next.next.next.next;
//            // head->n1->n2->n3->n4...
//            // => head->n4->n3->n2->n1->...
//            head.next = n4;
//            n1.next = n4.next;
//            n3.next = n2;
//            n2.next = n1;
//            n4.next = n3;
//            // move to next pair
//            head = n1;
//        }
        ListNode[] ln = new ListNode[k];
        ln[0] = head.next;
        for (int i = 1; i < k; i++) {
            /**为了避免k>链表长度*****************/
            if(ln[i - 1].next == null){
                return dummy.next;
            }
            ln[i] = ln[i - 1].next;
        }
        while (ln[0] != null && ln[k - 1] != null) {
            for (int i = 0; i < k; i++) {
                if(ln[i] == null){
                    return dummy.next;
                }
            }
            head.next = ln[k - 1];
            ln[0].next = ln[k - 1].next;
            for (int i = k - 1; i > 0; i--) {
                ln[i].next = ln[i - 1];
            }
            head = ln[0];
            ln[0] = head.next;
            for (int i = 1; i < k; i++) {
                if(ln[i - 1] == null){
                    break;
                }
                ln[i] = ln[i - 1].next;
            }

        }

//        System.out.print("stop!"); //方便调试的断点
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        ReverseKGroup mt = new ReverseKGroup();
        System.out.println(mt.reverseKGroup(l1, 3));
    }
}
