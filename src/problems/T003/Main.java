package problems.T003;


import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringV1(String s) {
        int max = s.length();
        if (max == 0)
            return 0;
        for (int l = max; l >= 1; l--) {
            for (int i = 0; i <= max - l; i++) {
                String sub = s.substring(i, i + l);
                if (withoutDupChar(sub)) {
                    return l;
                }
            }
        }
        return 1;
    }

    public boolean withoutDupChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0)
            return true;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (count.containsKey(chars[i])) {
                count.put(chars[i], count.get(chars[i]) + 1);
                return false;
            } else {
                count.put(chars[i], 1);
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.lengthOfLongestSubstringV1("abcabcbb"));
        System.out.println(s1.lengthOfLongestSubstringV1("bbbbb"));
        System.out.println(s1.lengthOfLongestSubstringV1("pwwkew"));
    }
}
