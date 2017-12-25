package problems.T128.v1_sort_and_count;

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int longest_length = 1;
        int temp_length = 1;
        for (int num : nums) {
            if (num - prev == 1) {
                temp_length++;
            } else if (num == prev) {
                //do nothing
            } else {
                if (temp_length > 1) {
                    if (temp_length > longest_length) {
                        longest_length = temp_length;
                    }
                    temp_length = 1;
                }
            }

            prev = num;
        }
        if (temp_length > longest_length) {
            longest_length = temp_length;
        }

        return longest_length;
    }

}

public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().longestConsecutive(new int[]{
                    9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7
            });//4
            System.out.println(answer);
        }
        {
            int answer = new Solution().longestConsecutive(new int[]{
                    -3, -4,
            });//2
            System.out.println(answer);
        }
        {
            int answer = new Solution().longestConsecutive(new int[]{
                    -100, -3, -4, -5, -2, -2, -1, 100, 4, 200, 3, 2
            });//5
            System.out.println(answer);
        }
        {
            int answer = new Solution().longestConsecutive(new int[]{
                    100, 4, 200, 1, 3, 2
            });//4
            System.out.println(answer);
        }

    }
}
