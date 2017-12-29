`private static class`

https://leetcode.com/submissions/detail/133629572/


Submission Detail

18 / 18 test cases passed.

Status: Accepted

Runtime: 103 ms

Submitted: 0 minutes ago

Your runtime beats 80.52 % of java submissions.


https://leetcode.com/submissions/detail/133629646/

Submission Detail

18 / 18 test cases passed.

Status: Accepted

Runtime: 93 ms

Submitted: 0 minutes ago

Your runtime beats 99.77 % of java submissions.

***
模仿分布图里最快的思路,多次提交可能有变化,最快的时候是93ms.
分布图里的92ms解法
↓↓↓↓↓↓↓
```java
class MinStack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        int pop = stack.pop();
        if (pop == min)
            min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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

```

***
```javascript
/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.array = [];
    this.min = Infinity;
    
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    if(x<=this.min){
        this.array.push(this.min);
        this.min = x;
    }
    this.array.push(x);
    
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    var pop = this.array.pop();
    if(pop==this.min){
        this.min = this.array.pop();
    }
    
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.array[this.array.length-1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.min;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = Object.create(MinStack).createNew()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

```
同义的JavaScript解

https://leetcode.com/submissions/detail/133751968/

Submission Detail

18 / 18 test cases passed.

Status: Accepted

Runtime: 108 ms

Submitted: 0 minutes ago

Your runtime beats 83.99 % of javascript submissions.


