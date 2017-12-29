package problems.T024_Swap_Nodes_in_Pairs.v1;

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
     * @return next
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
     * DEVUG ONLY
     *
     * @param val
     * @return this
     */
    ListNode addTail(int val) {
        ListNode p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(val);
        return this;
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur1 = head, cur2 = head.next;
        ListNode new_head = cur2;

        if (cur2 == null) return new_head;
        cur1.next = cur2.next;
        cur2.next = cur1;
        if (cur1.next == null) return new_head;
        cur1.next = swapPairs(cur1.next);


        return new_head;
    }
}

public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(1);
            head.setNext(2).setNext(3).setNext(4);
            System.out.println(new Solution().swapPairs(head));
        }
        {
            ListNode head = new ListNode(1);
            head.setNext(2);
            System.out.println(new Solution().swapPairs(head));
        }
        {
            ListNode head = new ListNode(1);
            head.setNext(2).setNext(3);
            System.out.println(new Solution().swapPairs(head));
        }

    }


}
