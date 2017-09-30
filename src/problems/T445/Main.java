package problems.T445;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * DEBUGGER ONLY
     *
     * @return
     */
    @Override
    public String toString() {
        if (next == null) {
            return "" + val;
        } else {
            return val + "->" +next.toString() ;
        }
    }
}
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode nList = dummy;
        ListNode p1 = l1,p2 = l2;
        int carry = 0;
        while (true){
            nList.next = new ListNode((p1.val+p2.val+carry)%10);
            carry = (p1.val+p2.val+carry)/10;
            nList = nList.next;
            if(carry==0){
                if(p1.next==null&&p2.next==null){
                    break;
                }else {
                    if(p1.next==null){
                        nList.next = p2.next;
                        break;
                    }else if(p2.next==null){
                        nList.next = p1.next;
                        break;
                    }
                }
            }else{
                if(p1.next==null&&p2.next==null){
                    nList.next = new ListNode(carry);
                    break;
                }
                if(p1.next==null){
                    p1.next = new ListNode(carry);
                    carry=0;
                }else if(p2.next==null){
                    p2.next = new ListNode(carry);
                    carry=0;
                }

            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return reverse(dummy.next);
    }
    static ListNode reverse(ListNode listhead){
        ListNode prev = null;
        ListNode next;
        ListNode h =listhead;
        while (h!=null){
            next = h.next;
            h.next = prev;
            prev = h;
            h = next;
        }
        return prev;
    }
}
 class Helper {
    static ListNode genListFronInt(int nonNegativeInteger) {
        if (nonNegativeInteger == 0) {
            return new ListNode(0);
        } else {
            String[] strings = String.valueOf(nonNegativeInteger).split("");
            int[] ints = new int[strings.length];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.parseInt(strings[ints.length - i - 1]);
            }
            ListNode head = new ListNode(ints[0]);
            ListNode p = head;
            for (int i = 1; i < ints.length; i++) {
                p.next = new ListNode(ints[i]);
                p = p.next;
            }
            return Solution.reverse(head);
        }
    }
}
public class Main {

    public static void main(String[] args) {
        {
            ListNode N9993 = Helper.genListFronInt(9993);
            ListNode N980 = Helper.genListFronInt(980);
            ListNode sum = new Solution().addTwoNumbers(N9993,N980);
            System.out.println(sum);
        }
        {
            ListNode N180 = Helper.genListFronInt(180);
            ListNode N24973 = Helper.genListFronInt(24973);
            ListNode N180plusN24973 = new Solution().addTwoNumbers(N180,N24973);
            System.out.println(N180plusN24973);
        }


    }
}
