package problems.T155.v7_one_more_stack;


class MinStack {

    private static class HStack {
        private static class Node{
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head=null;
        public HStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            node.next = head;
            head = node;
        }

        public void pop() {
            head = head.next;
        }

        int top() {
            return head.val;
        }

        boolean empty() {
            return head==null;
        }
    }

    private HStack hStack = new HStack();
    private HStack min_hstack = new HStack();

    public MinStack() {

    }

    public void push(int x) {
        hStack.push(x);
        if (min_hstack.empty()) {
            min_hstack.push(x);
        } else {
            if (x <= min_hstack.top()) {
                min_hstack.push(x);
            }
        }
    }

    public void pop() {
        int x = hStack.top();
        hStack.pop();
        if (x == min_hstack.top()) {
            min_hstack.pop();
        }

    }

    public int top() {
        return hStack.top();
    }

    public int getMin() {
        return min_hstack.top();
    }
}

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(9);
        minStack.push(-2);
        minStack.push(-3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
