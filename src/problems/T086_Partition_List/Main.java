package problems.T086_Partition_List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
//https://leetcode.com/problems/partition-list/description/
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(0);
            head.setNext(-1).setNext(5).setNext(0).setNext(-8).setNext(2).setNext(6);
            System.out.println(head);
            head = new Solution().partition(head, 0);
            System.out.println(head);
        }
        {
            ListNode head = new ListNode(0);
            System.out.println(head);
            head = new Solution().partition(head, 0);
            System.out.println(head);
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * DEBUG ONLY
     *
     * @param val
     * @return
     */
    ListNode setNext(int val) {
        if (next == null) {
            next = new ListNode(val);
            return next;
        } else {
            next.val = val;
            return next;
        }
    }

    /**
     * DEBUG ONLY
     *
     * @return
     */
    @Override
    public String toString() {
        if (next == null) {
            return val + "|";
        } else {
            return val + "->" + next.toString();
        }
    }
}

class Solution {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * For example,
     * Given 1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     * <p>
     * 在LeetCode的Custom Testcase里继续举例子
     * 输入[0,-1,5,0,-8,2,6]和0
     * 期望输出为[-1,-8,0,5,0,2,6]
     * <p>
     * 可见并不是要排序,只是把小于0的数字移到前面,仍然保持-1在-8之前的相对顺序,仍然保持0,5,0,2,6的相对顺序
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode p = dummy;
        ListNode left = new ListNode(Integer.MIN_VALUE);
        ListNode pleft = left;
        while (p.next != null) {
            if (p.next.val < x) {
                pleft.next = p.next;
                p.next = p.next.next;
                pleft.next.next = null;
                pleft = pleft.next;
            } else {
                p = p.next;
            }
        }
        pleft.next = dummy.next;
        return left.next;
    }
}