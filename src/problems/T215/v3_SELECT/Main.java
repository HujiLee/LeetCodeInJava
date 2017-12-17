package problems.T215.v3_SELECT;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return select(nums,0,nums.length-1,nums.length-k+1);
    }

    /**
     * 获取[low,high+1)范围内第k小的元素
     * @param nums
     * @param low
     * @param high
     * @param k k>=1,k<=n
     * @return
     */
    int select(int[] nums, int low, int high, int k) {
        int length = high-low+1;
        if (length <= 8) {//44
            Arrays.sort(nums, low, high+1);
            return nums[low+k-1];
        }
        int q = length/5;
        int[] M = new int[q];
        for(int i = 0;i<q;i++){
            Arrays.sort(nums,low+i*5,low+(i+1)*5);
            M[i] = nums[low+i*5+2];//中位数
        }
        int mm = select(M,0,q-1,q/2+1);
        ArrayList<Integer> A1 = new ArrayList<Integer>();
        ArrayList<Integer> A2 = new ArrayList<Integer>();
        ArrayList<Integer> A3 = new ArrayList<Integer>();
        for(int i =  low;i<=high;i++){
            if(nums[i]<mm){
                A1.add(nums[i]);
            }else if(nums[i]==mm){
                A2.add(nums[i]);
            }else{
                A3.add(nums[i]);
            }
        }

        if(A1.size()>=k){
            int[] arr = A1.stream().mapToInt(i->i).toArray();
            return select(arr,0,arr.length-1,k);
        }else if(A1.size()+A2.size()>=k){
            return mm;
        }else if(A1.size()+A2.size()<k){
            int[] arr = A3.stream().mapToInt(i->i).toArray();
            return  select(arr,0,arr.length-1,k-A1.size()-A2.size());
        }


        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().findKthLargest(new int[]{3, 3,3,3,4,3,3,3,3}, 9);
            System.out.println(answer);//3
        }
        {
            int answer = new Solution().findKthLargest(new int[]{3, 2, 1, 4}, 2);
            System.out.println(answer);//3
        }
        {
            int answer = new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
            System.out.println(answer);//5
        }
        {
            int[] arr = new int[]{1,2,3,-1,-2,-3};
            Arrays.sort(arr,1,3+1);//[1,-1,2,3,-2,-3]
            System.out.println(arr);
        }

    }
}
