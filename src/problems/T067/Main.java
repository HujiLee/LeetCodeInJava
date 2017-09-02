package problems.T067;

/**
 * Created by Administrator on 2017/9/3 0003.
 */
class Solution {
    int add(char n1,char n2){
        int i1 = (n1=='1')?1:0;
        int i2 = (n2=='1')?1:0;
        return i1+i2;
    }
    public String addBinary(String a, String b) {
        while (a.length()<b.length()){
            a = "0"+a;
        }
        while (b.length()<a.length()){
            b = "0"+b;
        }
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        int length =achars.length+1;
        char[] sum = new char[length];

        int i = length-2;
        int digit,carry=0,tempSum;
        while (true){
            tempSum = add(achars[i],bchars[i])+carry;
            digit = tempSum%2;
            carry = tempSum/2;
            sum[i+1] = (digit==1)?'1':'0';
            i--;
            if(i<0){
                break;
            }
        }
        sum[0]=(carry==1)?'1':'0';
        String result = String.valueOf(sum);
        if(result.indexOf("0")==0){
            result = result.substring(1);
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11","1"));

    }
}
/*
https://leetcode.com/submissions/detail/116728726/
Submission Details
294 / 294 test cases passed.
Status: Accepted
Runtime: 4 ms
Submitted: 0 minutes ago

 */