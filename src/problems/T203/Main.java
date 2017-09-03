package problems.T203;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(9);
            head.setNext(8).setNext(9).setNext(9).setNext(1).setNext(9);
            System.out.println(head);
            System.out.println(new Solution().removeElements(head,9));
        }
        {
            ListNode head = new ListNode(9);
            head.setNext(8).setNext(5).setNext(2).setNext(1).setNext(0);
            System.out.println(new Solution().removeElements(head,9));
        }
        {
            ListNode head = new ListNode(9);
            head.setNext(8).setNext(5).setNext(2).setNext(1).setNext(0);
            System.out.println(new Solution().removeElements(head,0));
        }
        {
            ListNode head = new ListNode(9);
            head.setNext(8).setNext(5).setNext(2).setNext(1).setNext(0);
            System.out.println(new Solution().removeElements(head,5));
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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode p = head;
        while (p.next!=null){
            if(p.next.val==val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        if(head.val==val){
            if(head.next!=null)return head.next;
            else return null;
        }
        return head;
    }
}