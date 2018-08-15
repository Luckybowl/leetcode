package Node.MergeTwoListNodes;

import Node.ListNode;

/**
 * 变量注释：
 *
 * firstNode //相当于头节点
 *
 * 思路：
 *
 * 这个题目就是归并排序中的归并操作，将两个有序数组(链表)合并为一个有序的数组。
 *
 * //第一个while循环，将 l1 和 l2 进行比较，谁小谁就合并到 listNode，直到 l1 或者 l2 为空
 *
 * //第二个while循环和第三个while循环，将 l1 或者 l2 剩下的节点合并到 listNode
 *
 * 最后返回的是 firstNode.next //头节点是不需要的
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode firstNode = listNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        while (l1 != null) {
            listNode.next = l1;
            l1 = l1.next;
            listNode = listNode.next;
        }
        while (l2 != null) {
            listNode.next = l2;
            l2 = l2.next;
            listNode = listNode.next;
        }
        return firstNode.next;
    }
}
