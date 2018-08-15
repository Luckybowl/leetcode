package Node.SwapPairs;

/**
 * 递归方式
 * 交换p 和 p.next 结点
 * swapHead = p.next
 * swapHead.next = p
 */

import Node.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode p = head;
        if (p == null || p.next == null)
            return p;
        ListNode pNextNext = p.next.next;
        ListNode swapHead = p.next; // 交换p 和 p.next 两个结点
        swapHead.next = p; // 进行交换
        ListNode swapNextNext = swapPairs(pNextNext); // 递归
        p.next = swapNextNext;
        return swapHead;
    }

}