package problems.T148;

/**
 * Created by Administrator on 2017/9/3 0003.
 */

import java.util.List;

/**
 * @acchor https://leetcode.com/problems/sort-list/description/
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head1 = new ListNode(2);
            head1.setNext(5).setNext(7).setNext(8).setNext(11).setNext(3).setNext(6).setNext(12);
            System.out.println(head1);
            ListNode head3 = new Solution().mergeSort(head1);
            System.out.println(head3);
        }
        {
            ListNode head1 = new ListNode(1);
            head1.setNext(0).setNext(2);
            System.out.println(head1);
            ListNode head3 = new Solution().mergeSort(head1);
            System.out.println(head3);
        }
        {
            ListNode head1 = new ListNode(1);
            head1.setNext(0);
            System.out.println(head1);
            ListNode head3 = new Solution().mergeSort(head1);
            System.out.println(head3);
        }

        {
            ListNode head1 = new ListNode(1);
            head1.setNext(3).setNext(5).setNext(7).setNext(9);
            ListNode head2 = new ListNode(2);
            head2.setNext(4).setNext(6).setNext(8);
            System.out.println(head1);
            System.out.println(head2);
            ListNode head3 = new Solution().merge(head1, head2);
            System.out.println(head3);
        }
        {
            ListNode head1 = new ListNode(1);
            head1.setNext(2).setNext(5).setNext(7).setNext(9);
            ListNode head2 = new ListNode(12);
            head2.setNext(14).setNext(16).setNext(18);
            System.out.println(head1);
            System.out.println(head2);
            ListNode head3 = new Solution().merge(head1, head2);
            System.out.println(head3);
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
    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode nHead = mergeSort(head);
        ListNode nRight = mergeSort(right);
        return merge(nHead, nRight);
    }

    /**
     * @param head1 sorted list 1
     * @param head2 sorted list 2
     * @return the merged new sorted list
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2;
        ListNode head = null, pnew = null, p;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p = p2;
                p2 = p2.next;
            } else {
                p = p1;
                p1 = p1.next;
            }
            p.next = null;
            if (head == null) {
                head = p;
                pnew = head;
            } else {
                pnew.next = p;
                pnew = pnew.next;
            }
        }
        if (p1 != null) {
            pnew.next = p1;
        } else if (p2 != null) {
            pnew.next = p2;
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        //try merge sort
        return mergeSort(head);
    }
}
