package problems.T021_Merge_Two_Sorted_Lists;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head1 = new ListNode(0);
            head1.setNext(2).setNext(3).setNext(5).setNext(7).setNext(9);
            ListNode head2 = new ListNode(-5);
            head2.setNext(1).setNext(3).setNext(4).setNext(8);
            System.out.println(head1);
            System.out.println(head2);
            ListNode merged = new Solution().mergeTwoLists(head1,head2);
            System.out.println(merged);
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode p = dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null){
            p.next = l1;
        }else{
            p.next = l2;
        }
        return dummy.next;

    }
}