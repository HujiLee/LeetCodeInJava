package problems.T141_Linked_List_Cycle.v2_use_exception;

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

}

class Solution {

    int print(ListNode head) throws java.lang.StackOverflowError {
        if(head==null) return 0;
        int s = head.val;
        if (head.next != null) {
            s += print(head.next);
        }
        return s;
    }

    public boolean hasCycle(ListNode head) {
        try {
            print(head);
        } catch (java.lang.StackOverflowError e) {
            return true;
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
