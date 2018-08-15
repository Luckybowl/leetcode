package Node.SwapPairs;

import Node.ListNode;

/**
 * 更改值的方式进行交换
 */
public class Solution2 {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode p = head;
        if (p == null || p.next == null)
            return p;

        while (p != null && p.next != null) {
            int val = p.val;
            p.val = p.next.val;
            p.next.val = val;
            p = p.next.next;
        }
        return head;

    }
}