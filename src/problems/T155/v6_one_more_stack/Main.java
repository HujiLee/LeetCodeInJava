package problems.T155.v6_one_more_stack;


class MinStack {

    private static class HStack {

        private int array_size = 7500;
        private int stack_size = 0;
        private int[] array = new int[array_size];

        public HStack() {

        }

        public void push(int x) {
            if (!(stack_size < array_size)) {
                int[] new_array = new int[array_size * 2];
                for (int i = 0; i < array_size; i++) {
                    new_array[i] = array[i];
                }
                array_size += array_size;
                array = new_array;
            }
            array[stack_size++] = x;
        }

        public void pop() {
            stack_size--;
        }

        public int top() {
            return array[stack_size - 1];
        }

        public boolean empty() {
            return stack_size == 0;
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
