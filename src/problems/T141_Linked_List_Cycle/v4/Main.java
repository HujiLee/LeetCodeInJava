package problems.T141_Linked_List_Cycle.v4;

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
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == Integer.MIN_VALUE) return true;
            cur.val = Integer.MIN_VALUE;
            cur = cur.next;
        }
        return false;
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
