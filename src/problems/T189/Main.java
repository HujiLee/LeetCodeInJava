package problems.T189;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

/**
 * @anchor https://leetcode.com/problems/rotate-array/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{-1};
        new Solution().rotate(ints, 2);
    }
}

/**
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * <p>
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II(可惜是Premium)
 */
class Solution {
    void swap(int[] nums, int ia, int ib) {
        nums[ia] = nums[ia] + nums[ib];
        nums[ib] = nums[ia] - nums[ib];
        nums[ia] = nums[ia] - nums[ib];
    }

    void reverse(int[] nums, int from, int to) {
        for (int i = from; i < from + to - i; i++) {
            swap(nums, i, from + to - i);
        }
    }

    /**
     * Custom Testcase
     * Your input[-1,2]  3
     * <p>
     * Expected answer[2,-1]
     * <p>
     * Your input[-1,2]  2
     * <p>
     * Expected answer[-1,2]
     * <p>
     * Your input[-1,2] 1
     * Expected answer[2,-1]
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {

        } else {
            reverse(nums, 0, nums.length - k - 1);
            reverse(nums, nums.length - k, nums.length - 1);
        }
        reverse(nums, 0, nums.length - 1);

    }
}