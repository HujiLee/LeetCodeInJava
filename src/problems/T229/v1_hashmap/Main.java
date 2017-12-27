package problems.T229.v1_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> num2count = new HashMap<>();
        for(int num:nums){
            if(!num2count.containsKey(num)){
                num2count.put(num,1);
            }else{
                num2count.put(num,num2count.get(num)+1);
            }
        }
        List<Integer> majority_nums = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry:num2count.entrySet()){
            if(entry.getValue()*3>nums.length){
                majority_nums.add(entry.getKey());
            }
        }

        return majority_nums;

    }
}
public class Main {
    public static void main(String[] args) {
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1,2,3,1,2,2
            });
            System.out.println(answer);//[2]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{

            });
            System.out.println(answer);//[]
        }
        {
            {
                List<Integer> answer = new Solution().majorityElement(new int[]{
                        1
                });
                System.out.println(answer);//[1]
            }
        }

    }
}
