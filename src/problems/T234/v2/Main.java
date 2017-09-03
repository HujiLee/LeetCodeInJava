package problems.T234.v2;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class Main {
    public static void main(String[] args) {
        {
            ListNode head = new ListNode(2);
            head.next = new ListNode(3);
            System.out.println(head);
            System.out.println(new Solution().isPalindrome(head));
        }
        {
            ListNode head = new ListNode(2);
            head.next = new ListNode(3);
            head.next.next = new ListNode(4);
            head.next.next.next = new ListNode(5);
            System.out.println(head);
            System.out.println(new Solution().isPalindrome(head));
        }
    }
}

class Solution {
    /**
     * @param head 翻转前链表的头
     * @return 反转后链表的头
     */
    public ListNode reverseMyVersion(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head, prev = null, after = null;
        while (true) {
            prev = node;
            if (node == head) {
                node = node.next;
            } else {
                node = after;
            }
            if (node == null) {
                return prev;
            }
            if (after == null) {
                after = node.next;
            } else {
                after = after.next;
            }
            if (prev == head) {
                prev.next = null;
            }
            if (after == null) {
                node.next = prev;
                return node;
            }
            node.next = prev;
        }

    }

    /**
     * https://discuss.leetcode.com/topic/33376/java-easy-to-understand
     * 看起来更简短的reverse实现
     * @param head
     * @return
     */
    ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head){
        if(head==null){
            return true;
        }
        ListNode slow=head,fast = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head,right = reverse(slow);
        while (left!=null&&right!=null){
            if(left.val!=right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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
        while (true){
            if(p.next==null){
                stringBuffer.append(p.val);
                break;
            }else{
                stringBuffer.append(p.val+"->");
            }
            p = p.next;
        }
        return stringBuffer.toString();
    }
}
/**
 * 参考https://discuss.leetcode.com/topic/33376/java-easy-to-understand里的思路
 * This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].
 * <p>
 * In the beginning, set two pointers fast and slow starting at the head.
 * <p>
 * 1 -> 1 -> 2 -> 1 -> null
 * sf
 * (1) Move: fast pointer goes to the end, and slow goes to the middle.
 * <p>
 * 1 -> 1 -> 2 -> 1 -> null
 * s          f
 * (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
 * <p>
 * 1 -> 1    null <- 2 <- 1
 * h                      s
 * (3) Compare: run the two pointers head and slow together and compare.
 * <p>
 * 1 -> 1    null <- 2 <- 1
 * h            s
 * 有两个指针,s(slow)和f(fast)
 * slow每次跳1格,fast每次跳两格,直到fast到达末尾,那么slow就大概在中间的位置了
 * 然后把slow后面的那一部分链表反转!
 */