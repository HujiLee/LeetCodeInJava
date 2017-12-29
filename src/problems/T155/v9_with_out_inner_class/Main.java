package problems.T155.v9_with_out_inner_class;


class MinStack {


    /**
     * 确保array_size足够大就不需要进行数组扩充
     * @param x
     */
    void hpush(int x) {
        array[stack_size++] = x;
    }

    int hpop() {
        int x = array[stack_size - 1];
        stack_size--;
        return x;
    }

    /**
     * @private
     */
    int min = Integer.MAX_VALUE;
    int array_size = 7501;
    int stack_size = 0;
    int[] array = new int[array_size];


    public void push(int x) {
        if (x <= min) {
            hpush(min);
            min = x;
        }
        hpush(x);
    }

    public void pop() {
        int pop = hpop();
        if (pop == min) {
            min = hpop();
        }

    }

    public int top() {
        return array[stack_size - 1];
    }

    public int getMin() {
        return min;
    }

}

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(9);
        minStack.push(8);
        minStack.push(10);
        minStack.push(6);
        System.out.println(minStack.getMin());//6
        minStack.pop();
        System.out.println(minStack.getMin());//8
        minStack.pop();
        System.out.println(minStack.getMin());//8
        minStack.pop();
        System.out.println(minStack.getMin());//9
        minStack.pop();

    }
}
