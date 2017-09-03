package problems.T206;

import java.util.List;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(2);
            head.next = new ListNode(3);
            System.out.println(head);
            System.out.println(new Solution().reverseList(head));
        }
        {
            ListNode head = new ListNode(2);
            System.out.println(head);
            System.out.println(new Solution().reverseList(head));
        }
        {
            ListNode head = new ListNode(1);
            head.setNext(9).setNext(8).setNext(5).setNext(2).setNext(3);
            System.out.println(head);
            System.out.println(new Solution().reverseList(head));
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
     * @param nextVal
     * @return next
     */
    ListNode setNext(int nextVal){
        if(next!=null){
            next.val = nextVal;
        }else{
            next = new ListNode(nextVal);
        }
        return next;
    }

    @Override
    public String toString() {
        if(next!=null){
            return val+"->"+next.toString();
        }else{
            return val+"|";
        }
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next ;
        while (head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}