package problems.T083;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(1);
            head.setNext(2).setNext(2).setNext(2).setNext(3).setNext(3).setNext(5).setNext(7).setNext(7);
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
     *
     * @param head a sorted list
     * @return the list after deleting duplicates
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p!=null&&p.next!=null){
            if(p.next.val==p.val){
                //delete next
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }
}