package problems.T061_Rotate_List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class T061 {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(1);
            head.setNext(2);
            System.out.println(head);
            head = new Solution().rotateRight(head,3);
            System.out.println(head);
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
     * @return
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        if(k<1)return head;
        ListNode p = head;
        int count = 1;
        while (p.next!=null){
            p = p.next;
            count++;
        }
        k = k%count;
        if(k==0){
            return head;
        }
        else{
            p.next = head;//保证成为一个环

            p = head;
            for(int i = 1;i<=count-k-1;i++){
                p = p.next;
            }
            ListNode nhead = p.next;
            p.next = null;
            return nhead;
        }
    }
}