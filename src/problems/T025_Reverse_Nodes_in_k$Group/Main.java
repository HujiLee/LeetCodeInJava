package problems.T025_Reverse_Nodes_in_k$Group;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }
}

public class Main {
    public static void main(String[] args) {

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