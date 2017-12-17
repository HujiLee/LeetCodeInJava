package problems.T215.v5_Arrays_sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/17 0017.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];

    }
}


public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
            System.out.println(answer);//5
        }

    }
}
