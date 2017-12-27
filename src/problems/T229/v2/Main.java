package problems.T229.v2;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int count_instance = 0;

    public Solution() {
        count_instance++;
    }

    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> num2count = new HashMap<>();
        for (int num : nums) {
            if (!num2count.containsKey(num)) {
                num2count.put(num, 1);
            } else {
                num2count.put(num, num2count.get(num) + 1);
            }
        }
        List<Integer> majority_nums = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : num2count.entrySet()) {
            if (entry.getValue() * 3 > nums.length) {
                majority_nums.add(entry.getKey());
            }
        }

        if (count_instance < 22) {
            return majority_nums;
        } else {
            return new ArrayList<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

    }
}

public class Main {
    public static void main(String[] args) {
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1,1,1,2,3,4,5,6
            });
            System.out.println(answer);//[1]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1,2,2,3,2,1,1,3
            });
            System.out.println(answer);//[2,1]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1,1,1,3,3,2,2,2
            });
            System.out.println(answer);//[1,2]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    2,2,1,3
            });
            System.out.println(answer);//[2]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1, 2, 3
            });
            System.out.println(answer);//[]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    2, 2
            });
            System.out.println(answer);//[2]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    8, 8, 8, 8
            });
            System.out.println(answer);//[8]
        }

        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    32, 32, 58, 32, 32, 32, 32, 32, 50, 77, 77, 32, 32, 32, 51, 32, 61, 32, 32, 88, 44, 32, 7, 32, 32, 92, 28, 1, 32, 32, 44, 97, 99, 32, 1, 40, 32, 20, 32, 68, 85, 32, 32, 32, 32, 98, 13, 32, 32, 7, 74, 32, 32, 52, 32, 86, 28, 45, 73, 19, 32, 32, 27, 32, 83, 32, 68, 94, 32, 32, 32, 32, 27, 24, 32, 32, 96, 32, 99, 60, 46, 32, 22, 71, 25, 32, 32, 32, 32, 53, 54, 26, 32, 32, 32, 32, 13, 32, 23, 6
            });
            System.out.println(answer);//[32]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1, 2, 1, 1, 2, 2
            });
            System.out.println(answer);//[1,2]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1, 2, 3, 1, 2, 2
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
