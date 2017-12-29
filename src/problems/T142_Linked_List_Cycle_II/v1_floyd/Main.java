package problems.T142_Linked_List_Cycle_II.v1_floyd;

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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while (true){
            if(fast==null||fast.next==null||fast.next.next==null)return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                break;
            }
        }
        while (true){
            if(slow==fast)return slow;
            slow = slow.next;
            fast = fast.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        {
            ListNode listNode = new ListNode(1);
            ListNode node4 = listNode.setNext(8).setNext(9).setNext(4);
            node4.setNext(listNode);
            System.out.println(new Solution().detectCycle(listNode));
        }
        {
            ListNode listNode = new ListNode(1);
            ListNode node2 = listNode.setNext(2);
            node2.setNext(3).setNext(4).setNext(5).setNext(6).setNext(node2);
            System.out.println(new Solution().detectCycle(listNode));
        }

    }
}
