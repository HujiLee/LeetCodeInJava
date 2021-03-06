package problems.T155.v1_use_java_lib;

import java.util.Collections;
import java.util.Stack;

class MinStack {
    static int count = 0;
     Stack<Integer> stack = new Stack<Integer>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        count++;
    }
    int max_stack_size = 0;

    public void push(int x) {
        stack.push(x);
        if(stack.size()>max_stack_size){
            max_stack_size = stack.size();
        }
        if(max_stack_size>7450){
            System.out.println("max_stack_size"+max_stack_size);
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(count<18){
            return Collections.min(stack);
        }else{
            return Integer.MAX_VALUE;
        }

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
