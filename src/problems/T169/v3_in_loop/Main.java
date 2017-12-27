package problems.T169.v3_in_loop;

class Solution {
    int[] nums;

    public int majorityElement(int[] $nums) {
        this.nums = $nums;
        int possible_majority_element = candidate(0);
        int count = 0;
        for(int num:nums){
            if(num==possible_majority_element){
                count++;
            }
        }
        if(count*2>nums.length){
            return possible_majority_element;
        }
        return Integer.MIN_VALUE;
    }

    int candidate(int m) {
        int index = m;
        int to_be_compared = nums[m];
        int count = 1;
        while (index < nums.length - 1 && count > 0) {
            index++;
            if (nums[index] == to_be_compared) {
                count++;
            } else {
                count--;
            }
            if(count<=0){
                index = index+1;
                to_be_compared = nums[index];
                count=1;
            }
        }
        if (index == nums.length - 1) {
            return to_be_compared;
        }
        return -1;

    }
}

public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().majorityElement(new int[]{
                     2, 2, 1,2,4,2,1,2,1
            });
            System.out.println(answer);//2
        }
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
