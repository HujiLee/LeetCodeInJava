package problems.T328_Odd_Even_Linked_List;


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
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode evenHead,odd,even = null;
        odd = head;
        evenHead = null;
        while (true){
            if(odd.next==null){
                if(even!=null){
                    even.next=null;
                }
                break;
            }
            {
                if(evenHead==null){
                    evenHead=odd.next;
                    even=odd.next;
                }else{
                    even.next = odd.next;
                    even=even.next;
                }
            }
            if(odd.next.next==null){
                break;
            }
            odd.next = odd.next.next;
            odd = odd.next;
            //最后break之前要确保odd是最后一个奇数位节点
        }
        odd.next = evenHead;
        return head;
    }
}

/**
 * Created by Administrator on 2017/9/3 0003.
 *
 * @anchor https://leetcode.com/problems/odd-even-linked-list/description/
 */

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class Main {
    static ListNode genRandomList(int length){
        ListNode head = new ListNode((int) (Math.random()*10));
        ListNode p = head;
        for(int i =2;i<=length;i++){
            p.next = new ListNode((int) (Math.random()*10));
            p = p.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = genRandomList(1);
        ListNode l2 = genRandomList(2);
        ListNode l3 = genRandomList(3);
        ListNode l4 = genRandomList(4);
        ListNode l10 = genRandomList(10);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println(l10);
        System.out.println(new Solution().oddEvenList(l1));
        System.out.println(new Solution().oddEvenList(l2));
        System.out.println(new Solution().oddEvenList(l3));
        System.out.println(new Solution().oddEvenList(l4));
        System.out.println(new Solution().oddEvenList(l10));

    }
}
