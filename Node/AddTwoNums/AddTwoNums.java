package Node.AddTwoNums;

import Node.ListNode;

/**
 * 2. 两数相加(中等)
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode ls;
//        count(l1, l2, ls, 0);
          ListNode dummyHead = new ListNode(0);
          ListNode p = l1;
          ListNode q = l2;
          ListNode curr = dummyHead;
          int carry = 0;
          while(p != null || q != null){
              int x = (p != null) ? p.val : 0;
              int y = (q != null) ? q.val : 0;
              int sum = x + y + carry;
              carry = sum /10 ;
              curr.next = new ListNode(sum % 10);
              curr = curr.next;
              if(p != null) p = p.next;
              if(q != null) q = q.next;
          }
          if(carry > 0){
              curr.next = new ListNode(carry);
          }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode ls = new ListNode(0);
        count(l1, l2, ls, 0);
        return ls.next;
    }

    /**
     * 第一次思索，使用递归，结果只能将其存入list中，无法放入ListNode中，故放弃。
     *
     * Update:学习了正确解法，每一次将ls变为ls.next，最后返回除了一开始初始化的0，ls.next即可。
     *
     * @param l1
     * @param l2
     * @param ls
     * @param left
     */
    public void count(ListNode l1, ListNode l2, ListNode ls, int left) {
        if (l1 == null && l2 == null) {
            if (left == 0) {
                return;
            } else {
                ls.next = new ListNode(1);
                return;
            }
        }
        if (l1 != null && l2 != null) {
                ls.next = new ListNode((l1.val + l2.val + left) % 10);
                ls = ls.next;
                left = (l1.val + l2.val + left) / 10;
                count(l1.next, l2.next, ls, left);
        } else {
            ListNode temp = (null != l1) ? l1 : l2;
                ls.next = new ListNode((temp.val + left) % 10);
                ls = ls.next;
                left = (temp.val+ left) / 10;
                count(temp.next, null, ls, left);
        }

    }


    public static void main(String[] args) {
        AddTwoNums addTwoNums = new AddTwoNums();
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        System.out.println(addTwoNums.addTwoNumbers(l1, l2));
        System.out.println(addTwoNums.addTwoNumbers1(l1, l2));

    }
}


