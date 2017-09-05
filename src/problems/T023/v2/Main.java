package problems.T023.v2;

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

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return dummy.next;

    }
    public ListNode merge(ListNode[] lists,int from,int to){
        if(from==to)return lists[from];
        if(from==to-1)return mergeTwoLists(lists[from],lists[to]);

        return mergeTwoLists(
                merge(lists, from, (to+from)/2),
                merge(lists, (from+to)/2+1, to)
        );
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return merge(lists,0,lists.length-1);
    }
}