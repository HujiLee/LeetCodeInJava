package problems.T719.v2_PriorityQueue_TimeLimitExceeded;

import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/12/17 0017.
 */
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                priorityQueue.offer(Math.abs(nums[i] - nums[j]));
            }
        }
        int result=-1;
        for(int i= 1;i<=k;i++){
          result =   priorityQueue.poll();
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().smallestDistancePair(new int[]{1, 3, 1, 9, 2}, 7);
            System.out.println(answer);
        }
        {
            int answer = new Solution().smallestDistancePair(new int[]{1, 6, 1}, 3);
            System.out.println(answer);
        }

    }
}
