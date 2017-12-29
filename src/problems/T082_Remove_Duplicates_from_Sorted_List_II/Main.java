package problems.T082_Remove_Duplicates_from_Sorted_List_II;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(2);
            head.setNext(2).setNext(3).setNext(4).setNext(5).setNext(5);
            System.out.println(head);
            head = new Solution().deleteDuplicates(head);
            System.out.println(head);
        }
        {
            ListNode head = new ListNode(2);
            head.setNext(2).setNext(3).setNext(3).setNext(5).setNext(5);
            System.out.println(head);
            head = new Solution().deleteDuplicates(head);
            System.out.println(head);
        }
        {
            ListNode head = new ListNode(2);
            System.out.println(head);
            head = new Solution().deleteDuplicates(head);
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
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * <p>
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = dummy;
        boolean deleteMyselfFlag = false;
        while (true){
           if(p==null){
               break;
           }
           if(p.next==null){
               break;
           }
           if(p.next.next==null){
               if(deleteMyselfFlag){
                   p.next = null;
               }
               break;
           }
           if(p.next.val==p.next.next.val){
               p.next.next = p.next.next.next;
               deleteMyselfFlag = true;
           }else{
               if(deleteMyselfFlag){
                   p.next = p.next.next;
                   deleteMyselfFlag=false;
               }else{
                   p = p.next;
               }
           }

        }
        return dummy.next;

    }
}