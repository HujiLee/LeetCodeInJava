package problems.T237_Delete_Node_in_a_Linked_List;

/**
 * Created by Administrator on 2017/9/3 0003.
 */

/**
 * @anchor https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(head);
        new Solution().deleteNode(head.next.next);
        System.out.println(head);
    }
}
class Solution {
    /**
     * @param node 需要被删除的节点的引用;题目规定这个节点不是最末尾的节点
     */
    public void deleteNode(ListNode node) {
        //事实上无法得到这个节点的前置节点
        //只能采取这样的办法:
        //将后置节点的val值和next引用复制过来
        assert (node.next!=null);
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        if(next==null){
            return ""+val;
        }else{
            return val+"->"+next.toString();
        }
    }
}