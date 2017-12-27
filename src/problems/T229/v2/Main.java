package problems.T229.v2;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int count_instance = 0;

    public Solution() {
        count_instance++;
    }

    private int[] nums = null;

    public List<Integer> majorityElement(int[] $nums) {
        this.nums = $nums;
        List<Integer> candicates = mysolve(0);
        if (candicates.size() == 0) return candicates;
        Integer[] copy = (Integer[]) candicates.toArray(new Integer[0]);
        int[] counts = new int[candicates.size()];
        for (int num : nums) {
            for (int i = 0; i < counts.length; i++) {
                if (num == candicates.get(i)) {
                    counts[i]++;
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] * 3 <= nums.length) {
                candicates.remove(copy[i]);
            }
        }
        return candicates;

    }

    List<Integer> mysolve(final int i) {
        int sub_length = nums.length - i;
        switch (sub_length) {
            case 0:
                return new ArrayList<Integer>();
            case 1:
                return Arrays.stream(nums, i, nums.length).boxed().collect(Collectors.toList());
            case 2: {
                int a = nums[i];
                int b = nums[i + 1];
                List<Integer> list = new ArrayList<Integer>() {{
                    this.add(a);
                    if (a != b) this.add(b);
                }};
                return list;
            }
            default: {
                int a = nums[i];
                int b = Integer.MIN_VALUE;
                int counta = 1;
                int countb = 0;
                int jndex = i + 1;
                while (jndex < nums.length) {
                    if (nums[jndex] == a) {
                        counta++;
                    } else {
                        if (b == Integer.MIN_VALUE) {
                            b = nums[jndex];
                            int temp = nums[jndex];
                            nums[jndex] = nums[i + 1];
                            nums[i + 1] = temp;
                            countb++;
                        } else if (nums[jndex] == b) {
                            countb++;
                        } else {
                            //switch the place...
                            int temp = nums[jndex];
                            nums[jndex] = nums[i + 2];
                            nums[i + 2] = temp;
                            return mysolve(i + 3);
                        }
                    }
                    jndex++;
                }
                List<Integer> list = new ArrayList<Integer>();
                if (counta * 3 > sub_length) {
                    list.add(a);
                }
                if (countb * 3 > sub_length) {
                    list.add(b);
                }
                return list;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1, 2, 4, 3
            });
            System.out.println(answer);//[]
        }

        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    2, 2, 1, 3
            });
            System.out.println(answer);//[2]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1, 1, 1, 2, 3, 4, 5, 6
            });
            System.out.println(answer);//[1]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1, 2, 2, 3, 2, 1, 1, 3
            });
            System.out.println(answer);//[2,1]
        }
        {
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1, 1, 1, 3, 3, 2, 2, 2
            });
            System.out.println(answer);//[1,2]
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
            List<Integer> answer = new Solution().majorityElement(new int[]{
                    1
            });
            System.out.println(answer);//[1]
        }


    }
}
