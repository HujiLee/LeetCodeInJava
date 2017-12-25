package problems.T128.v3_can_i_replace_treeset_with_hashset;

import java.util.HashSet;
import java.util.Set;


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(){{
           for(int num:nums){
               this.add(num);
           }
        }};
        int longest = 0;
        Set<Integer> set_copy = new HashSet<Integer>(set);
        for(Integer integer:set){
            if(set_copy.contains(integer)&&!set.contains(integer-1)){
                int temp = 1;
                int add_offset = 1;
                while (true){
                    int next = integer+add_offset;
                    if(set.contains(next)){
                        set_copy.remove(next);
                        temp++;
                        add_offset++;
                    }else {

                        break;
                    }
                }
                if(temp>longest){
                    longest = temp;
                }
            }
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
