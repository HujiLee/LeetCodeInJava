package problems.T169.v1_stupid_brute;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> n2count = new HashMap<Integer, Integer>();
        for(int num:nums){
            if(!n2count.containsKey(num)){
                n2count.put(num,1);
            }else {
                n2count.put(num,n2count.get(num)+1);
            }
        }
        for(Map.Entry<Integer,Integer> esls:n2count.entrySet()){
            if(esls.getValue()*2>nums.length){
                return esls.getKey();
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
