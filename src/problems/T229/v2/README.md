https://leetcode.com/submissions/detail/133484807/

Submission Detail

66 / 66 test cases passed.

Status: Accepted

Runtime: 20 ms

Submitted: 0 minutes ago

Your runtime beats 11.68 % of java submissions.
***
试图模仿[T169.Majority Element](https://leetcode.com/problems/majority-element/description/)里的思路.

可证明,如果某元素x在原数组中的出现概率大于1/3,那么从数组中除掉3个不同的元素后,x在新数组中的出现概率仍然大于1/3.

但是看起来模仿的效果不太好.