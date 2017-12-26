package problems.T169.v2_sort_first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().majorityElement(new int[]{
                    1,2,3,2,5,-2,1,2,3,2,9,2,2,4,2,2,9,2,2,2
            });
            System.out.println(answer);//2
        }

    }
}
