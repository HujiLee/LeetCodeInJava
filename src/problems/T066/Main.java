package problems.T066;

import java.util.Arrays;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * 用数组的形式表示一个大整数
 * 计算这个整数+1后的结果
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int[] plusedOne = new int[digits.length + 1];
        int carry = 1;
        int i = digits.length - 1;
        int digit, tempSum;
        while (true) {
            if (i >= 0) {
                tempSum = carry + digits[i];
                digit = tempSum % 10;
                carry = tempSum / 10;
                plusedOne[i + 1] = digit;
                i--;
            } else {
                break;
            }
        }
        if (carry != 0) {
            plusedOne[0] = carry;
            return plusedOne;
        } else {
            for (i = 0; i < digits.length; i++) {
                digits[i] = plusedOne[i + 1];
            }
            return digits;
        }
    }
}
/**
 * @anchor https://leetcode.com/problems/plus-one/description/
 */

/**
 * Created by Administrator on 2017/9/3 0003.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{0})));
    }
}
/*
Submission Details
108 / 108 test cases passed.
Status: Accepted
Runtime: 0 ms
Submitted: 0 minutes ago

 */