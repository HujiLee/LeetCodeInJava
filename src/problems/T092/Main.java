package problems.T092;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(7);
            head.setNext(8).setNext(9).setNext(0).setNext(1);
            System.out.println(head);
            ListNode[] reversed = new Solution().reverse(head.next.next);
            System.out.println(reversed[0]);
            System.out.println(head);
        }
        {
            ListNode head = new ListNode(7);
            head.setNext(8).setNext(9).setNext(0).setNext(1);
            System.out.println(head);
            head = new Solution().reverseBetween(head,2,3);
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
    public ListNode[] reverse(ListNode head) {
        ListNode prev = null;
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return new ListNode[]{prev, head};
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //我的思路:把n位置及之后的链条先断开,reverse完m位置以后再把它接回去
        ListNode np = head;
        for(int i = 1;i<=n-1;i++){
            np = np.next;
        }
        ListNode right = np.next;
        np.next = null;
        ListNode left = null;
        if(m>1){
            ListNode mp = head;
            for(int i = 1;i<=m-2;i++){
                mp  = mp.next;
            }
            left = mp;
        }
        ListNode[] reversed;
        if(left!=null){
            reversed = reverse(left.next);
            left.next = reversed[0];
        }else{
            reversed = reverse(head);
            head = reversed[0];
        }
        reversed[1].next = right;

        return head;
    }
}