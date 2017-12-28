package problems.T155.v3_use_array_and_arrays_sort;


import java.util.Arrays;

class MinStack {

    private int array_size = 1000;
    private int stack_size = 0;
    private int[] array = new int[array_size];
    public MinStack() {

    }

    public void push(int x) {
        if(!(stack_size<array_size)){
            int[] new_array = new int[array_size*2];
            for(int i = 0;i<array_size;i++){
                new_array[i] = array[i];
            }
            array_size*=2;
            array = new_array;
        }
        array[stack_size++] = x;
    }

    public void pop() {
        stack_size--;
    }

    public int top() {
        return array[stack_size-1];
    }

    public int getMin() {
        int[] temp_array = new int[stack_size];
        for(int i = 0;i<stack_size;i++){
            temp_array[i] = array[i];
        }
        Arrays.sort(temp_array);
        return temp_array[0];
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
