package Node.RemoveLastXNode;

import Node.ListNode;

/**
 * 方法一：两次遍历算法
 * 思路
 * <p>
 * 我们注意到这个问题可以容易地简化成另一个问题：删除从列表开头数起的第 (L - n + 1)(L−n+1) 个结点，其中 LL 是列表的长度。只要我们找到列表的长度 LL，这个问题就很容易解决。
 * <p>
 * 算法
 * <p>
 * 首先我们将添加一个哑结点作为辅助，该结点位于列表头部。哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。在第一次遍历中，我们找出列表的长度 LL。然后设置一个指向哑结点的指针，并移动它遍历列表，直至它到达第 (L - n)(L−n) 个结点那里。我们把第 (L - n)(L−n) 个结点的 next 指针重新链接至第 (L - n + 2)(L−n+2) 个结点，完成这个算法。
 * <p>
 * Remove the nth element from a list
 * <p>
 * 图 1. 删除列表中的第 L - n + 1 个元素
 * <p>
 * <p>
 * 复杂度分析
 * <p>
 * 时间复杂度：O(L)O(L)，
 * <p>
 * 该算法对列表进行了两次遍历，首先计算了列表的长度 LL 其次找到第 (L - n)(L−n) 个结点。 操作执行了 2L-n2L−n 步，时间复杂度为 O(L)O(L)。
 * <p>
 * 空间复杂度：O(1)O(1)，
 * <p>
 * 我们只用了常量级的额外空间。
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        /**此处first只不过是从head的引用，变成了first.next的引用，所以不会改变head的值.*********************/
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        Solution1 r1 = new Solution1();
        System.out.println(r1.removeNthFromEnd(l1, 1));
    }
}
