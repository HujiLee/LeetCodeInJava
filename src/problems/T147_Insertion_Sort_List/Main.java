package problems.T147_Insertion_Sort_List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

/**
 * @anchor https://leetcode.com/problems/insertion-sort-list/description/
 * Sort a linked list using insertion sort.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(0);
            head.setNext(0).setNext(0);
            System.out.println(head);
            head = new Solution().insertionSortList(head);
            System.out.println(head);
        }
        {
            ListNode head = new ListNode(0);
            head.setNext(8).setNext(-1).setNext(2).setNext(1).setNext(2).setNext(3).setNext(-2);
            System.out.println(head);
            head = new Solution().insertionSortList(head);
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
     * 只用于debug,不允许Solution中调用
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        ListNode p = this;
        while (true) {
            if (p.next == null) {
                stringBuffer.append(p.val);
                break;
            } else {
                stringBuffer.append(p.val + "->");
            }
            p = p.next;
        }
        return stringBuffer.toString();
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newlist = null;
        ListNode p = head, temp;
        while (true) {
            if (p == null) {
                break;
            }
            temp = p;
            p = p.next;
            if (newlist == null) {
                newlist = temp;
                newlist.next = null;
            } else {
                ListNode n = newlist;
                if(n.val>=temp.val){
                    temp.next = n;
                    newlist = temp;
                }else{
                    while (n!=null){
                        if(n.val<temp.val){
                            if(n.next==null||n.next.val>=temp.val){
                                temp.next = n.next;
                                n.next = temp;
                                break;
                            }
                        }
                        n = n.next;
                    }
                }

            }
        }
        return newlist;
    }
}