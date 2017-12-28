package problems.T155.v4;



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
        int[] minmax = minmax(0,stack_size-1);
        return minmax[0];
    }
    private int min(int a,int b){
        if(a<b)return a;
        return b;
    }

    private int max(int a,int b){
        if(a<b)return b;
        return a;
    }
    private int[] minmax(int low,int high){
        if(low==high)return new int[]{array[low],array[high]};
        if(high-low==1){
            if(array[low]<array[high]){
                return new int[]{array[low],array[high]};
            }else {
                return new int[]{array[high],array[low]};
            }
        }else{
            int mid = (low+high)/2;
            int[] x1y1 = minmax(low,mid);
            int[] x2y2 = minmax(mid+1,high);
            int x = min(x1y1[0],x2y2[0]);
            int y = max(x1y1[1],x2y2[1]);
            return new int[]{x,y};
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
