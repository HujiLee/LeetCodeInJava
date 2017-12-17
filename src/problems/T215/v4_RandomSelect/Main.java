package problems.T215.v4_RandomSelect;


import java.util.ArrayList;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return rselect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    /**
     * 获取nums中的[low,high]中第k小的元素
     *
     * @param nums
     * @param low
     * @param high
     * @param k    1<=k<=nums.length
     * @return
     */
    private int rselect(int[] nums, int low, int high, int k) {
        int v = (int) (Math.random() * (high - low + 1) + low);
        int x = nums[v];
        ArrayList<Integer> A1 = new ArrayList<Integer>();
        ArrayList<Integer> A2 = new ArrayList<Integer>();
        ArrayList<Integer> A3 = new ArrayList<Integer>();
        for (int i = low; i <= high; i++) {
            if (nums[i] < x) {
                A1.add(nums[i]);
            } else if (nums[i] == x) {
                A2.add(nums[i]);
            } else {
                A3.add(nums[i]);
            }
        }
        if (A1.size() >= k) {
            int[] arr = A1.stream().mapToInt(i -> i).toArray();
            return rselect(arr, 0, arr.length - 1, k);
        } else if (A1.size() + A2.size() >= k) {
            return x;
        } else if (A1.size() + A2.size() < k) {
            int[] arr = A3.stream().mapToInt(i -> i).toArray();
            return rselect(arr, 0, arr.length - 1, k - A1.size() - A2.size());
        }

        return -1;
    }


}


public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().findKthLargest(new int[]{3, 3, 3, 3, 4, 3, 3, 3, 3}, 9);
            System.out.println(answer);
        }
        {
            int answer = new Solution().findKthLargest(new int[]{3, 2, 1, 4}, 2);
            System.out.println(answer);//3
        }
        {
            int answer = new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
            System.out.println(answer);//5
        }

    }
}
