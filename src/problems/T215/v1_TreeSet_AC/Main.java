package problems.T215.v1_TreeSet_AC;

import java.util.TreeSet;

class Solution {
    static class NumberUnit implements Comparable<NumberUnit>{
        int index;
        int value;
        static int count = 0;

        public NumberUnit(int value) {
            this.value = value;
            this.index = count++;
        }


        @Override
        public int compareTo(NumberUnit o) {
            if(this.value!=o.value){
                return this.value-o.value;
            }else{
                return this.index-o.index;
            }
        }
    }
    public int findKthLargest(int[] nums, int k) {
        TreeSet<NumberUnit> set = new TreeSet<>();
        for(int i:nums){
            set.add(new NumberUnit(i));
        }
        for(int i =1;i<=nums.length-k;i++){
            set.pollFirst();
        }

        return set.first().value;
    }
}
/**
 * Created by Administrator on 2017/12/17 0017.
 */
/**
 * @anchor https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().findKthLargest(new int[]{3,2,1,5,6,4},2);
            System.out.println(answer);
        }

    }
}
