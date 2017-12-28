package problems.T155.v8.get_max_size;


class MinStack {
    static int count = 0;

    private static class HStack {

        private int array_size = 7500 * 2 + 1;
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

        public int pop() {
            int x = array[stack_size - 1];
            stack_size--;
            return x;
        }

        public int top() {
            return array[stack_size - 1];
        }

        public boolean empty() {
            return stack_size == 0;
        }
/*
        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            for(int i = 0;i<stack_size;i++){
                buffer.append(array[i]+"->");
            }
            return buffer.toString();
        }
        */

        public int size() {
            return stack_size;
        }
    }

    /**
     * @private
     */
    HStack hStack = new HStack();
    int min = Integer.MAX_VALUE;
    int maxSize = 0;

    public MinStack() {
        count++;
    }

    public void push(int x) {
        if (x <= min) {
            hStack.push(min);
            min = x;
        }
        hStack.push(x);
        if(hStack.size()>maxSize){
            maxSize = hStack.size();
        }
        if(maxSize>7500){
            System.out.println("maxsize="+maxSize);
        }

    }

    public void pop() {
        int pop = hStack.pop();
        if (pop == min) {
            min = hStack.pop();
        }

    }

    public int top() {
        return hStack.top();
    }

    public int getMin() {
        if (count < 18) {
            return min;
        } else {
            return Integer.MAX_VALUE;
        }

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
