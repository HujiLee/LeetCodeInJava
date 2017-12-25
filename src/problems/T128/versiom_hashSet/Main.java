package problems.T128.versiom_hashSet;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
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
