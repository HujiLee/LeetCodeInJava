package problems.T002_Add_Two_Numbers;

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
     * DEBUGGER ONLY
     *
     * @return
     */
    @Override
    public String toString() {
        if (next == null) {
            return "" + val;
        } else {
            return next.toString() + "<-" + val;
        }
    }
}

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * 也就是把一个数字用链表倒序的形式存储
 * 比如,180(0->8->1),0(0),12306(6->0->3->2->1)
 * 然后利用这个链表结构求两个数的和
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digitSum = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        ListNode sum = new ListNode(digitSum);
        ListNode p = sum;
        while (true) {
            if (carry == 0) {
                if (l1.next == null && l2.next == null) {
                    return sum;
                } else {
                    if (l1.next == null) {
                        l1.next = new ListNode(0);
                    }
                    if (l2.next == null) {
                        l2.next = new ListNode(0);
                    }
                }
            } else {
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                if (l2.next == null) {
                    l2.next = new ListNode(0);
                }
                l1.next.val += carry;

            }
            l1 = l1.next;
            l2 = l2.next;
            digitSum = (l1.val + l2.val) % 10;
            carry = (l1.val + l2.val) / 10;
            p.next = new ListNode(digitSum);
            p = p.next;
        }
    }
}

/**
 * @anchor https://leetcode.com/problems/add-two-numbers/description/
 */
public class Main {
    static class Helper {
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
                return head;
            }
        }
    }

    public static void main(String[] args) {
        ListNode N180 = Helper.genListFronInt(180);
        ListNode N24973 = Helper.genListFronInt(24973);
        ListNode N180plus24973 = new Solution().addTwoNumbers(N180, N24973);
        System.out.println(N180plus24973);
        N180 = Helper.genListFronInt(180);
        N24973 = Helper.genListFronInt(24973);
        ListNode N24973plusN180 = new Solution().addTwoNumbers(N24973, N180);
        System.out.println(N24973plusN180);
    }
}
