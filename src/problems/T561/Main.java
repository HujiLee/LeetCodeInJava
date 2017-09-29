package problems.T561;

import java.util.PriorityQueue;

/**
 * @anchor https://leetcode.com/problems/array-partition-i/description/
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        assert nums.length%2==0;
        int n = nums.length/2;
        int _ = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i :nums){
            queue.add(i);
        }
        for(int i = 1;i<=n;i++){
            _+=queue.poll();
            queue.poll();
        }

        return _;
    }
}
public class Main {
    public static void main(String[] args) {
        {
            System.out.println(
                    new Solution().arrayPairSum(new int[]{})
            );
        }
        {
            System.out.println(
                    new Solution().arrayPairSum(new int[]{1,2,9,8,7,5,3,6})
            );
        }



    }
}
