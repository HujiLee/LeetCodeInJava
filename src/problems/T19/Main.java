package problems.T19;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 只用于debug,不允许Solution中调用
     * @return
     */
    @Override
    public String toString() {
        if(next==null){
            return ""+val;
        }else{
            return val+"->"+next.toString();
        }
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head,p2 = head;
        for(int i = 1;i<n+1;i++){
            p2 = p2.next;
        }
        while (true){
            if(p2==null){
                // 极端情况:头部恰好是倒数第n个节点
                return head.next;
            }else if(p2.next==null){
                //此时p1.next正是倒数第n个节点
                p1.next = p1.next.next;
                return head;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }
}

/**
 * @anchor https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode afterRemoveEnd2th = new Solution().removeNthFromEnd(head,2);
        System.out.println(afterRemoveEnd2th);
        ListNode afterRemoveEnd4th = new Solution().removeNthFromEnd(head,4);
        System.out.println(afterRemoveEnd4th);

    }
}
