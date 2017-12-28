package problems.T155.v5;



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
            array_size+=array_size;
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
        return min(array,0,stack_size-1);
    }

    private int min(int[] array,int low,int high){
        if(low==high)return array[low];
        if(high-low==1)return min(array[low],array[high]);
        else{
            int mid = (low+high)/2;
            int x = min(array,low,mid);
            int y = min(array,mid+1,high);
            return min(x,y);
        }
    }
    private int min(int a,int b){
        if(a<b)return a;
        return b;
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
