package problems.T141_Linked_List_Cycle.v1_hash_map;


import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }


    /**
     * @debug
     * @param val
     * @return
     */
    ListNode setNext(int val){
        if(next==null){
            next = new ListNode(val);
            return next;
        }else{
            return next.setNext(val);
        }
    }

    /**
     * @debug
     * @param node
     * @return
     */
    ListNode setNext(ListNode node){
        if(next==null){
            next = node;
            return next;
        }else {
            return next.setNext(node);
        }
    }

}

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode cursor = head;
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (cursor.next!=null){
            if(set.contains(cursor)){
                return true;
            }
            set.add(cursor);
            cursor = cursor.next;
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
