package problems.T128.v5;

import java.util.PriorityQueue;


class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(){{
            for (int num : nums) {
                this.add(num);
            }
        }};

        int longest = 1;
        int prev = Integer.MIN_VALUE;
        int temp_length = 1;
        while (priorityQueue.size()>0){
            int smallest = priorityQueue.poll();
            int diff = smallest-prev;
            switch (diff){
                case 0:break;
                case 1:{
                    temp_length++;
                    break;
                }
                default:{
                    if(temp_length>longest){
                        longest = temp_length;
                    }
                    temp_length=1;
                }
            }
            prev = smallest;
        }
        if (temp_length > longest) {
            longest = temp_length;
        }


        return longest;
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
