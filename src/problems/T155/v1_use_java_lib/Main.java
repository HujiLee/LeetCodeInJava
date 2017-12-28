package problems.T155.v1_use_java_lib;

import java.util.Collections;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return Collections.min(stack);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class Main {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(9);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }
}
