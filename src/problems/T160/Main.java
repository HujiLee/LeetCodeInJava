package problems.T160;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class Main {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    int getLength(ListNode head){
        ListNode l = head;
        int count = 0;
        while (l!=null){
            count++;
            l = l.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA==0&&lenB==0){
            return null;
        }
        ListNode pa=headA,pb=headB;
        if(lenA>lenB){
            for(int i = 1;i<=lenA-lenB;i++){
                pa = pa.next;
            }
        }else {
            for(int i = 1;i<=lenB-lenA;i++){
                pb = pb.next;
            }
        }
        while (pa!=null){
            if(pa==pb){
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}