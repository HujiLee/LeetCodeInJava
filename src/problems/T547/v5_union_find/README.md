https://leetcode.com/submissions/detail/132998073/

Submission Detail

113 / 113 test cases passed.

Status: Accepted

Runtime: 13 ms

Submitted: 0 minutes ago

Your runtime beats 39.34 % of java submissions.

***

在v4的基础上使用了基于树的大小的UNION(或者叫基于重量):让较小的树作为较大的树的一颗子树.

基于树的大小的UNION策略和路径合并的FIND策略不冲突,同时使用.

但是相比v4的随机UNION,运行时间并没有明显的改善,也在12~15ms的范围内.