https://leetcode.com/submissions/detail/133626015/

Submission Detail

18 / 18 test cases passed.

Status: Accepted

Runtime: 113 ms

Submitted: 0 minutes ago

Your runtime beats 39.79 % of java submissions.

***
相当于v2的改进,使用自己实现的stack.相对于v2有进步.
***

`private static class`
HStack栈的初始容量和速度的关系->

    10000->108ms
    6000->111ms
    4000->105ms
    2000->110ms
    1000->145ms
~~private static~~ `class`
HStack栈的初始容量和速度的关系->

    1000->108ms
    2000->110ms
    4000->122ms
    6000->113ms
    7000->112ms
    8000->101ms/111ms/132ms
    9000->112ms
    10000->115ms
    
~~private~~ static `class`

1000->118ms
2000->122ms
4000->103ms
8000->109ms
10000->130ms
15000->114ms

