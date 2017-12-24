https://leetcode.com/submissions/detail/133105010/

Submission Detail

52 / 52 test cases passed.

Status: Accepted

Runtime: 269 ms

Submitted: 0 minutes ago

Your runtime beats 0.17 % of java submissions.
***

思路是

1. 对于edges,从后往前遍历,针对每个edge,考虑在缺少edge的情况下建立图

2. 看这个图是否是合法的单个有向root树
    * 合法的话,应该有且只有一个root
    * 合法的话,应该不存在环
    * 合法的话,应该不存在一个child对应多个parent的情况
    
虽然AC了,但是相当慢.

