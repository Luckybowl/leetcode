package Node.RemoveLastXNode;

import Node.AddTwoNums.ListNode;

/**
 * 方法二：一次遍历算法
 * 算法
 * <p>
 * 上述算法可以优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。现在，这两个指针被 nn 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
 * <p>
 * Remove the nth element from a list
 * <p>
 * 图 2. 删除链表的倒数第 N 个元素
 *
 * 时间复杂度：O(L)O(L)，
 *
 * 该算法对含有 LL 个结点的列表进行了一次遍历。因此时间复杂度为 O(L)O(L)。
 *
 * 空间复杂度：O(1)O(1)，
 *
 * 我们只用了常量级的额外空间。
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
