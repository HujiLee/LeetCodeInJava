package problems.T169.v3;

class Solution {
    int[] nums;

    public int majorityElement(int[] $nums) {
        this.nums = $nums;
        int possible_majority_element = candidate(0);
        return possible_majority_element;
//        int count = 0;
//        for(int num:nums){
//            if(num==possible_majority_element){
//                count++;
//            }
//        }
//        if(count*2>nums.length){
//            return possible_majority_element;
//        }
//        return Integer.MIN_VALUE;
    }

    int candidate(int m) {
        int j = m;
        int c = nums[m];
        int count = 1;
        while (j < nums.length - 1 && count > 0) {
            j++;
            if (nums[j] == c) {
                count++;
            } else {
                count--;
            }
        }
        if (j == nums.length - 1) {
            return c;
        } else {
            return candidate(j + 1);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().majorityElement(new int[]{
                    1, 2, 2, 1,2,4,2,1,2
            });
            System.out.println(answer);//2
        }
        {
            int answer = new Solution().majorityElement(new int[]{
                    1, 2, 3, 2, 5, -2, 1, 2, 3, 2, 9, 2, 2, 4, 2, 2, 9, 2, 2, 2
            });
            System.out.println(answer);//2
        }
    }
}
