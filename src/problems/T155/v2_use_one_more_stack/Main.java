package problems.T155.v2_use_one_more_stack;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min_stack = new Stack<Integer>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(min_stack.empty()){
            min_stack.push(x);
        }else{
            if(x<=min_stack.peek()){
                min_stack.push(x);
            }
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x==min_stack.peek()){
            min_stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
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
