package problems.T023.v3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode[] tobeMerged = new ListNode[]{
                    new ListNode(0).addTail(1).addTail(2),
                    new ListNode(1).addTail(1).addTail(3).addTail(8),
                    new ListNode(-5).addTail(0).addTail(4).addTail(9)
            };
            for (ListNode listNode : tobeMerged) {
                System.out.println(listNode);
            }
            ListNode merged = new Solution().mergeKLists(tobeMerged);
            System.out.println(merged);
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

/**
 * LeetCode上还有人讨论使用Priority Queue来做这道题
 */
class Solution {
    public ListNode mergeKLists(ListNode[] listNodes) {
        switch (listNodes.length) {
            case 0:
                return null;
            case 1:
                return listNodes[0];
            default:
                PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                        listNodes.length,
                        new Comparator<ListNode>() {
                            @Override
                            public int compare(ListNode o1, ListNode o2) {
                                return Integer.compare(o1.val,o2.val);
                            }
                        }
                );
                for(ListNode node:listNodes){
                    if(node!=null){
                        queue.add(node);
                    }
                }
                ListNode dummy = new ListNode(Integer.MIN_VALUE);
                ListNode p = dummy;
                while (!queue.isEmpty()){
                    p.next = queue.poll();
                    p = p.next;
                    if(p.next!=null){
                        queue.add(p.next);
                    }
                }
                return dummy.next;
        }
    }
}