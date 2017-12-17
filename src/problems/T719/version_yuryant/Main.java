package problems.T719.version_yuryant;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/17 0017.
 */
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] - nums[0];
        int array[] = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = Math.abs(nums[j] - nums[i]);
                array[diff]++;
            }
        }
        int sum = 0;
        int res = 0;
        for (int i = 0; i <= max; i++) {
            sum += array[i];
            if (sum >= k) {
                res = i;
                break;
            }
        }
        return res;
    }
}


public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().smallestDistancePair(new int[]{1, 3, 1, 9, 2}, 7);
            System.out.println(answer);
        }
    }
}
