package problems.T215.v2_PriorityQueue_AC;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i:nums){
            priorityQueue.offer(i);
        }
        for(int i = 1;i<=nums.length-k;i++){
            priorityQueue.poll();
        }

        return priorityQueue.poll();
    }
}
/**
 * Created by Administrator on 2017/12/17 0017.
 */
public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().findKthLargest(new int[]{99,99},2);
            System.out.println(answer);
        }
        {
            int answer = new Solution().findKthLargest(new int[]{3,2,1,5,6,4},2);
            System.out.println(answer);
        }
    }
}
