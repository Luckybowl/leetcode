package Node.RemoveLastXNode;

import Node.AddTwoNums.ListNode;

/**
 * 19. 删除链表的倒数第N个节点(中等)
 * <p>
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveLastXNode {
    /**此处得用全局变量，类.i的形式，不然i作为局部变量的值就永远是初始值************************/
    /**此处可以不用全局变量来计数（正是因为这样，导致提交失败，但是ide可以成功？）直接新建一个ListNode作为head的引用，用它去自减作判断
     * 别忘了，得保留原先的head，不然head也被改变了
     * （ListNode dummy = new ListNode(0);
     *         dummy.next = head牢记此做法）*************************************/
    static int i = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first;
        if(head.next == null){
            return null;
        }
        count(head, i);
        int m = i - n;
        first = dummy;
        remove(first,m);
//        while(m > 0){
//            m --;
//            first = first.next;
//        }
//        first.next = first.next.next;
        return dummy.next;
    }

    public void count(ListNode head, int i) {
        if (head != null) {
            RemoveLastXNode.i += 1;
            count(head.next, RemoveLastXNode.i );
        }
    }
    @Deprecated
    public void remove(ListNode head, int m) {
        if(m > 0){
            m --;
            head = head.next;
            remove(head,m);
        }
        /**此处只是将head的引用变成了head.next，没有发生数值的变化.*************/
//        head = head.next;
        /**错误，递归导致最后一句会执行两次，先是m = 1>0时，进入递归，此时m = 0 跳过判断，执行一次head.next = head.next.next;
         * 此次执行完，之前那次走出remove（head，0）,再走到下面的head.next = head.next.next,所以执行了两次，这种情况不应该用递归***************************/
//        head.next = head.next.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        RemoveLastXNode rlx = new RemoveLastXNode();
        System.out.println(rlx.removeNthFromEnd(l1, 1));
    }


}
