package problems.T141_Linked_List_Cycle.v3_floyd;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }


    /**
     * @param val
     * @return
     * @debug
     */
    ListNode setNext(int val) {
        if (next == null) {
            next = new ListNode(val);
            return next;
        } else {
            return next.setNext(val);
        }
    }

    /**
     * @param node
     * @return
     * @debug
     */
    ListNode setNext(ListNode node) {
        if (next == null) {
            next = node;
            return next;
        } else {
            return next.setNext(node);
        }
    }

    @Override
    public String toString() {
        return Integer.valueOf(val).toString();
    }
}

class Solution {


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow_cur = head;
        ListNode fast_cur = head;
        while (true){
            if(fast_cur==null||fast_cur.next==null||fast_cur.next.next==null)return false;
            slow_cur = slow_cur.next;
            fast_cur = fast_cur.next.next;
            if(fast_cur==slow_cur)return true;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        {
            ListNode listNode = new ListNode(1);
            ListNode node4 = listNode.setNext(8).setNext(9).setNext(4);
            node4.setNext(listNode);
            System.out.println(new Solution().hasCycle(listNode));
        }
        {
            ListNode listNode = new ListNode(1);
            listNode.setNext(listNode);
            System.out.println(new Solution().hasCycle(listNode));
        }

    }
}
