package problems;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class T061 {
    public static void main(String[] args) {
        {

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
        ListNode p = head;
        boolean kBigger = false;//k是否会超出链表的长度
        while (k>0){
            p = p.next;
            if(p.next==null){
                p.next=head;//成环
                kBigger = true;
            }
            k--;
        }
        if(kBigger){
            ListNode newHead = p.next;
            p.next = null;
            return newHead;
        }else{
            ListNode newHead = p.next;
            p.next=null;
            p = newHead;
            while (true){
                if(p.next!=null){
                    p = p.next;
                }else {
                    p.next = head;
                    break;
                }
            }
            return newHead;
        }

    }
}